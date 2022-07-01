package org.autocar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_productos")
public class Productos {
	
	@Id
	@Column(name = "id_prod")
	private String idprod; 
	
	@Column(name = "nom_prod")
	private String nomprod;
	
	@Column(name = "descripcion_prod")
	private String descripcion;
	
	@Column(name = "id_provee")
	private String idproveedor;
	
	@Column(name = "precio_prod")
	private double precio;
	
	@Column(name = "cantidad_prod")
	private int cantidad;

	public String getIdprod() {
		return idprod;
	}

	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}

	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Productos(String idprod, String nomprod, String descripcion, String idproveedor, double precio,
			int cantidad) {
		
		this.idprod = idprod;
		this.nomprod = nomprod;
		this.descripcion = descripcion;
		this.idproveedor = idproveedor;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Productos() {
		
	}
	
	
}
