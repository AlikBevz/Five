package com.example.service;

import com.example.entity.ContactPerson;

import java.util.Collection;

public interface ContactPersonService {

    ContactPerson getById (Long id);

    ContactPerson save (ContactPerson contactPerson);

    void delete (Long id);

    Collection<ContactPerson> getAll();


}
