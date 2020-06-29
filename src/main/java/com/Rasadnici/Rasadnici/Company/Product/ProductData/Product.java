package com.Rasadnici.Rasadnici.Company.Product.ProductData;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.Rasadnici.Rasadnici.BaseEntity;
import com.Rasadnici.Rasadnici.Item.ItemData.Item;

import lombok.Data;

@Data
@Entity
public class Product extends BaseEntity {

    @OneToMany(mappedBy = "product")
    private Set<Item> items;

    @OneToMany(mappedBy = "product")
    private Set<ProductReview> reviews;

    private int inventory;

}