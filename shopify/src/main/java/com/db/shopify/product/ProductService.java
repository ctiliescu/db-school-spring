package com.db.shopify.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceContract {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByCode(String code){
        Optional<Product> productOptional = productRepository.getByCode(code);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    public Product insertProduct(Product product){
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Product product) throws IllegalAccessException, CloneNotSupportedException {
        Product oldProduct = (Product) productRepository.getById(product.getCode()).clone();
        productRepository.save(product);
        return oldProduct;
    }

    public Product deleteProductByCode(String code){
        Product oldProduct = productRepository.getById(code);
        productRepository.deleteById(code);
        return oldProduct;
    }
}
