package com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudicialNationalArchivesSystemRepository extends JpaRepository<Person, Long> {
}
