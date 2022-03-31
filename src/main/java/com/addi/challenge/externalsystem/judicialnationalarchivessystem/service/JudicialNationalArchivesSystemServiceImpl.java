package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.exception.PersonNotFoundException;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService{

    private final JudicialNationalArchivesSystemRepository repository;

    private static final String PERSON_NOT_FOUND_EXCEPTION = "Person not found";

    public JudicialNationalArchivesSystemServiceImpl(JudicialNationalArchivesSystemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people  = repository.findAll();
        return people;
    }

    @Override
    public Person findById(Long personId){
        try {
            return repository.findById(personId).orElseThrow(() -> new PersonNotFoundException(PERSON_NOT_FOUND_EXCEPTION));
        } catch (PersonNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void deleteById(Long personId) {
        repository.deleteById(personId);
    }
}
