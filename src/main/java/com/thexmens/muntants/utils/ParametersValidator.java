package com.thexmens.muntants.utils;

import com.thexmens.muntants.exceptios.BusinessException;

import java.util.Arrays;
import java.util.Objects;

public class ParametersValidator {
    private ParametersValidator() {
    }

    public static void verifyDNANitrogenBase(String[] dnaArray) {
        Arrays.stream(dnaArray).filter(Objects::nonNull).forEach(
                dna -> {
                    if (!(( dna.toUpperCase().contains(Constants.REGEX_A) ||
                            dna.toUpperCase().contains(Constants.REGEX_T) ||
                            dna.toUpperCase().contains(Constants.REGEX_C) ||
                            dna.toUpperCase().contains(Constants.REGEX_G))
                            && Constants.DNA_LENGTH.equals(dna.length())
                            && Constants.DNA_LENGTH.equals(dnaArray.length)
                    )) {
                        throw new BusinessException(
                                String.format(
                                        "The DNA doesn't have Nitrogen Base [%s]", dna));
                    }
                });
    }
}
