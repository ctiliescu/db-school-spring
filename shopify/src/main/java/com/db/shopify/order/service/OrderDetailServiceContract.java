package com.db.shopify.order.service;

import com.db.shopify.order.model.OrderDetail;

import java.util.List;

public interface OrderDetailServiceContract {
    public List<OrderDetail> getAll();
    public OrderDetail getById(Long id);
    public OrderDetail insertOrderDetail(OrderDetail orderDetail) throws IllegalAccessException, CloneNotSupportedException;
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) throws IllegalAccessException, CloneNotSupportedException;
    public OrderDetail deleteOrderDetailById(Long id) throws IllegalAccessException, CloneNotSupportedException;
}
