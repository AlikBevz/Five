package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="vacancies")
@Getter
@Setter
@ToString
public class Vacancy extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "show_all")
    private Boolean showAll;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactPerson contactPerson;

}
