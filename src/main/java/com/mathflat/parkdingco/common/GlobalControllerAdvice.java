package com.mathflat.parkdingco.common;

import com.mathflat.parkdingco.exception.AlreadyStudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyStudentException.class)
    protected ResultResponse<Void> handleAlreadyStudentException(AlreadyStudentException e) {
        return ResultResponse.fail(null, ErrorCode.builder().code("ALREADY_EXIST_STUDENT").message(e.getMessage()).build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResultResponse<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResultResponse.fail(null, ErrorCode.builder().code("INVALID_REQUEST").message(e.getMessage()).build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResultResponse<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResultResponse.fail(null, ErrorCode.builder().code("BIND_EXCEPTION").message(e.getMessage()).build());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ResultResponse<Void> handleUnknownException(Exception e) {
        return ResultResponse.fail(null, ErrorCode.builder().code("EXCEPTION").message(e.getMessage()).build());
    }
}
