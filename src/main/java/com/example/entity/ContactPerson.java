package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="contact_persons")
@Getter
@Setter
@ToString
public class ContactPerson extends BaseEntity {
    @Column(name="name")
    private String name;

    @Column(name="position")
    private String position;

    @Column(name="mail")
    private String mail;

    @OneToMany (mappedBy = "contactPerson")
    private Set<Vacancy> vacancies;

}
