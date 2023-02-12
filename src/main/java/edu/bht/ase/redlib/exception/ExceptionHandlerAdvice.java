package edu.bht.ase.redlib.exception;

import edu.bht.ase.redlib.exception.ex.AbstractException;
import edu.bht.ase.redlib.exception.ex.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String STATUS_KEY = "status";
    private static final String REASON_CODE_KEY = "reasonCode";
    private static final String REASON_DESCRIPTION_KEY = "reasonDescription";

    //@ExceptionHandler(value
    //        = {Exception.class})
    //protected ResponseEntity<Object> handleAllExceptions(
    //        Exception ex, WebRequest request) {
    //    return handleExpectedExceptions(AbstractException.getGenericException(), request);
    //}

//    @ExceptionHandler(value
//            = {AbstractException.class})
//    protected ResponseEntity<Object> handleExpectedExceptions(
//            AbstractException ex, WebRequest request) {
//        Map<String, Object> body = new LinkedHashMap<>();
//
//        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value
            = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(
            EntityNotFoundException ex, WebRequest request) {
        Map<String, Object> body = getResponseMap(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> getResponseMap(HttpStatus status, AbstractException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(STATUS_KEY, status.toString());
        body.put(TIMESTAMP_KEY, new Date());
        body.put(REASON_CODE_KEY, exception.getReasonCode());
        body.put(REASON_DESCRIPTION_KEY, exception.getReasonDescription());
        return body;
    }
}
