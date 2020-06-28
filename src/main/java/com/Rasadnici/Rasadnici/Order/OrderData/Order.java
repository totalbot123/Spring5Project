package com.Rasadnici.Rasadnici.Order.OrderData;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.Rasadnici.Rasadnici.BaseEntity;

import lombok.Data;

@Data
@Entity
public class Order extends BaseEntity {

    public static enum OrderState {
        PENDING(0), SHIPPED(1), DONE(2);

        private final int value;

        private OrderState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Column(name = "order_state", columnDefinition = "tinyint(1) default 0")
    private OrderState orderState;

    @OneToMany(mappedBy = "order")
    private Set<Item> items;

}