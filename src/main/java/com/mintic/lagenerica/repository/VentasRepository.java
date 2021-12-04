package com.mintic.lagenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mintic.lagenerica.model.Ventas;

public interface VentasRepository extends MongoRepository<Ventas, Long> {

	//	List<Producto> findByNombre_producto(String nombre);
	// total de ventas por cliente....
	@Query(value="{ cedula_cliente: ?0, sum : {$sum: valor_venta } }")
	Double totalVentasPorCliente(Long cliente);
	
	@Query(value="{sum: valor_venta}")
	Double totalVentasPorCiudad();
}