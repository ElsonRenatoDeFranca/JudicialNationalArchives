package com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Score {
    private Person person;
    private Integer value;
}
