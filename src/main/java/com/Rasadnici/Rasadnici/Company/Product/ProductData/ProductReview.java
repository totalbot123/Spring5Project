package com.Rasadnici.Rasadnici.Company.Product.ProductData;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Rasadnici.Rasadnici.BaseEntity;

import lombok.Data;

@Entity
@Data
public class ProductReview extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String comment;

    private int grade;

}