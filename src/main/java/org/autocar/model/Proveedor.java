package org.autocar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_proveedor")
public class Proveedor {

	@Id
	@Column(name = "id_provee")
	private String idproveedor;
	
	@Column(name = "nom_provee")
	private String nombre;
	
	@Column(name = "dir_provee")
	private String direccion;
	
	private String pais;

	public String getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Proveedor(String idproveedor, String nombre, String direccion, String pais) {
		
		this.idproveedor = idproveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
	}

	public Proveedor() {
		
	}
	
	
	
	
}
