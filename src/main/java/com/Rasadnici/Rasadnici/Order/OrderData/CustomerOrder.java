package com.Rasadnici.Rasadnici.Order.OrderData;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Rasadnici.Rasadnici.BaseEntity;
import com.Rasadnici.Rasadnici.Company.CompanyData.Company;
import com.Rasadnici.Rasadnici.Item.ItemData.Item;
import com.Rasadnici.Rasadnici.Security.Data.Farmer;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_order")
public class CustomerOrder extends BaseEntity {

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

    @Column(name = "order_state")
    private OrderState orderState;

    @OneToMany(mappedBy = "order")
    private Set<Item> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_id", referencedColumnName = "id", nullable = false)
    private Farmer farmer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

}