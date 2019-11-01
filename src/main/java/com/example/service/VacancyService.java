package com.example.service;

import com.example.entity.Vacancy;

import java.util.Collection;

public interface VacancyService {

    Vacancy getById (Long id);

    Vacancy save (Vacancy vacancy);

    void delete (Long id);

    Collection<Vacancy> getAll();
}
