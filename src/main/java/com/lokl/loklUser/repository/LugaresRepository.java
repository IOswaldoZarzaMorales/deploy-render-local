package com.lokl.loklUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lokl.loklUser.model.Lugares;

public interface LugaresRepository extends JpaRepository<Lugares, Long>{
	// JPQL... Java Persistance Query Language
	@Query("SELECT u FROM Lugares u WHERE u.nombre=?1") //Consultas integradas de JPA
	Lugares findByNombre(String nombre);
}
