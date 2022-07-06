package com.formacionspring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspring.web.entity.Area;
import com.formacionspring.web.service.AreaService;

@Controller
public class AreaController {

	@Autowired
	private AreaService servicio;
	
	@GetMapping({"/areas","/"})
	public String listarAreas(Model modelo) {
		
		modelo.addAttribute("key",servicio.listaAreas());
		return "area";
	}
	
	@GetMapping("/area/nuevo")
	public String nuevoArea(Model modelo) {
		//objecto empleado se pasa vacio a la vista empleado_nuevo
		//esto para poder realizar el registro desde los inputs
		Area emp = new Area();
		modelo.addAttribute("area", emp);
		return "area_nuevo";
	}
	
	@PostMapping("/area/registrar")
	public String registrarArea(@ModelAttribute Area area) {
	    servicio.guardarArea(area); 	
		return "redirect:/areas";
	}
	
	@GetMapping("/area/modificar/{id}")
	public String editarArea(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("area", servicio.obtenerAreaPorId(id));
		return "area_editar";
	}
	
	@PostMapping("/area/actualizar/{id}")
	public String actualizarArea(@PathVariable Long id,
			@ModelAttribute("area") Area area) {
	
		Area actualizarEmp= servicio.obtenerAreaPorId(id);
		actualizarEmp.setId(id);
		actualizarEmp.setNombre(area.getNombre());
		actualizarEmp.setCodigo(area.getCodigo());
		
		servicio.guardarArea(actualizarEmp);
		
		return "redirect:/areas";
	}
	
	
	
	@GetMapping("/area/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarArea(id);
		return "redirect:/areas";
	}
	
	
	
	
}
