package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import antlr.collections.List;

public class EmpleadosController {

	@Autowired
	EmpleadoServiceImpl EmpleadoServideImpl;
	
	@GetMapping("/Empleados")
	public List<Empleado> listarEmpleados(){
		return EmpleadoServideImpl.listarEmpleados();
	}
	
	//listar Empleados por campo nombre
	@GetMapping("/Empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name="nombre") String nombre) {
	    return EmpleadoServideImpl.listarEmpleadoNomnbre(nombre);
	}
	
	
	@PostMapping("/Empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado Empleado) {
		
		return EmpleadoServideImpl.guardarEmpleado(Empleado);
	}
	
	
	@GetMapping("/Empleados/{id}")
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado Empleado_xid= new Empleado();
		
		Empleado_xid=EmpleadoServideImpl.EmpleadoXID(id);
		
		System.out.println("Empleado XID: "+Empleado_xid);
		
		return Empleado_xid;
	}
	
	@PutMapping("/Empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado Empleado_seleccionado= new Empleado();
		Empleado Empleado_actualizado= new Empleado();
		
		Empleado_seleccionado= EmpleadoServideImpl.EmpleadoXID(id);
		
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setApellido(Empleado.getApellido());
		Empleado_seleccionado.setDireccion(Empleado.getDireccion());
		Empleado_seleccionado.setDni(Empleado.getDni());
		Empleado_seleccionado.setFecha(Empleado.getFecha());
		
		Empleado_actualizado = EmpleadoServideImpl.actualizarEmpleado(Empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ Empleado_actualizado);
		
		return Empleado_actualizado;
	}
	
	@DeleteMapping("/Empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		EmpleadoServideImpl.eliminarEmpleado(id);
	}
	
}
