package com.Rasadnici.Rasadnici.Order.OrderService;

import java.util.List;

import com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder;

public interface CustomerServingOrderService {

    public List<? extends CustomerOrder> getAllOrders();

    public void approveCustomerOrder(long id);

    public void declineCustomerOrder(long id);

}