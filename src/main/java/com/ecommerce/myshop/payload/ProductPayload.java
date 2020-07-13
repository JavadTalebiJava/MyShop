package com.ecommerce.myshop.payload;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductPayload {

    private String name;

    private String img;

    private BigDecimal price;

    private String barcode;
}
