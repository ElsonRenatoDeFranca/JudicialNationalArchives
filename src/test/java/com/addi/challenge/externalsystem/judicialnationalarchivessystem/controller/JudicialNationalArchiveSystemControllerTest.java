package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.JudicialRecord;
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

    /*
    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createNotEmptyOffenseMockList());

        ResponseEntity<List<JudicialRecord>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(judicialNationalArchivesSystemService.findAll()).thenReturn(createEmptyOffenseMockList());

        ResponseEntity<List<JudicialRecord>> actualPeople = this.judicialNationalArchiveSystemController.findAll();

        assertThat(actualPeople).isNotNull();
        assertThat(actualPeople.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        JudicialRecord expectedPerson = createOffenseMock();

        when(judicialNationalArchivesSystemService.findById(anyLong())).thenReturn(expectedPerson);

        ResponseEntity<JudicialRecord> actualPerson = this.judicialNationalArchiveSystemController.findById(expectedPerson.getId());

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualPerson.getBody()).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldDeleteAnExistingPersonFromTheDatabaseWhenDeletePersonIsCalled() {
        JudicialRecord expectedPerson = createOffenseMock();

        doNothing().when(judicialNationalArchivesSystemService).deleteById(any());

        this.judicialNationalArchiveSystemController.deleteById(expectedPerson.getId());

        verify(judicialNationalArchivesSystemService, atLeast(1)).deleteById(any());
    }

    @Test
    public void shouldAddANewPersonToTheDatabaseWhenAddPersonIsCalled() {
        JudicialRecord expectedPerson = createOffenseMock();

        when(judicialNationalArchivesSystemService.save(any())).thenReturn(expectedPerson);

        ResponseEntity<JudicialRecord> actualPerson = this.judicialNationalArchiveSystemController.save(expectedPerson);

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(judicialNationalArchivesSystemService, atLeast(1)).save(any());
    }


    private List<JudicialRecord> createNotEmptyOffenseMockList() {
        return Arrays.asList(createOffenseMock(), createOffenseMock());
    }

    private List<JudicialRecord> createEmptyOffenseMockList() {
        return Collections.emptyList();
    }

    private JudicialRecord createOffenseMock() {
        return JudicialRecord.builder()
                .id(1L)
                .description("Home invasion")
                .maximumFine("100")
                .probationTerm("10")
                .maximumPrisonTerm("10")
                .build();
    }

     */
}