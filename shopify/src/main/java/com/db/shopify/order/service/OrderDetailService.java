package com.db.shopify.order.service;

import com.db.shopify.order.model.OrderDetail;
import com.db.shopify.product.Product;
import com.db.shopify.product.ProductServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class OrderDetailService implements OrderDetailServiceContract {

    private Logger logger = LoggerFactory.getLogger(OrderDetailService.class);

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductServiceContract productService;

    public List<OrderDetail> getAll(){
        return orderDetailRepository.findAll();
    }

    public OrderDetail getById(Long id){
        return orderDetailRepository.getById(id);
    }

    public OrderDetail insertOrderDetail(OrderDetail orderDetail) throws IllegalAccessException, CloneNotSupportedException {
        Product product = productService.getByCode(orderDetail.getProductCode());
        if (product == null) {
            logger.warn("There is no product with code " + orderDetail.getProductCode());
            return null;
        }
        int newStock = product.getStock() - orderDetail.getQuantity();
        if (newStock < 0) {
            logger.warn("The maximum quantity available is " + product.getStock());
            return null;
        }
        product.setStock(product.getStock() - orderDetail.getQuantity());
        orderDetailRepository.save(orderDetail);
        productService.updateProduct(product);
        return orderDetail;
    }

    public OrderDetail updateOrderDetail(OrderDetail orderDetail) throws IllegalAccessException, CloneNotSupportedException {
        OrderDetail oldOrderDetail = (OrderDetail) orderDetailRepository.getById(orderDetail.getId()).clone();
        Product oldProduct = productService.getByCode(oldOrderDetail.getProductCode());
        if(orderDetail.getProductCode().equals(oldOrderDetail.getProductCode())) {
            int newStock = oldProduct.getStock() + oldOrderDetail.getQuantity() - orderDetail.getQuantity();
            if(newStock < 0) {
                logger.warn("The maximum new quantity available if update is " + (oldProduct.getStock() + oldOrderDetail.getQuantity()));
                return null;
            }
            oldProduct.setStock(newStock);
            productService.updateProduct(oldProduct);
        } else {
            Product newProduct = productService.getByCode(orderDetail.getProductCode());
            if (newProduct == null) {
                logger.warn("There is no product with code " + orderDetail.getProductCode());
                return null;
            }
            int newStockNewProduct = newProduct.getStock() - orderDetail.getQuantity();
            if (newStockNewProduct < 0) {
                logger.warn("The maximum quantity available is " + newProduct.getStock() + " for product with code " + newProduct.getCode());
                return null;
            }
            oldProduct.setStock(oldProduct.getStock() + oldOrderDetail.getQuantity());
            newProduct.setStock(newStockNewProduct);
            productService.updateProduct(oldProduct);
            productService.updateProduct(newProduct);
        }
        orderDetailRepository.save(orderDetail);
        return oldOrderDetail;
    }

    public OrderDetail deleteOrderDetailById(Long id) throws IllegalAccessException, CloneNotSupportedException {
        OrderDetail oldOrderDetail = orderDetailRepository.getById(id);
        Product product = productService.getByCode(oldOrderDetail.getProductCode());
        product.setStock(product.getStock() + oldOrderDetail.getQuantity());
        orderDetailRepository.deleteById(id);
        productService.updateProduct(product);
        return oldOrderDetail;
    }
}
