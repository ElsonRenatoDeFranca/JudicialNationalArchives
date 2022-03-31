package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;

import java.util.List;

public interface JudicialNationalArchivesSystemService {
    List<Person> findAll();

    Person findById(Long PersonId);

    Person save(Person person);

    void deleteById(Long personId);
}
