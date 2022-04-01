package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Offense;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.exception.OffenseNotFoundException;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService {

    private final JudicialNationalArchivesSystemRepository repository;

    private static final String OFFENSE_NOT_FOUND_EXCEPTION = "Offense not found";

    public JudicialNationalArchivesSystemServiceImpl(JudicialNationalArchivesSystemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Offense> findAll() {
        return repository.findAll();
    }

    @Override
    public Offense findById(Long offenseId) {
        try {
            return repository.findById(offenseId).orElseThrow(() -> new OffenseNotFoundException(OFFENSE_NOT_FOUND_EXCEPTION));
        } catch (OffenseNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Offense save(Offense offense) {
        return repository.save(offense);
    }

    @Override
    public void deleteById(Long offenseId) {
        repository.deleteById(offenseId);
    }
}
