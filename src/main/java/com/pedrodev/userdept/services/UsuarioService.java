package com.pedrodev.userdept.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodev.userdept.exceptions.DepartamentoNaoEncontradoException;
import com.pedrodev.userdept.exceptions.EmailDuplicadoException;
import com.pedrodev.userdept.exceptions.UsuarioNaoEncontradoException;
import com.pedrodev.userdept.model.Departamento;
import com.pedrodev.userdept.model.Usuario;
import com.pedrodev.userdept.repository.DepartamentoRepository;
import com.pedrodev.userdept.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Usuario> listarUsuarios(){
		
		if(usuarioRepository.findAll().isEmpty()) {
			throw new UsuarioNaoEncontradoException("Sem usuários para listar");
		}
		
		return usuarioRepository.findAll(); 
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		
		if(departamentoRepository.findById(usuario.getDepartamento().getId()) == null) {
			throw new DepartamentoNaoEncontradoException("Erro: Departamento não encontrado!");
		}
		
		if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			throw new EmailDuplicadoException("Erro: Email já existente!");
		}
		
		return usuarioRepository.save(usuario);
		
		
	}
	
	public Usuario buscarUsuarioPorId(Long id) {	
		
		return usuarioRepository.findById(id).
				orElseThrow(() -> 
				new UsuarioNaoEncontradoException("Usuário não encontrado!"));

		
	}
	
	public Usuario buscarUsuarioPorEmail(Usuario usuario) {
		return usuarioRepository.findByEmail(usuario.getEmail());
	}
	
	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		
		Usuario usuarioDb = buscarUsuarioPorId(id);
		
		if (usuarioDb == null) {
			throw new UsuarioNaoEncontradoException("Erro: Usuário não encontrado");
		}
		
		Usuario usuEmail = buscarUsuarioPorEmail(usuario);
		
		if(usuEmail.getId() != id) {
			throw new EmailDuplicadoException("Erro: Email já existente");
		}
		
		if(departamentoRepository.findById(usuario.getDepartamento().getId()) == null) {
			throw new DepartamentoNaoEncontradoException("Erro: Departamento não encontrado");
		}
		
		usuario.setId(id);
		
		return usuarioRepository.save(usuario);
	}

}
