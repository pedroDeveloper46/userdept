package com.pedrodev.userdept.exceptions;

@SuppressWarnings("serial")
public class DepartamentoNaoEncontradoException extends RuntimeException {

	public DepartamentoNaoEncontradoException(String message) {
		super(message);
	}
	
}
