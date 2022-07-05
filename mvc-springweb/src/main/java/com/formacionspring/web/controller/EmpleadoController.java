package com.formacionspring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.formacionspring.web.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping({"/empleados","/"})
	public String listarEmpleados(Model modelo) {
		
		modelo.addAttribute("key",servicio.listaEmpleados());
		return "empleado";
	}
	
	@GetMapping("/empleado/nuevo")
	public String nuevoEmpleado() {
		return "empleado_nuevo";
	}
}
