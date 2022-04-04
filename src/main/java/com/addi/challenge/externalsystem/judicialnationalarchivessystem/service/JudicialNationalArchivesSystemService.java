package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;

public interface JudicialNationalArchivesSystemService {
    //CriminalOffence findCriminalOffenceById(Long criminalOffenceId);
    //Person findPersonById(Long personById);
    Person savePerson(Person person);
    CriminalOffence saveCriminalOffence(CriminalOffence criminalOffence);
}
