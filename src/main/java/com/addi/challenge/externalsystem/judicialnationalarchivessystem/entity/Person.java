package com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalIdentificationNumber;
    private String birthDate;
    private String email;
}
