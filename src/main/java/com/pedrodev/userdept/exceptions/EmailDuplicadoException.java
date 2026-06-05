package com.pedrodev.userdept.exceptions;

@SuppressWarnings("serial")
public class EmailDuplicadoException extends RuntimeException {

	public EmailDuplicadoException(String message) {
		super(message);
	}
}
