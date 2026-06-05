package com.pedrodev.userdept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pedrodev.userdept.model.Departamento;
import com.pedrodev.userdept.model.DepartamentoQtdUsuario;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	
	@Query(value = "select departamento.nome, count(usuario.id_departamento_FK) as QTD from departamento\r\n"
			+ "inner join usuario on departamento.id = usuario.id_departamento_FK\r\n"
			+ "group by departamento.nome", nativeQuery = true)
	public List<DepartamentoQtdUsuario[]> buscarDepartamentoComQtdUsuarios();

}
