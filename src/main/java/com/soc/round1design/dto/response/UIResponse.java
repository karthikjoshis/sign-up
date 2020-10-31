package com.soc.round1design.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UIResponse {

    private int data;
    private String errorMessage;
    private HttpStatus status;
    private String successMessage;

    public UIResponse(int data, String errorMessage, HttpStatus status) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public UIResponse(int data, HttpStatus status, String successMessage) {
        this.data = data;
        this.status = status;
        this.successMessage = successMessage;
    }
}
