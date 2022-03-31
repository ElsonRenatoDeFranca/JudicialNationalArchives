package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(MockitoJUnitRunner.class)
class JudicialNationalArchivesSystemServiceImplTest {

    private JudicialNationalArchivesSystemService judicialNationalArchivesSystemService;

    @Before
    public void setUp(){
       judicialNationalArchivesSystemService  = new JudicialNationalArchivesSystemServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnNotEmptyListWhenFindAllIsCalled(){
        //List customers = this.judicialNationalArchivesSystemService.findAll();
        //assertThat(customers).is(null);
    }
}