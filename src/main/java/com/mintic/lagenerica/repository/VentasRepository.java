package com.mintic.lagenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.lagenerica.model.Ventas;

public interface VentasRepository extends MongoRepository<Ventas, Long> {

	//	List<Producto> findByNombre_producto(String nombre);
	// total de ventas por cliente....
	
}