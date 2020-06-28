package com.Rasadnici.Rasadnici.Order.OrderService;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public void approveOrder();

    public void declineOrder();

}