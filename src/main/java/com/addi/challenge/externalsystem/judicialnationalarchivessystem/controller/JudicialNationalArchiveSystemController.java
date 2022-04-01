package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Offense;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.JudicialNationalArchivesSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offenses")
public class JudicialNationalArchiveSystemController {

    private final JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    public JudicialNationalArchiveSystemController(JudicialNationalArchivesSystemService judicialNationalArchivesSystemService) {
        this.judicialNationalArchivesSystemService = judicialNationalArchivesSystemService;
    }

    @GetMapping
    public ResponseEntity<List<Offense>> findAll() {
        return new ResponseEntity<>(judicialNationalArchivesSystemService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Offense> save(@RequestBody Offense offense) {
        Offense savedOffense = judicialNationalArchivesSystemService.save(offense);

        return new ResponseEntity<>(savedOffense, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Offense> findById(@PathVariable("id") Long id) {
        Offense offense = judicialNationalArchivesSystemService.findById(id);
        return new ResponseEntity<>(offense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        judicialNationalArchivesSystemService.deleteById(id);
    }
}
