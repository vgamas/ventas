package com.mintic.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mintic.lagenerica.model.Ventas;

public interface VentasRepository extends MongoRepository<Ventas, Long> {

	@Query(value="{'cedula_cliente': ?0}")
	List<?> ventasPorCliente(Long cliente);
}