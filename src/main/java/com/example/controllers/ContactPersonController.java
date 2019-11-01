package com.example.controllers;

import com.example.dto.ContactPersonDto;
import com.example.entity.ContactPerson;
import com.example.service.ContactPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/v1/contact-persons")

@RequiredArgsConstructor
public class ContactPersonController {

    private final ContactPersonService contactPersonService;
    private final ModelMapper modelMapper;

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<ContactPersonDto>> getContactPerson(){
        return ResponseEntity.ok(contactPersonService.getAll()
                                    .stream()
                                    .map(ContactPerson->modelMapper.map(ContactPerson, ContactPersonDto.class))
                                    .collect(Collectors.toList()));
    }
}
