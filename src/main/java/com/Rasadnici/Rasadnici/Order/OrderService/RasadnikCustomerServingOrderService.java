package com.Rasadnici.Rasadnici.Order.OrderService;

import static com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder.OrderState.SHIPPED;
import static com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder.OrderState.CANCELED;

import java.util.List;

import com.Rasadnici.Rasadnici.Order.OrderDAO.CustomerOrderRepository;
import com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder;
import com.google.common.collect.Lists;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RasadnikCustomerServingOrderService implements CustomerServingOrderService {

    private CustomerOrderRepository customerOrderRepository;

    @Override
    public List<? extends CustomerOrder> getAllOrders() {
        Iterable<? extends CustomerOrder> iterable = customerOrderRepository.findAll();
        return Lists.newArrayList(iterable);
    }

    @Override
    public void approveCustomerOrder(long id) {
        CustomerOrder customerOrder = customerOrderRepository.findById(id).get();
        customerOrder.setOrderState(SHIPPED);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public void declineCustomerOrder(long id) {
        CustomerOrder customerOrder = customerOrderRepository.findById(id).get();
        customerOrder.setOrderState(CANCELED);
        customerOrderRepository.save(customerOrder);
    }

}