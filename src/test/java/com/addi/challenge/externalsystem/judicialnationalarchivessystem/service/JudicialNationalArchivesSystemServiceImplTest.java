package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.JudicialRecord;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    private static final String OFFENSE_NOT_FOUND_EXCEPTION = "Person not found";

    /*
    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(repository.findAll()).thenReturn(createNotEmptyOffenseMockList());
        List<JudicialRecord> actualOffense = this.judicialNationalArchivesSystemService.findAll();

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense.isEmpty()).isFalse();
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(repository.findAll()).thenReturn(createEmptyOffenseMockList());
        List<JudicialRecord> actualOffense = this.judicialNationalArchivesSystemService.findAll();

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense.isEmpty()).isTrue();
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        JudicialRecord expectedOffense = createOffenseMock();

        when(repository.findById(anyLong())).thenReturn(Optional.of(expectedOffense));

        JudicialRecord actualOffense = this.judicialNationalArchivesSystemService.findById(expectedOffense.getId());

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense).isEqualTo(expectedOffense);
    }

    @Test
    public void shouldDeleteAnExistingOffenseFromTheDatabaseWhenDeleteByIdIsCalled() {
        JudicialRecord expectedOffense = createOffenseMock();

        doNothing().when(repository).deleteById(any());

        this.judicialNationalArchivesSystemService.deleteById(expectedOffense.getId());

        verify(repository, atLeast(1)).deleteById(any());
    }


    @Test
    public void shouldAddANewOffenseToTheDatabaseWhenSaveIsCalled() {
        JudicialRecord expectedOffense = createOffenseMock();

        when(repository.save(any())).thenReturn(expectedOffense);

        JudicialRecord actualOffense = this.judicialNationalArchivesSystemService.save(expectedOffense);

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense).isEqualTo(expectedOffense);
        verify(repository, atLeast(1)).save(any());
    }

    @Test
    public void shouldThrowAnOffenseNotFoundExceptionWhenFindByIdIsCalledWithUnknownId() {
        JudicialRecord expectedOffense = createOffenseMock();

        when(repository.findById(anyLong())).thenThrow(new RuntimeException(OFFENSE_NOT_FOUND_EXCEPTION));

        Throwable exception = assertThrows(RuntimeException.class,
                () -> this.judicialNationalArchivesSystemService.findById(expectedOffense.getId()));

        assertThat(OFFENSE_NOT_FOUND_EXCEPTION).isEqualTo(exception.getMessage());
    }

    @Test
    public void shouldThrowAnOffenseNotFoundExceptionWhenDeleteByIdIsCalledWithUnknownId() {
        JudicialRecord expectedOffense = createOffenseMock();

        doThrow(new RuntimeException(OFFENSE_NOT_FOUND_EXCEPTION)).when(repository).deleteById(anyLong());

        Throwable exception = assertThrows(RuntimeException.class,
                () -> this.judicialNationalArchivesSystemService.deleteById(expectedOffense.getId()));

        assertThat(OFFENSE_NOT_FOUND_EXCEPTION).isEqualTo(exception.getMessage());
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
                .description("Assassination")
                .maximumPrisonTerm("10")
                .maximumFine("10")
                .probationTerm("5")
                .build();
    }

     */
}