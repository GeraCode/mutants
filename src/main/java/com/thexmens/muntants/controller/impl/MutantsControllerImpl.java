package com.thexmens.muntants.controller.impl;

import com.thexmens.muntants.controller.MutantsController;
import com.thexmens.muntants.controller.response.MutantsResponseDto;
import com.thexmens.muntants.dao.Person;
import com.thexmens.muntants.service.MutantsService;
import com.thexmens.muntants.utils.ParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class MutantsControllerImpl implements MutantsController {

    @Autowired
    private MutantsService mutantsService;

    @Override
    public MutantsResponseDto verifyMutantByDNA(String[] dnaArray) {
        ParametersValidator.verifyDNANitrogenBase(dnaArray);
        Map<String, Person> personMap = mutantsService.getAndSavePersons(dnaArray);
        if (personMap.containsKey("thereAreMutants")) {
            return MutantsResponseDto.builder().body(personMap).status(HttpStatus.OK).build();
        } else {
            return MutantsResponseDto.builder().body(personMap).status(HttpStatus.FORBIDDEN).build();
        }
    }

    @Override
    public MutantsResponseDto getStats() {
        return MutantsResponseDto.builder().body(mutantsService.getStats()).status(HttpStatus.OK).build();
    }
}
