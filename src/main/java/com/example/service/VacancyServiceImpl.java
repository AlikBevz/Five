package com.example.service;

import com.example.entity.Vacancy;
import com.example.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service

@RequiredArgsConstructor

public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    @Override
    public Vacancy getById(Long id) {
        return null;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Collection<Vacancy> getAll() {
        return null;
    }
}
