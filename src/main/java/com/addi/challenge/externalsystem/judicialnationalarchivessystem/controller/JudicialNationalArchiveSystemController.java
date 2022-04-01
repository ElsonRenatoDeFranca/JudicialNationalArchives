package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.JudicialRecord;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.JudicialNationalArchivesSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/criminalrecords")
public class JudicialNationalArchiveSystemController {

    private final JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    public JudicialNationalArchiveSystemController(JudicialNationalArchivesSystemService judicialNationalArchivesSystemService) {
        this.judicialNationalArchivesSystemService = judicialNationalArchivesSystemService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<JudicialRecord> findCriminalOffenseById(@PathVariable("id") Long id) {
        CriminalOffence offense = judicialNationalArchivesSystemService.findCriminalOffenceById(id);
        JudicialRecord judicialRecord = JudicialRecord.builder().build();

        return new ResponseEntity<>(judicialRecord, HttpStatus.OK);
    }

    @GetMapping("/findPerson/{id}")
    @ResponseBody
    public ResponseEntity<JudicialRecord> findPersonById(@PathVariable("id") Long id) {
        Person person = judicialNationalArchivesSystemService.findPersonById(id);
        JudicialRecord judicialRecord = JudicialRecord.builder().build();

        return new ResponseEntity<>(judicialRecord, HttpStatus.OK);
    }

}
