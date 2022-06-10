package com.thexmens.muntants.controller.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
public class MutantsResponseDto<T> extends ResponseEntity {
    private T body;
    private HttpStatus status;

    public MutantsResponseDto(T body, HttpStatus status) {
        super(body, status);
        this.body = body;
        this.status = status;
    }

}