package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Offense;
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
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createNotEmptyOffenseMockList());

        ResponseEntity<List<Offense>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createEmptyOffenseMockList());

        ResponseEntity<List<Offense>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        Offense expectedPerson = createOffenseMock();

        when(judicialNationalArchivesSystemService.findById(anyLong())).thenReturn(expectedPerson);

        ResponseEntity<Offense> actualPerson = this.judicialNationalArchiveSystemController.findById(expectedPerson.getId());

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualPerson.getBody()).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldDeleteAnExistingPersonFromTheDatabaseWhenDeletePersonIsCalled() {
        Offense expectedPerson = createOffenseMock();

        doNothing().when(judicialNationalArchivesSystemService).deleteById(any());

        this.judicialNationalArchiveSystemController.deleteById(expectedPerson.getId());

        verify(judicialNationalArchivesSystemService, atLeast(1)).deleteById(any());
    }

    @Test
    public void shouldAddANewPersonToTheDatabaseWhenAddPersonIsCalled() {
        Offense expectedPerson = createOffenseMock();

        when(judicialNationalArchivesSystemService.save(any())).thenReturn(expectedPerson);

        ResponseEntity<Offense> actualPerson = this.judicialNationalArchiveSystemController.save(expectedPerson);

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(judicialNationalArchivesSystemService, atLeast(1)).save(any());
    }


    private List<Offense> createNotEmptyOffenseMockList() {
        return Arrays.asList(createOffenseMock(), createOffenseMock());
    }

    private List<Offense> createEmptyOffenseMockList() {
        return Collections.emptyList();
    }

    private Offense createOffenseMock() {
        return Offense.builder()
                .id(1L)
                .description("Home invasion")
                .maximumFine("100")
                .probationTerm("10")
                .maximumPrisonTerm("10")
                .build();
    }
}