package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JudicialNationalArchivesSystemServiceImplTest {

    @Mock
    private JudicialNationalArchivesSystemRepository repository;

    @InjectMocks
    private JudicialNationalArchivesSystemServiceImpl judicialNationalArchivesSystemService;

    private static final String PERSON_NOT_FOUND_EXCEPTION = "Person not found";

    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase(){
        when(repository.findAll()).thenReturn(createNotEmptyPeopleMockList());
        List<Person> actualPeople = this.judicialNationalArchivesSystemService.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.isEmpty()).isFalse();
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase(){
        when(repository.findAll()).thenReturn(createEmptyPeopleMockList());
        List<Person> actualPeople = this.judicialNationalArchivesSystemService.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.isEmpty()).isTrue();
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled(){
        Person expectedPerson = createPersonMock();

        when(repository.findById(anyLong())).thenReturn(Optional.of(expectedPerson));

        Person actualPerson = this.judicialNationalArchivesSystemService.findPersonById(expectedPerson.getId());

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldAddANewPersonToTheDatabaseWhenAddPersonIsCalled(){
        Person expectedPerson = createPersonMock();

        when(repository.save(any())).thenReturn(expectedPerson);

        Person actualPerson = this.judicialNationalArchivesSystemService.addPerson(expectedPerson);

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson).isEqualTo(expectedPerson);
        verify(repository, atLeast(1)).save(any());
    }

    @Test
    public void shouldThrowAPersonNotFoundExceptionWhenFindByIdIsCalledWithUnknownId(){
        Person expectedPerson = createPersonMock();

        when(repository.findById(anyLong())).thenThrow(new RuntimeException(PERSON_NOT_FOUND_EXCEPTION));

        Throwable exception = assertThrows(RuntimeException.class,
                () -> this.judicialNationalArchivesSystemService.findPersonById(expectedPerson.getId()));

        assertThat(PERSON_NOT_FOUND_EXCEPTION).isEqualTo(exception.getMessage());
    }

    private List<Person> createNotEmptyPeopleMockList(){
        return Arrays.asList(createPersonMock(), createPersonMock());
    }

    private List<Person> createEmptyPeopleMockList(){
        return Collections.emptyList();
    }

    private Person createPersonMock(){
        return Person.builder()
                .id(1L)
                .nationalIdentificationNumber("1")
                .firstName("Lebron")
                .lastName("James")
                .birthDate("22/01/1978")
                .build();
    }
}