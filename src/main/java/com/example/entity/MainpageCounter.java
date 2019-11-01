package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mainpage_counters")
@Getter
@Setter
@ToString
public class MainpageCounter extends BaseEntity {
    @Column(name="counter_services")
    private int counterServices;
    @Column(name="counter_products")
    private int counterProducts;
    @Column(name="counter_customers")
    private int counterCustomers;
    @Column(name="counter_vacancies")
    private int counterVacancies;
}
