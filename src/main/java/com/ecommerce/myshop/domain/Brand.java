package com.ecommerce.myshop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String Country;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;

    public Brand(String name) {
        this.name = name;
    }
}
