package com.ecommerce.myshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "barcode", "name"})
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String img;

    private BigDecimal price;

    private String barcode;

    public Product(long id, String name, String barcode) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
    }
}
