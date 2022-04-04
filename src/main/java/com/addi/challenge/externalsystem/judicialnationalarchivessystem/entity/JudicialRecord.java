package com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class JudicialRecord {
    private Long id;
    private String nationalIdentificationNumber;
}
