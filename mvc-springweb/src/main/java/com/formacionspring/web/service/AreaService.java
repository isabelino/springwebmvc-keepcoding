package com.formacionspring.web.service;

import java.util.List;

import com.formacionspring.web.entity.Area;


public interface AreaService {
    //metodo para listar todos los empleados
	public List<Area> listaAreas();
	//metodo para guardar empleado
	public Area guardarArea(Area area);
	//metodo para obtener un empleado por id
	public Area obtenerAreaPorId(Long id);
	//metodo para eliminar un empleado por id
	public void eliminarArea(Long id);
}
