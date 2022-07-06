package com.formacionspring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspring.web.dao.AreaRepository;
import com.formacionspring.web.dao.EmpleadoRepository;
import com.formacionspring.web.entity.Area;
import com.formacionspring.web.entity.Empleado;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository repositorio;

	@Override
	public List<Area> listaAreas() {	
		return repositorio.findAll();
	}

	@Override
	public Area guardarArea(Area area) {
		return repositorio.save(area);
	}

	@Override
	public Area obtenerAreaPorId(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarArea(Long id) {
		
		repositorio.deleteById(id);
		
	}
	
	
}
