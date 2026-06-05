package com.pedrodev.userdept.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmailDuplicadoException.class)
	public ResponseEntity<String> handleEmailDuplicado(EmailDuplicadoException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(DepartamentoNaoEncontradoException.class)
	public ResponseEntity<String> handleDepartamentoNaoEncontrado(DepartamentoNaoEncontradoException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<String> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
