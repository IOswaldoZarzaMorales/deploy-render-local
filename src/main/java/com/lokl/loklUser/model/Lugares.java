
package com.lokl.loklUser.model;


//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="lugares") //nombre de la tabla de la DB
public class Lugares {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id_lugar")
	private Long id;
	//@Column(name="nombre")
	private String nombre;
	//@Column(name="espacio", nullable=false, length=100)
	private String espacio;
	//@Column(name="capacidad")
	private int capacidad;
	//@Column(name="calle")
	private String calle;
	//@Column(name="no_int")
	private int no_int;
	//@Column(name="no_ext")
	private int no_ext;
	//@Column(name="alcaldia")
	private String alcaldia;
	//@Column(name="estado")
	private String estado;
	//@Column(name="codigo_postal")
	private int codigo_postal;
	//@Column(name="precio")
	private int precio;
	//@Column(name="imagen")
	private String imagen;
	
	
	
	
	// JPA necesita un metodo que le permita contruir cualquier objeto sin tomar en cuenta sus atributos
	public Lugares() {
	}


	

	//CONSTRUCTOR
	public Lugares(Long id, String nombre, String espacio, int capacidad, String calle, int no_int,
			int no_ext, String alcaldia, String estado, int codigo_postal, int precio, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.espacio = espacio;
		this.capacidad = capacidad;
		this.calle = calle;
		this.no_int = no_int;
		this.no_ext = no_ext;
		this.alcaldia = alcaldia;
		this.estado = estado;
		this.codigo_postal = codigo_postal;
		this.precio = precio;
		this.imagen = imagen;
	}





	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getEspacio() {
		return espacio;
	}




	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}




	public int getCapacidad() {
		return capacidad;
	}




	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}




	public String getCalle() {
		return calle;
	}




	public void setCalle(String calle) {
		this.calle = calle;
	}




	public int getNo_int() {
		return no_int;
	}




	public void setNo_int(int no_int) {
		this.no_int = no_int;
	}




	public int getNo_ext() {
		return no_ext;
	}




	public void setNo_ext(int no_ext) {
		this.no_ext = no_ext;
	}




	public String getAlcaldia() {
		return alcaldia;
	}




	public void setAlcaldia(String alcaldia) {
		this.alcaldia = alcaldia;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public int getCodigo_postal() {
		return codigo_postal;
	}




	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}




	public int getPrecio() {
		return precio;
	}




	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;

	}
	@Override
	public String toString() {
		return "Lugares [id=" + id + ", nombre=" + nombre + ", espacio=" + espacio + ", capacidad=" + capacidad
				+ ", calle=" + calle + ", no_int=" + no_int + ", no_ext=" + no_ext + ", alcaldia=" + alcaldia
				+ ", estado=" + estado + ", codigo_postal=" + codigo_postal + ", precio=" + precio + ", imagen=" + imagen + "]";
	}







	
	
	
}
