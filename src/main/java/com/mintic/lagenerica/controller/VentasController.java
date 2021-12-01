package com.mintic.lagenerica.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.lagenerica.model.Ventas;
import com.mintic.lagenerica.repository.VentasRepository;

@CrossOrigin(origins = {"http://localhost:8182", "http://localhost:3000"})
@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private VentasRepository ventasRepository;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> crearventa(@RequestBody Ventas ventas){
		return ResponseEntity.status(HttpStatus.CREATED).body(ventasRepository.save(ventas));
	}
	
	@GetMapping("/listar")
	public List<Ventas> listarventas() {
		List<Ventas> listaVentas = StreamSupport.stream(ventasRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listarventas();
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> bucarventasEntity(@PathVariable(value = "id") Long id) {

		Optional<Ventas> oventas = ventasRepository.findById(id) ;
		
		if (oventas.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oventas);
	}

	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> borrarTodos() {

		Ventas oventas = new Ventas();
		
		ventasRepository.deleteAll();;
		
		return ResponseEntity.ok(oventas);
	}


	@PutMapping("actualizar")
	public ResponseEntity<?> actualizarventas(@RequestBody Ventas ventas) {

		Optional<Ventas> ventasAnt = ventasRepository.findById(ventas.getCedula_cliente());
		
		if(ventasAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		ventasAnt.get().setCedula_cliente(ventas.getCedula_cliente());
		ventasAnt.get().setCodigo_venta(ventas.getCodigo_venta());

		//verificar la creacion de la lista

		ventasAnt.get().setDetalle_venta(ventas.getDetalle_venta());

		ventasAnt.get().setIvaventa(ventas.getIvaventa());
		ventasAnt.get().setTotal_venta(ventas.getTotal_venta());
		ventasAnt.get().setValor_venta(ventas.getValor_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventasRepository.save(ventasAnt.get()));	
	}
}
