package com.javaacademy.car_avito.announcement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
public class Announcement {
    private String id;
    private String brandName;
    private String color;
    private BigDecimal price;
}
