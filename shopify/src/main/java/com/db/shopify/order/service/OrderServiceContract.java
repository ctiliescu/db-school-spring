package com.db.shopify.order.service;

import com.db.shopify.order.model.Order;

import java.util.List;

public interface OrderServiceContract {
    public List<Order> getAll();
    public Order getById(Long id);
    public Order insertOrder(Order order);
    public Order updateOrder(Order order) throws IllegalAccessException, CloneNotSupportedException;
    public Order deleteOrderById(Long id);
}
