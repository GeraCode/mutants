package com.thexmens.muntants.exceptios;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@NoArgsConstructor
@Log4j2
public class BusinessException extends RuntimeException {
    public static final String EXCEPTION_MSG_FORMAT = "%s :: %s";

    /**
     * Constructor of BusinessException
     *
     * @param message is the String that receive the message
     */
    public BusinessException(String message) {
        super(message);
        log.error(String.format(EXCEPTION_MSG_FORMAT, "Business Exception Info", message));
    }

    /**
     * Constructor of BusinessException
     *
     * @param message is the String that receive the message
     * @param cause is the exception that help to know about of error
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        log.error(String.format(EXCEPTION_MSG_FORMAT, "Business Exception Info", message), cause);
    }
}

