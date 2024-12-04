package com.javaacademy.car_avito.announcement;

import org.springframework.stereotype.Component;

@Component
public class UniqueIdentifier {
    private int number;

    public String generateNumber() {
        number++;
        return "A" + number;
    }
}
