package com.formacionspring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspring.web.dao.EmpleadoRepository;
import com.formacionspring.web.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository repositorio;
	
	@Override
	public List<Empleado> listaEmpleados() {
		return repositorio.findAll();
	}

}
