package com.thexmens.muntants.controller;

import com.thexmens.muntants.controller.response.MutantsResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
public interface MutantsController {

    @PostMapping("/mutant/")
    MutantsResponseDto verifyMutantByDNA(@RequestParam  String[] dnaArray);

    @GetMapping("/stats")
    MutantsResponseDto getStats();

}
