package com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
public class CriminalOffence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String maximumPrisonTerm;
    private String maximumFine;
    private String probationTerm;;
}
