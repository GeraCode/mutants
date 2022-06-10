package com.thexmens.muntants.utils;

import com.thexmens.muntants.dao.Person;
import com.thexmens.muntants.dao.Statistics;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

public class StatisticsHelper {
    private StatisticsHelper() {
    }

    public static Statistics buildStatistics(List<Person> personList) {
        Integer allData = NumberUtils.INTEGER_ZERO, mutants = NumberUtils.INTEGER_ZERO;

        for (Person p : personList) {
            if (p.getIs_mutant().equals(true)) {
                mutants++;
            }
            allData++;
        }
        return Statistics.builder()
                .count(allData)
                .count_human_dna(allData - mutants)
                .count_mutant_dna(mutants)
                .ratio(Double.valueOf(mutants) / Double.valueOf(allData)).build();
    }
}
