package edu.eci.ieti.exception;

import edu.eci.ieti.error.ErrorCodeEnum;
import edu.eci.ieti.error.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }
}