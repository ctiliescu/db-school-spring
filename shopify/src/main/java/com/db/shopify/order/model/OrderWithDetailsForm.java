package com.db.shopify.order.model;

import com.db.shopify.order.model.Order;
import com.db.shopify.order.model.OrderDetail;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class OrderWithDetailsForm {
    public Order order;
    public List<OrderDetail> orderDetailList;
}
