package com.Rasadnici.Rasadnici.Order.OrderService;

import org.springframework.stereotype.Service;

@Service
public interface CustomerOrderService {

    public void approveOrder();

    public void declineOrder();

}