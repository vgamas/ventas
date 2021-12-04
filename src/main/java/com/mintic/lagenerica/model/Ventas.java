package com.mintic.lagenerica.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_ventas")
public class Ventas {

	@Id
	private Long codigo_venta;
	private Long cedula_cliente;
	private DetalleVentas[] detalle_venta;
	private Double ivaventa;
	private Double total_venta;
	private Double valor_venta;
	
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
		
	public DetalleVentas[] getDetalle_venta() {
		return detalle_venta;
	}

	public void setDetalle_venta(DetalleVentas[] detalle_venta) {
		this.detalle_venta = detalle_venta;
	}

	public Double getIvaventa() {
		return ivaventa;
	}
	
	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}
	
	public Double getTotal_venta() {
		return total_venta;
	}
	
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	
	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
}

