package com.addi.challenge.externalsystem.judicialnationalarchivessystem.service;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.JudicialRecord;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Person;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Score;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@NoArgsConstructor
public class ScoreCalculatorServiceImpl implements ScoreCalculatorService {

    private RestTemplate restTemplate;

    @Value("${judicial-records-service.url}")
    private String remoteJudicialRecordsServiceUrl;

    @Value("${people-service.url}")
    private String remotePeopleServiceUrl;

    private List<Person> crm = createCrm();

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE = "Criminal offence not found";

    private static AtomicInteger maximumScore = new AtomicInteger(100);

    @Autowired
    public ScoreCalculatorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Score calculateScoreByNationalIdentificationNumber() {
        //Person personCrm = this.crm.stream().filter(c -> c.getNationalIdentificationNumber().equals(nationalIdentificationNumber)).findFirst().get();


        for(Person crmPerson : this.crm){
            int personScoreValue = 0;
            int judicialScoreValue = 0;
            int totalScore = 0;

            Person personNationalIdentificationSystem = findPersonByNationalIdentificationNumber(crmPerson.getNationalIdentificationNumber());
            JudicialRecord judicialRecord  = findJudicialRecordByNationalIdentificationNumber(crmPerson.getNationalIdentificationNumber());

            if(crmPerson.getId().equals(personNationalIdentificationSystem.getId())){
                personScoreValue+=10;
            }
            if(crmPerson.getFirstName().equals(personNationalIdentificationSystem.getFirstName())){
                personScoreValue+=10;
            }
            if(crmPerson.getLastName().equals(personNationalIdentificationSystem.getLastName())){
                personScoreValue+=10;
            }
            if(crmPerson.getNationalIdentificationNumber().equals(personNationalIdentificationSystem.getNationalIdentificationNumber())){
                personScoreValue+=10;
            }
            if(crmPerson.getBirthDate().equals(personNationalIdentificationSystem.getBirthDate())){
                personScoreValue+=10;
            }
            if(crmPerson.getEmail().equals(personNationalIdentificationSystem.getLastName())){
                personScoreValue+=10;
            }

            if(crmPerson.getNationalIdentificationNumber().equals(judicialRecord.getNationalIdentificationNumber())){
                judicialScoreValue=0;
            }else{
                judicialScoreValue=50;
            }

            totalScore = personScoreValue + judicialScoreValue;

            if(totalScore >=60){
                
            }

        }

        //JudicialRecord judicialRecord = findJudicialRecordByNationalIdentificationNumber(nationalIdentificationNumber);
        //Integer maximumScore  = new Integer(100);
        Score score = Score.builder().build();
        return score;
    }


    private Person findPersonByNationalIdentificationNumber(String nationalIdentificationNumber) {
        ResponseEntity<Person> responseEntity =
                restTemplate.exchange(remotePeopleServiceUrl + nationalIdentificationNumber,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Person.class);
        return responseEntity.getBody();

    }

    private List<Person> createCrm(){
        List<Person> crm = Arrays.asList(Person.builder().id(1L).birthDate("15/02/2000").lastName("da Silva").
                firstName("Joao").nationalIdentificationNumber("90008").email("joaodasilva@gmail.com").build(),

                Person.builder().id(2L).birthDate("15/02/2001").lastName("da Silva").
                        firstName("Manuel").nationalIdentificationNumber("90007").email("manueldasilva@gmail.com").build(),
                Person.builder().id(3L).birthDate("15/02/2001").lastName("da Silva").
                        firstName("Paulo").nationalIdentificationNumber("90006").email("paulodasilva@gmail.com").build(),
                Person.builder().id(4L).birthDate("15/02/2001").lastName("Guedes").
                        firstName("Cluaudia").nationalIdentificationNumber("90004").email("claudiaguedes@gmail.com").build());

        return crm;

    }
    private JudicialRecord findJudicialRecordByNationalIdentificationNumber(String nationalIdentificationNumber) {
        ResponseEntity<JudicialRecord> responseEntity =
                restTemplate.exchange(remoteJudicialRecordsServiceUrl + nationalIdentificationNumber,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), JudicialRecord.class);

        return  responseEntity.getBody();
    }

}
