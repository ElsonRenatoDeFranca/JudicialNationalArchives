package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.config.RestTemplateConfig;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
@NoArgsConstructor
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService {

    //private final JudicialNationalArchivesSystemRepository repository;

    private RestTemplate restTemplate;

    @Value("${criminal-offences-service.url}")
    private String remoteCriminalOffencesServiceUrl;

    @Value("${people-service.url}")
    private String remotePeopleServiceUrl;

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE = "Criminal offence not found";

    @Autowired
    public JudicialNationalArchivesSystemServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public CriminalOffence findCriminalOffenceById(Long criminalOffenceId) {
        ResponseEntity<CriminalOffence> responseEntity =
                restTemplate.exchange(remoteCriminalOffencesServiceUrl + criminalOffenceId,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), CriminalOffence.class);

        return responseEntity.getBody();
    }

    @Override
    public Person findPersonById(Long personById) {
        ResponseEntity<Person> responseEntity =
                restTemplate.exchange(remotePeopleServiceUrl + personById,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Person.class);
        return responseEntity.getBody();
    }
}
