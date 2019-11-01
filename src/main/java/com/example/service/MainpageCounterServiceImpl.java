package com.example.service;

import com.example.entity.MainpageCounter;
import com.example.repository.MainpageCounterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;


@Slf4j
@Service

@RequiredArgsConstructor
public class MainpageCounterServiceImpl implements MainpageCounterService {

    private final MainpageCounterRepository mainpageCounterRepository;

    @Override
    public MainpageCounter getById(Long id) {
        log.info("MainpageCounterServiceImpl getById {}", id);
        return mainpageCounterRepository.getOne(id);
    }

    @Override
    @Transactional
    public MainpageCounter save(MainpageCounter mainpageCounter) {
        log.info("MainpageCounterServiceImpl save {}", mainpageCounter);
        MainpageCounter createdMainpageCounter = mainpageCounterRepository.save(mainpageCounter);
        return createdMainpageCounter;
    }

    @Override
    public void delete(Long id) {
        log.info("MainpageCounterServiceImpl deleteById {}", id);
        mainpageCounterRepository.deleteById(id);

    }

    @Override
    public Collection<MainpageCounter> getAll() {
        log.info("MainpageCounterServiceImpl getAll");
        return mainpageCounterRepository.findAll();
    }
}
