package com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalOffencesManagerRepository extends JpaRepository<CriminalOffence, Long> {
}
