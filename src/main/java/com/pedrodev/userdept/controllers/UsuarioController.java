package com.pedrodev.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrodev.userdept.model.DepartamentoQtdUsuario;
import com.pedrodev.userdept.model.Usuario;
import com.pedrodev.userdept.repository.DepartamentoRepository;
import com.pedrodev.userdept.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping(path = "/")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping(value="/{id}")
	public Usuario listarUsuarioPorId(@PathVariable Long id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@PostMapping(path="/cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody Usuario usuario){
		Usuario usuarioBody = usuarioService.cadastrarUsuario(usuario);
		return ResponseEntity.ok(usuarioBody);
	}
	
	@GetMapping(path="/listarDepQtdUsuario")
	public List<DepartamentoQtdUsuario[]> listarDepQtdUsu() {
		return departamentoRepository.buscarDepartamentoComQtdUsuarios();
	}

}
