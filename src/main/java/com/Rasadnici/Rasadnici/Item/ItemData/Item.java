package com.Rasadnici.Rasadnici.Item.ItemData;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Rasadnici.Rasadnici.BaseEntity;
import com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder;

import lombok.Data;

@Data
@Entity
public class Item extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private CustomerOrder product;

    private int quantity;

}
