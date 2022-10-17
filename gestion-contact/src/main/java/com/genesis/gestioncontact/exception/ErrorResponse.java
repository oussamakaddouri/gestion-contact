package com.genesis.gestioncontact.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private final int code;
    private final String message;
}
