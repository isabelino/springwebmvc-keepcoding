package com.formacionspring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspring.web.entity.Empleado;
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
	public String nuevoEmpleado(Model modelo) {
		//objecto empleado se pasa vacio a la vista empleado_nuevo
		//esto para poder realizar el registro desde los inputs
		Empleado emp = new Empleado();
		modelo.addAttribute("empleado", emp);
		return "empleado_nuevo";
	}
	
	@PostMapping("/empleado/registrar")
	public String registrarEmpleado(@ModelAttribute Empleado empleado) {
	    servicio.guardarEmpleado(empleado); 	
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleado/modificar/{id}")
	public String editarEmpleado(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(id));
		return "empleado_editar";
	}
	
	@PostMapping("/empleado/actualizar/{id}")
	public String actualizarEmpleado(@PathVariable Long id,
			@ModelAttribute("empleado") Empleado empleado) {
		
		Empleado actualizarEmp= servicio.obtenerEmpleadoPorId(id);
		actualizarEmp.setId(id);
		actualizarEmp.setNombre(empleado.getNombre());
		actualizarEmp.setApellido(empleado.getApellido());
		actualizarEmp.setEmail(empleado.getEmail());
		actualizarEmp.setTelefono(empleado.getTelefono());
		
		servicio.guardarEmpleado(actualizarEmp);
		
		return "redirect:/empleados";
		
	}
	
	
	@GetMapping("/empleado/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
		return "redirect:/empleados";
	}
	
	
	
	
}
