package com.pedrodev.userdept.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do usuário não pode ser vazio!")
	private String nome;
	
	@Email(message ="Email é inválido!")
	@NotBlank(message = "O Email é obrigatório!")
	@Column(unique = true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento_FK")
	@NotNull(message = "É preciso informar o departamento")
	private Departamento departamento;

}
