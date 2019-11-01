package com.example.repository;

import com.example.entity.MainpageCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<MainpageCounter, Long> {
}
