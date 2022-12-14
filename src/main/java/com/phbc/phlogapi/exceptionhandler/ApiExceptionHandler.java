package com.phbc.phlogapi.exceptionhandler;

import com.phbc.phlogapi.domain.exception.DomainException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Campo> campos = new ArrayList<>();
        Erro erro = new Erro();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            campos.add(new Campo(nome, mensagem));
        }

        erro.setStatus(status.value());
        erro.setDataHora(LocalDateTime.now());
        erro.setTitulo("Um ou mais campos estão inválidos.");
        erro.setCampos(campos);

        return handleExceptionInternal(ex, erro, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDataHora(LocalDateTime.now());
        erro.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }
}
