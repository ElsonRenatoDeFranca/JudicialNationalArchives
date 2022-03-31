package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class JudicialNationalArchivesSystemServiceImplTest {


    @Mock
    private JudicialNationalArchivesSystemRepository repository;

    @InjectMocks
    private JudicialNationalArchivesSystemServiceImpl judicialNationalArchivesSystemService;

    @Test
    public void shouldReturnNotNullListWhenFindAllIsCalled(){
        Mockito.when(repository.findAll()).thenReturn(createPeopleMockList());
        List people = this.judicialNationalArchivesSystemService.findAll();
        assertThat(people).isNotNull();
    }

    @Test
    public void shouldReturnNotEmptyListWhenFindAllIsCalled(){
        Mockito.when(repository.findAll()).thenReturn(createPeopleMockList());
        List people = this.judicialNationalArchivesSystemService.findAll();

        assertThat(people).isNotNull();
        assertThat(people.isEmpty()).isFalse();
    }

    private List<Person> createPeopleMockList(){
        return Arrays.asList(
                Person.builder().id(1L).firstName("John").lastName("Mccain").nationalIdentificationNumber("1").build(),
                Person.builder().id(2L).firstName("Barack").lastName("Obama").nationalIdentificationNumber("2").build()
        );
    }
}