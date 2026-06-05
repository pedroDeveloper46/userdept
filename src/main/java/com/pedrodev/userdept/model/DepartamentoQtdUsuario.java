package com.pedrodev.userdept.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoQtdUsuario {
	
	private String nome;
	
	private Long qtd;

	public DepartamentoQtdUsuario(String nome, Long qtd) {
		
		this.nome = nome;
		this.qtd = qtd;
	}
	
	

}
