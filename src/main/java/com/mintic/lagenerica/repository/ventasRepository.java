package com.mintic.lagenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.lagenerica.model.ventas;

public interface ventasRepository extends MongoRepository<ventas, Long> {

//	List<Producto> findByNombre_producto(String nombre);
}