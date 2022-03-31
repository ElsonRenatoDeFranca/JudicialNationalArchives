package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.exception.PersonNotFoundException;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService{

    @Autowired
    private JudicialNationalArchivesSystemRepository repository;

    private static final String PERSON_NOT_FOUND_EXCEPTION = "Person not found";

    @Override
    public List<Person> findAll() {
        /*List<Customer> customers  = new ArrayList<>();
        customers.add(Customer.builder().nationalIdentificationNumber("0001").age(21).firstName("John").build());
        customers.add(Customer.builder().nationalIdentificationNumber("0002").age(25).firstName("Mary").build());
        customers.add(Customer.builder().nationalIdentificationNumber("0003").age(12).firstName("Antoine").build());
        return customers;*/
        return repository.findAll();
    }

    @Override
    public Person findPersonById(Long personId){
       //return Customer.builder().nationalIdentificationNumber("0001").age(11).firstName("George Washington").build() ;
        try {
            return repository.findById(personId).orElseThrow(() -> new PersonNotFoundException(PERSON_NOT_FOUND_EXCEPTION));
        } catch (PersonNotFoundException e) {
            e.getLocalizedMessage();
            return null;
        }
    }

    @Override
    public Person addPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deleteById(Long personId) {
        repository.deleteById(personId);
    }
}
