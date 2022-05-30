package com.example.EJ2CRUD.errorsHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private int httpCode;
    private String mensaje;

}
