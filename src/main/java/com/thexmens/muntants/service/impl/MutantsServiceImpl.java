package com.thexmens.muntants.service.impl;

import com.thexmens.muntants.dao.Person;
import com.thexmens.muntants.dao.Statistics;
import com.thexmens.muntants.repository.PersonRepository;
import com.thexmens.muntants.service.MutantsService;
import com.thexmens.muntants.utils.PersonHelper;
import com.thexmens.muntants.utils.StatisticsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutantsServiceImpl implements MutantsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Map<String, Person> getAndSavePersons(String[] dnaArray) {
        Map<String, Person> personMap = new HashMap<>();
        Boolean isMutant = PersonHelper.isMutant(dnaArray);
        Person person = personRepository.save(
                PersonHelper.buildPerson(
                        "[" +  dnaArray[0] + "," +
                                    dnaArray[1] + "," +
                                    dnaArray[2] + "," +
                                    dnaArray[3] + "," +
                                    dnaArray[4] + "," +
                                    dnaArray[5] + ",", isMutant));
        personMap.put((Boolean.TRUE.equals(isMutant) ? "thereAreMutants" : "OnlyHumans"), person);
        return personMap;
    }

    @Override
    public Statistics getStats() {
        List<Person> personList = personRepository.findAll();
        return StatisticsHelper.buildStatistics(personList);
    }


}
