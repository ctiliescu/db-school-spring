package com.db.shopify.order.service;

import com.db.shopify.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceContract {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getById(Long id){
        return orderRepository.getById(id);
    }

    public Order insertOrder(Order order){
        orderRepository.save(order);
        return order;
    }

    public Order updateOrder(Order order) throws IllegalAccessException, CloneNotSupportedException {
        Order oldOrder = (Order) orderRepository.getById(order.getId()).clone();
        orderRepository.save(order);
        return oldOrder;
    }

    public Order deleteOrderById(Long id){
        Order oldOrder = orderRepository.getById(id);
        orderRepository.deleteById(id);
        return oldOrder;
    }
}
