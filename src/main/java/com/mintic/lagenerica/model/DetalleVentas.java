package com.mintic.lagenerica.model;

public class DetalleVentas {
	private long cantidad_producto;
	private long codigo_producto;
	private Double valor_total;
	private Double valor_venta;
	private Double valoriva;
	
	public long getCantidad_producto() {
		return cantidad_producto;
	}
	
	public void setCantidad_producto(long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	
	public long getCodigo_producto() {
		return codigo_producto;
	}
	
	public void setCodico_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
	public Double getValor_total() {
		return valor_total;
	}
	
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	
	public Double getValor_venta() {
		return valor_venta;
	}
	
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	public Double getValoriva() {
		return valoriva;
	}

	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}
	
}
