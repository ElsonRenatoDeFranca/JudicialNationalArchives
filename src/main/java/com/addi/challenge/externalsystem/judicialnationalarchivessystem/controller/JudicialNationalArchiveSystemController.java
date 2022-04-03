package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.ResponseTemplateWrapper;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.JudicialNationalArchivesSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/judicialrecords")
public class JudicialNationalArchiveSystemController {

    private final JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    public JudicialNationalArchiveSystemController(JudicialNationalArchivesSystemService judicialNationalArchivesSystemService) {
        this.judicialNationalArchivesSystemService = judicialNationalArchivesSystemService;
    }

    @GetMapping("/person/{personId}")
    @ResponseBody
    public ResponseEntity<Person> findJudicialRecordsByPersonId(@PathVariable("personId") Long personId) {
        //Person person = judicialNationalArchivesSystemService.findPersonById(personId);
        //CriminalOffence criminalOffence  = judicialNationalArchivesSystemService.findCriminalOffenceById(crimeId);
        Person person = this.judicialNationalArchivesSystemService.findJudicialRecordsByPersonId(personId);
        /*ResponseTemplateWrapper judicialRecord =
                ResponseTemplateWrapper
                        .builder()
                        .person(person)
                        .criminalOffence(criminalOffence)
                        .build();*/

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/people")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = judicialNationalArchivesSystemService.savePerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @PostMapping("/crimes")
    public ResponseEntity<CriminalOffence> saveCriminalOffence(@RequestBody CriminalOffence criminalOffence) {
        CriminalOffence savedCriminalOffence = judicialNationalArchivesSystemService.saveCriminalOffence(criminalOffence);
        return new ResponseEntity<>(savedCriminalOffence, HttpStatus.CREATED);
    }


}
