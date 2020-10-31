package com.soc.round1design.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataException extends Exception{

    private String errorMessage;
    private HttpStatus httpMethod;
}
