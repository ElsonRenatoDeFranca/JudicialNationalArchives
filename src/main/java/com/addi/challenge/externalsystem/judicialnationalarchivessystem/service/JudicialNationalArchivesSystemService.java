package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;

import java.util.List;

public interface JudicialNationalArchivesSystemService {
    List<Person> findAll();
    Person findPersonById(Long PersonId);
    Person addPerson(Person person);
    void deleteById(Long personId);
}
