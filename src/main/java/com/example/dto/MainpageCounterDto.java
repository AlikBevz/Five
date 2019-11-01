package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainpageCounterDto {

    private Long id;
    private int counterServices;
    private int counterProducts;
    private int counterCustomers;
    private int counterVacancies;
}
