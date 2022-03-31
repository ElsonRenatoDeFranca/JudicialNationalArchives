package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.JudicialNationalArchivesSystemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class JudicialNationalArchiveSystemControllerTest {

    @Mock
    private JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    @InjectMocks
    private JudicialNationalArchiveSystemController judicialNationalArchiveSystemController;

    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createNotEmptyPeopleMockList());

        ResponseEntity<List<Person>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createEmptyPeopleMockList());

        ResponseEntity<List<Person>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        Person expectedPerson = createPersonMock();

        when(judicialNationalArchivesSystemService.findPersonById(anyLong())).thenReturn(expectedPerson);

        ResponseEntity<Person> actualPerson = this.judicialNationalArchiveSystemController.findPersonById(expectedPerson.getId());

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualPerson.getBody()).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldDeleteAnExistingPersonFromTheDatabaseWhenDeletePersonIsCalled() {
        Person expectedPerson = createPersonMock();

        doNothing().when(judicialNationalArchivesSystemService).deleteById(any());

        this.judicialNationalArchiveSystemController.deletePersonById(expectedPerson.getId());

        verify(judicialNationalArchivesSystemService, atLeast(1)).deleteById(any());
    }

    @Test
    public void shouldAddANewPersonToTheDatabaseWhenAddPersonIsCalled(){
        Person expectedPerson = createPersonMock();

        when(judicialNationalArchivesSystemService.addPerson(any())).thenReturn(expectedPerson);

        ResponseEntity<Person> actualPerson = this.judicialNationalArchiveSystemController.addPerson(expectedPerson);

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(judicialNationalArchivesSystemService, atLeast(1)).addPerson(any());
    }


    private List<Person> createNotEmptyPeopleMockList() {
        return Arrays.asList(createPersonMock(), createPersonMock());
    }

    private List<Person> createEmptyPeopleMockList() {
        return Collections.emptyList();
    }

    private Person createPersonMock() {
        return Person.builder()
                .id(1L)
                .nationalIdentificationNumber("1")
                .firstName("Lebron")
                .lastName("James")
                .birthDate("22/01/1978")
                .build();
    }
}