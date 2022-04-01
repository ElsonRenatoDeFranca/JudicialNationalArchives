package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Offense;

import java.util.List;

public interface JudicialNationalArchivesSystemService {
    List<Offense> findAll();

    Offense findById(Long offenseId);

    Offense save(Offense offense);

    void deleteById(Long offenseId);
}
