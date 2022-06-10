package com.thexmens.muntants.service;

import com.thexmens.muntants.dao.Person;
import com.thexmens.muntants.dao.Statistics;

import java.util.Map;

public interface MutantsService {

    public Map<String, Person> getAndSavePersons(String[] dnaArray);

    public Statistics getStats();
}
