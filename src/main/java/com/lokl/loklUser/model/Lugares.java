package com.lokl.loklUser.model;


import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="lugares") //nombre de la tabla de la DB
public class Lugares {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_lugar")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Enumerated(EnumType.STRING) 
	@Column(name="tipo_espacio")
	private TipoEspacio tipoEspacio;
	@Enumerated(EnumType.STRING) 
	@Column(name="capacidad")
	private Capacidad capacidad;
	@Column(name="calle")
	private String calle;
	@Column(name="no_int")
	private int no_int;
	@Column(name="no_ext")
	private int no_ext;
	@Column(name="alcaldia")
	private String alcaldia;
	@Column(name="estado")
	private String estado;
	@Column(name="codigo_postal")
	private int codigo_postal;
	@Column(name="precio")
	private int precio;
	
	
	
	
	
	public enum TipoEspacio {
	    SALON,
	    JARDIN,
	    TERRAZA,
	    FORO,
	    OTRO
	}
	public enum Capacidad {
	    CINCUENTA(50),
	    CIEN(100),
	    CIENTOCUENTA(150),
	    DOSCIENTOS(200),
	    DOSCIENTOSCINCUENTA(250),
	    TRESCIENTOS(300),
	    TRESCIENTOSCINCUENTA(350),
	    CUATROCIENTOS(400),
	    CUATROCIENTOSCINCUENTA(450),
	    QUINIENTOS(500),
	    QUINIENTOSCINCUENTA(550),
		MASDE550(+550);
	private final int valor;

	    Capacidad(int valor) {
	        this.valor = valor;
	    }

	    public int getValor() {
	        return valor;
	    }
	}
	
	// JPA necesita un metodo que le permita contruir cualquier objeto sin tomar en cuenta sus atributos
	public Lugares() {
	}


	

	//CONSTRUCTOR
	public Lugares(Long id, String nombre, TipoEspacio tipoEspacio, Capacidad capacidad, String calle, int no_int,
			int no_ext, String alcaldia, String estado, int codigo_postal, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.tipoEspacio = tipoEspacio;
		this.capacidad = capacidad;
		this.calle = calle;
		this.no_int = no_int;
		this.no_ext = no_ext;
		this.alcaldia = alcaldia;
		this.estado = estado;
		this.codigo_postal = codigo_postal;
		this.precio = precio;
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




	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}




	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}




	public Capacidad getCapacidad() {
		return capacidad;
	}




	public void setCapacidad(Capacidad capacidad) {
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




	@Override
	public String toString() {
		return "Lugares [id=" + id + ", nombre=" + nombre + ", tipoEspacio=" + tipoEspacio + ", capacidad=" + capacidad
				+ ", calle=" + calle + ", no_int=" + no_int + ", no_ext=" + no_ext + ", alcaldia=" + alcaldia
				+ ", estado=" + estado + ", codigo_postal=" + codigo_postal + ", precio=" + precio + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(alcaldia, calle, capacidad, codigo_postal, estado, id, no_ext, no_int, nombre, precio,
				tipoEspacio);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lugares other = (Lugares) obj;
		return Objects.equals(alcaldia, other.alcaldia) && Objects.equals(calle, other.calle)
				&& capacidad == other.capacidad && codigo_postal == other.codigo_postal
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id) && no_ext == other.no_ext
				&& no_int == other.no_int && Objects.equals(nombre, other.nombre) && precio == other.precio
				&& tipoEspacio == other.tipoEspacio;
	}
	
	
	
}
