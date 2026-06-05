package com.pedrodev.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodev.userdept.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByEmail(String email);

}
