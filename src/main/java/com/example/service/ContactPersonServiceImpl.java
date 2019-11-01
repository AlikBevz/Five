package com.example.service;


import com.example.entity.ContactPerson;
import com.example.repository.ContactPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service

@RequiredArgsConstructor
public class ContactPersonServiceImpl implements ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;

    @Override
    public ContactPerson getById(Long id) {
        return null;
    }

    @Override
    public ContactPerson save(ContactPerson contactPerson) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Collection<ContactPerson> getAll() {
        log.info("ContactPersonService getALL");
        return contactPersonRepository.findAll();

    }
}
