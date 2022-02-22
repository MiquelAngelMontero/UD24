package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoServiceIMPL;

@RestController
@RequestMapping("/api")
public class EmpleadosController {

	@Autowired
	EmpleadoServiceIMPL empleadoServiceImpl;
	
	@GetMapping("/Empleados")
	public List<Empleado> listarEmpleados(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	//listar Empleados por campo nombre
	@GetMapping("/Empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name="nombre") String nombre) {
	    return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}
	
	
	@PostMapping("/Empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado Empleado) {
		
		return empleadoServiceImpl.guardarEmpleado(Empleado);
	}
	
	
	@GetMapping("/Empleados/{id}")
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado Empleado_xid= new Empleado();
		
		Empleado_xid=empleadoServiceImpl.empleadoXID(id);
		
		System.out.println("Empleado XID: "+Empleado_xid);
		
		return Empleado_xid;
	}
	
	@PutMapping("/Empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado Empleado_seleccionado= new Empleado();
		Empleado Empleado_actualizado= new Empleado();
		
		Empleado_seleccionado= empleadoServiceImpl.empleadoXID(id);
		
		Empleado_seleccionado.setId(Empleado.getId());
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setTrabajo(Empleado.getTrabajo());
		Empleado_seleccionado.setSalario(Empleado.getSalario());
		Empleado_seleccionado.setFecha(Empleado.getFecha());
		
		Empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(Empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ Empleado_actualizado);
		
		return Empleado_actualizado;
	}
	
	@DeleteMapping("/Empleados/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
	
}
