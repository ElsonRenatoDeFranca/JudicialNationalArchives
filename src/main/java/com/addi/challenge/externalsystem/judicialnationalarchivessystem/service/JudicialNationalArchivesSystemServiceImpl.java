package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.CriminalOffence;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.ResponseTemplateWrapper;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.CriminalOffencesManagerRepository;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.repository.PeopleManagerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class JudicialNationalArchivesSystemServiceImpl implements JudicialNationalArchivesSystemService {

    private CriminalOffencesManagerRepository criminalOffencesManagerRepository;
    private PeopleManagerRepository peopleManagerRepository;
    private RestTemplate restTemplate;

    @Value("${criminal-offences-service.url}")
    private String remoteCriminalOffencesServiceUrl;

    @Value("${people-service.url}")
    private String remotePeopleServiceUrl;

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE = "Criminal offence not found";

    @Autowired
    public JudicialNationalArchivesSystemServiceImpl(RestTemplate restTemplate, CriminalOffencesManagerRepository criminalOffencesManagerRepository, PeopleManagerRepository peopleManagerRepository) {
        this.restTemplate = restTemplate;
        this.criminalOffencesManagerRepository = criminalOffencesManagerRepository;
        this.peopleManagerRepository = peopleManagerRepository;
    }

    /*
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
    }*/

    @Override
    public Person savePerson(Person person) {
        Person personFromRemoteService = this.findPersonByNationalIdentificationNumber(person.getNationalIdentificationNumber());
        //CriminalOffence criminalOffence = this.findCriminalOffenceById(person.getCrimes().get(0).getCriminalOffenceId());

        return this.peopleManagerRepository.saveAndFlush(person);
    }

    @Override
    public CriminalOffence saveCriminalOffence(CriminalOffence criminalOffence) {
        return this.criminalOffencesManagerRepository.saveAndFlush(criminalOffence);
    }

    private Person findPersonByNationalIdentificationNumber(String nationalIdentificationNumber) {
        ResponseEntity<Person> responseEntity =
                restTemplate.exchange(remotePeopleServiceUrl + nationalIdentificationNumber,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Person.class);
        return responseEntity.getBody();

    }

    private CriminalOffence findCriminalOffenceById(Long criminalOffenceId) {
        ResponseEntity<CriminalOffence> responseEntity =
                restTemplate.exchange(remoteCriminalOffencesServiceUrl + criminalOffenceId,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), CriminalOffence.class);

        return responseEntity.getBody();
    }

}
