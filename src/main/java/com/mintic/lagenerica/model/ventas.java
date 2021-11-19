package com.mintic.lagenerica.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_ventas")
public class ventas {

	@Id
	private Long cedula_cliente;
	private long codigo_venta;
	private long detalles_venta;
	private long cantidad_productos;
	private long codico_producto;
	private long valor_total;
	private long valor_venta;
	private long valoriva;
	

	public Long getcedula_cliente() {
		return cedula_cliente;
	}
	
	public void setcedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	public long getcodigo_venta() {
		return codigo_venta;
	}
	
	public void setcodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public long getdetalles_venta() {
		return detalles_venta;
	}
	
	public void setdetalles_venta(long detalles_venta) {
		this.detalles_venta = detalles_venta;
	}

	public long getcantidad_productos() {
		return cantidad_productos;
	}
	
	public void setcantidad_productos(long cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}

	public long getcodigo_producto() {
		return codico_producto;
	}
	public void setcodigo_producto(long codigo_producto){
		this.codico_producto=codigo_producto;
	}

	public long getvalor_total() {
		return valor_total;
	}
	
	public void setvalor_total(long valor_total) {
		this.valor_total = valor_total;
	}


	public long getvalor_venta() {
		return valor_venta;
	}
	
	public void setvalor_venta(long valor_venta) {
		this.valor_venta = valor_venta;
	}

	public long getvaloriva() {
		return valoriva;
	}
	
	public void setvaloriva(long valoriva) {
		this.valoriva = valoriva;
	}

	

			
}

