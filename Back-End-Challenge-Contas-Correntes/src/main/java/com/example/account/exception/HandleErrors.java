package com.example.account.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class HandleErrors {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body( "Não foi possível realizar o cadastro, documento ja cadastrado");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleErrorsEntity(EntityNotFoundException entityNotFoundException) {
        return new ResponseEntity(entityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity HandleErrors400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DataErrors::new).toList());
    }

    private record DataErrors(String campo, String mensagem) {
        public DataErrors(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleErrors(ConstraintViolationException constraintViolationException) {

        Map<String, List<String>> errorMap = new HashMap<>();

        for (ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
            String nomePropriedade = violation.getPropertyPath().toString();
            String mensagemErro = violation.getMessage();

            errorMap.computeIfAbsent(nomePropriedade, e -> new ArrayList<>()).add(mensagemErro);

        }
        return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity tratarErro400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity tratarErroAuthentication() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity tratarErroAcessoNegado() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}