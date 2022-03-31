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
import java.util.Optional;

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

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(createPersonMock()));
        Person actual = this.judicialNationalArchivesSystemService.findPersonById(1L);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(createPersonMock());
    }

    private List<Person> createPeopleMockList(){
        return Arrays.asList(createPersonMock(),createPersonMock());
    }

    private Person createPersonMock(){
        return Person.builder().nationalIdentificationNumber("1").firstName("John").lastName("McCain").birthDate("22/01/1978").build();
    }
}