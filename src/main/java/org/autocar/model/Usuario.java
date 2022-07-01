package org.autocar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@Column(name = "id_usu")
	private int codigo;
	@Column(name = "nom_usu")
	private String nombre;
	@Column(name = "ape_usu")
	private String apellido;
	@Column(name = "usr_usu")
	private String correo;
	@Column(name = "cla_usu")
	private String clave;
	
	
	
	
	public int getCodigo() {
		return codigo;
	}




	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getClave() {
		return clave;
	}




	public void setClave(String clave) {
		this.clave = clave;
	}




	public Usuario(int codigo, String nombre, String apellido, String correo, String clave) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.clave = clave;
	}




	public Usuario() {
		
	}
	
	
	
}
