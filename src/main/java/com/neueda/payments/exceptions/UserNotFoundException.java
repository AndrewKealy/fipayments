package com.neueda.payments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends Exception{

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
