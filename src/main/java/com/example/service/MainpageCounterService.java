package com.example.service;

import com.example.entity.MainpageCounter;

import java.util.Collection;


public interface MainpageCounterService {

    MainpageCounter getById(Long id);

    MainpageCounter save (MainpageCounter mainpageCounter);

    void delete (Long id);

    Collection<MainpageCounter> getAll();

}
