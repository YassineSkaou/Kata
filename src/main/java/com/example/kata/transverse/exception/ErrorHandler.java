package com.example.kata.transverse.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    /**
     * Gérer l'exception MethodArgumentNotValidException, déclenchée quand la validation des paramètres d'un controlleur
     * est KO.
     *
     * @return body de la réponse HTTP en cas de cette exception
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Erreur handleMethodArgumentNotValidException(MethodArgumentNotValidException exceptionValidation) {
        Erreur body = new Erreur();
        Map<String, String> errors = new HashMap<>();

        log.error("[Validation] Validation de la requete KO", exceptionValidation);

        exceptionValidation.getBindingResult().getAllErrors().forEach(error -> {
            String nomParam = ((FieldError) error).getField();
            String messageError = error.getDefaultMessage();
            errors.put(nomParam, messageError);
        });

        body.setCode(ConstantsError.KO_VALIDATION_CODE);
        body.setMessage(ConstantsError.KO_VALIDATION_MSG);
        body.setErreurs(errors);

        return body;
    }

    /**
     * Gérer l'exception HttpMessageNotReadableException, déclenchée quand la validation des paramètres d'un controlleur
     * est KO.
     *
     * @return body de la réponse HTTP en cas de cette exception
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Erreur handleForbiddenException(HttpMessageNotReadableException exceptionValidation) {

        Erreur body = new Erreur();
        Map<String, String> errors = new HashMap<>();

        log.error("[Validation] Validation de la requete KO", exceptionValidation);

        String nomParam = "DeliveryMode";
        String messageError = exceptionValidation.getMessage();
        errors.put(nomParam, messageError);

        body.setCode(ConstantsError.KO_VALIDATION_CODE);
        body.setMessage(ConstantsError.KO_VALIDATION_MSG);
        body.setErreurs(errors);

        return body;
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Erreur handleDataAccessException(DataAccessException dataAccessException) {

        Erreur body = new Erreur();
        Map<String, String> errors = new HashMap<>();

        String nomParam = "SQL ERREUR";
        String messageError = dataAccessException.getMessage();
        errors.put(nomParam, messageError);

        body.setCode(ConstantsError.KO_SQL_EXCEPTION_CODE);
        body.setMessage(ConstantsError.KO_SQL_EXCEPTION_MSG);
        body.setErreurs(errors);

        return body;
    }


}
