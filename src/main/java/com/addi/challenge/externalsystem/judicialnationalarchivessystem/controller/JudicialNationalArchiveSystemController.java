package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.JudicialNationalArchivesSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class JudicialNationalArchiveSystemController {

    private final JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    public JudicialNationalArchiveSystemController(JudicialNationalArchivesSystemService judicialNationalArchivesSystemService) {
        this.judicialNationalArchivesSystemService = judicialNationalArchivesSystemService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return new ResponseEntity<>(judicialNationalArchivesSystemService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person savedPerson  = judicialNationalArchivesSystemService.addPerson(person);

        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id) {
        Person person = judicialNationalArchivesSystemService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable Long id) {
        judicialNationalArchivesSystemService.deleteById(id);
    }
}
