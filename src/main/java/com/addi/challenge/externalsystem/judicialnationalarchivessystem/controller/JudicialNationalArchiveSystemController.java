package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.domain.Customer;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person){
        return judicialNationalArchivesSystemService.addPerson(person);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Person findPersonById(@PathVariable("id") Long id) {
        return judicialNationalArchivesSystemService.findPersonById(id);
    }

    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable Long id) {
        judicialNationalArchivesSystemService.deleteById(id);
    }
}
