package com.thexmens.muntants.utils;

import com.thexmens.muntants.dao.Person;
import org.apache.commons.lang3.math.NumberUtils;

public class PersonHelper {

    private PersonHelper() {
    }

    public static Boolean isMutant(String[] dnaArray) {
        String[][] dnaMatrix = new String[Constants.DNA_LENGTH][Constants.DNA_LENGTH];
        //building matrix
        for (int x = NumberUtils.INTEGER_ZERO; x < Constants.DNA_LENGTH; ++x) {
            for (int y = NumberUtils.INTEGER_ZERO; y < Constants.DNA_LENGTH; ++y) {
                dnaMatrix[x][y] = dnaArray[x].substring(y, y + 1);
            }
        }

        //diagonal
        Integer countFourLettersPattern = NumberUtils.INTEGER_ZERO;
        String charAux = "";
        String stringAux = "";
        Integer countAux = NumberUtils.INTEGER_ZERO;
        for (int x = NumberUtils.INTEGER_ZERO; x < dnaMatrix.length; ++x) {
            for (int y = NumberUtils.INTEGER_ZERO; y < dnaMatrix[x].length; ++y) {
                if (x == y) {
                    if (x != NumberUtils.INTEGER_ZERO) {
                        if (charAux.equals(dnaMatrix[x][y])) {
                            stringAux = charAux + stringAux;
                            countAux++;
                        }
                    }
                    charAux = dnaMatrix[x][y];
                }
            }
        }
        countFourLettersPattern = validateEqualsLetters(countAux, countFourLettersPattern, stringAux);

        //row
        for (int x = NumberUtils.INTEGER_ZERO; x < dnaMatrix.length; ++x) {
            countAux = NumberUtils.INTEGER_ZERO;
            stringAux = "";
            for (int y = NumberUtils.INTEGER_ZERO; y < dnaMatrix[x].length; ++y) {
                if (dnaMatrix[x][y].equals(dnaMatrix[x][y+1<dnaMatrix[x].length?y+1:y]) && y!=dnaMatrix[x].length-1){
                        countAux++;
                        stringAux=stringAux+dnaMatrix[x][y];
                }
            }
            countFourLettersPattern = validateEqualsLetters(countAux, countFourLettersPattern, stringAux);
        }

        //column
        for (int x = NumberUtils.INTEGER_ZERO; x < dnaMatrix.length; ++x) {
            countAux = NumberUtils.INTEGER_ZERO;
            stringAux = "";
            for (int y = NumberUtils.INTEGER_ZERO; y < dnaMatrix[x].length; ++y) {
                if (dnaMatrix[y][x].equals(dnaMatrix[y][x+1<dnaMatrix[y].length?x+1:x]) && x!=dnaMatrix[y].length-1){
                    countAux++;
                    stringAux=stringAux+dnaMatrix[y][x];
                }
            }
            countFourLettersPattern = validateEqualsLetters(countAux, countFourLettersPattern, stringAux);
        }
        return countFourLettersPattern > NumberUtils.INTEGER_ONE ? true : false;
    }

    private static Integer validateEqualsLetters(Integer count, Integer counting, String letters) {
        if (   Constants.EQUALS_LETTERS.equals(letters.length())&& letters.substring(NumberUtils.INTEGER_ZERO, NumberUtils.INTEGER_ONE)
                .equals(letters.substring(NumberUtils.INTEGER_ONE, NumberUtils.INTEGER_TWO))
                && letters.substring(NumberUtils.INTEGER_ONE, NumberUtils.INTEGER_TWO)
                .equals(letters.substring(NumberUtils.INTEGER_TWO, 3))
        ) {
            counting++;
        }
        return counting;
    }

    public static Person buildPerson(String dna, Boolean isMutant) {
        return Person.builder().adn(dna).is_mutant(isMutant).build();
    }
}
