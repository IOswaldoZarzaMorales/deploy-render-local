package com.lokl.loklUser.model;

/*
 * En la clase donde se establece la lógica del negocio (model) voy a hacer que coincida con mi DB.
 * Es decir, la clase se convierte en una Entity, con la anotación @Entity 
 * Para establecer la tabla de la DB a la que corresponde esta entidad, utilizamos la anotación @Table(name="table") y el nombre de la tabla
 * Indicarle a JPA mi punto de entrada (PK), usando la anotación @Id
 * Como queremos que el Id sea autoincrementable usamos la anotación @GeneratedValue(strategy = GenerationType.IDENTITY
 * Y si queremos, podemos establecer la columna a la que corresponde cada atributo con la anotación @Column(name="name")
 * 
 */

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="usuario") //nombre de la tabla de la DB

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="correo")
	private String correo;
	@Column(name="contrasena")
	private String contrasena;

	
	// JPA necesita un metodo que le permita contruir cualquier objeto sin tomar en cuenta sus atributos
	public User() {
	}

	
	

	//Constructor
	public User(Long id, String nombre, String correo, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
	}



	//Getters y Setters
	
	public Long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public void setId(Long id) {
		this.id = id;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(contrasena, correo, id, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(correo, other.correo)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	//Tenemos que generar dos metodos adicionales: hashCode() y equals()
	
	
	
	
}
