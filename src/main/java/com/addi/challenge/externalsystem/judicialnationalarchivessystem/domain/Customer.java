package com.addi.challenge.externalsystem.judicialnationalarchivessystem.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {
    private String firstName;
    private String nationalIdentificationNumber;
    private String birthDate;
    private String lastName;
    private String email;
    private int age;
}
