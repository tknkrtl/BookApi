package bookreviews.api.controller;

import org.omg.CORBA.Current;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import bookreviews.api.error.BookNotFoundException;
import bookreviews.api.error.BooksErrorResponse;


@ControllerAdvice 
public class BookRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BooksErrorResponse> handleNotFoundException(BookNotFoundException exc){
					
		BooksErrorResponse error = new BooksErrorResponse();
			
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		// return ResponseEntity
			
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
	}
	@ExceptionHandler ResponseEntity<BooksErrorResponse> handleAnyException(Exception exc){
		
		BooksErrorResponse error = new BooksErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}

