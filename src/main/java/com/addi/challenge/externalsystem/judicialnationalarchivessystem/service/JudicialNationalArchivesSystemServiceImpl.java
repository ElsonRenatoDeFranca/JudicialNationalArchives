package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.JudicialRecord;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.exception.CriminalOffenceNotFoundException;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.JudicialNationalArchivesSystemRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService {

    private final JudicialNationalArchivesSystemRepository repository;

    //public final RestTemplate restTemplate;

    //@Value("${criminal-offences-service.url}")
    //private String remoteCriminalOffencesServiceUrl;

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE = "Criminal offence not found";

    public JudicialNationalArchivesSystemServiceImpl(JudicialNationalArchivesSystemRepository repository) {
        this.repository = repository;
    }

    @Override
    public CriminalOffence findCriminalOffenceById(Long criminalOffenceId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CriminalOffence> responseEntity =
                restTemplate.exchange("http://localhost:8091/api/criminalOffences/" + criminalOffenceId,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), CriminalOffence.class);
        CriminalOffence criminalOffence = responseEntity.getBody();
        return criminalOffence;
    }

    @Override
    public Person findPersonById(Long personById) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> responseEntity =
                restTemplate.exchange("http://localhost:8092/api/people/" + personById,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Person.class);
        Person person = responseEntity.getBody();
        return person;
    }
}
