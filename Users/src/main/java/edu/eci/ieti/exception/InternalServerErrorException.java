package edu.eci.ieti.exception;

import edu.eci.ieti.error.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends  RuntimeException {

    private final ServerErrorResponseDto serverErrorResponseDto;
    private final HttpStatus httpStatus;

    public InternalServerErrorException( ServerErrorResponseDto serverErrorResponseDto, HttpStatus httpStatus ) {
        this.serverErrorResponseDto = serverErrorResponseDto;
        this.httpStatus = httpStatus;
    }

}
