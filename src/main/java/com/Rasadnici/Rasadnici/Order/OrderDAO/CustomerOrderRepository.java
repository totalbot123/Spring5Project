package com.Rasadnici.Rasadnici.Order.OrderDAO;

import com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder;

import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

}