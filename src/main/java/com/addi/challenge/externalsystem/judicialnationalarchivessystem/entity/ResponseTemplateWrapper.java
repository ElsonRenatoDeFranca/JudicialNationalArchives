package com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ResponseTemplateWrapper {
    private Person person;
    private CriminalOffence criminalOffence;
}
