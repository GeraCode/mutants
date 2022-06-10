package com.thexmens.muntants.dao;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class Statistics {
    private Integer count;
    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private Double ratio;
}
