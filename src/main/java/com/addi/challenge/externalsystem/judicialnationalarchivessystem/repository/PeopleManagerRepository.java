package com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository;


import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleManagerRepository extends JpaRepository<Person, Long> {
    Person findByNationalIdentificationNumber(String nationalIdentificationNumber);
}
