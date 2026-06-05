package com.pedrodev.userdept.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.pedrodev.userdept.model.DepartamentoQtdUsuario;
import com.pedrodev.userdept.repository.DepartamentoRepository;

public class DepartamentoService {
	
	@Autowired
	public DepartamentoRepository departamentoRepository;
	
	public List<DepartamentoQtdUsuario[]> buscarDepartamentoMaisCheio() {
		return departamentoRepository.buscarDepartamentoComQtdUsuarios();
	}

}
