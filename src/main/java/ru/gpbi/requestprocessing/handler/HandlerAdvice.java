package ru.gpbi.requestprocessing.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.gpbi.requestprocessing.exception.EntityNotFoundException;
import ru.gpbi.requestprocessing.exception.LimitExceedingException;
import ru.gpbi.requestprocessing.model.response.ResponseError;

@Slf4j
@ControllerAdvice
public class HandlerAdvice {


		@ExceptionHandler(EntityNotFoundException.class)
		public ResponseEntity<ResponseError> handleApiConnectException(EntityNotFoundException exc) {
				return new ResponseEntity<>(new ResponseError().setMessage(exc.getMessage()), HttpStatus.BAD_REQUEST);
		}

		@ExceptionHandler(LimitExceedingException.class)
		public ResponseEntity<ResponseError> handleApiConnectException(LimitExceedingException exc) {
				return new ResponseEntity<>(new ResponseError().setMessage(exc.getMessage()), HttpStatus.BAD_REQUEST);
		}

}
