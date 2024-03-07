
package com.lokl.loklUser.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lokl.loklUser.exceptions.UserNotFoundException;
import com.lokl.loklUser.model.Lugares;
import com.lokl.loklUser.repository.LugaresRepository;



@Service
public class LugaresService {
	//Elminamos todo lo relacionado al ArrayList que creamos para instanciar objetos
		//Ahora, vamos a traer a JPA para que me brinde los metodos para recuperar los datos 
		private final LugaresRepository repository;
		
		
		//Constructor permite inyeccion de dependencias
		@Autowired
		public LugaresService(LugaresRepository repository) {
			this.repository = repository;
		}
		//Crear método de tipo Get para traer a todos los usuarios 
			public List<Lugares> allLugares() {
				return repository.findAll();
			}
		
			//Crear método de tipo get para traer un usuario por id, si no encuentra al usuario arroja una exception (default o personalizada)
			public Lugares getOne(Long id) {
				return repository.findById(id)
						.orElseThrow(() -> new UserNotFoundException(id)); //Estoy creando una exception personalizada que vivirá en otra clase con el mismo nombre de la exception
			}
			
		//Crear metodo para eliminar un usuario por id. Primero debemos comprobar que el usuario con el id realmente existe, en caso de existir se elimina, si no, se lanza una Exception por default (IllegalStateException)
			public void deleteLugar(Long id) {
				if  (repository.existsById(id)) {
					repository.deleteById(id);
				}
				else {
					throw new IllegalStateException("El lugar con el id " + id + " no existe");
					
					
				}
			}
		
			/*Post, crear un nuevo usuario. 
			 * Primero tengo que consultar la DB para saber si el usuario existe. Por ello, debo definir de qué manera buscaré a mi usuario. En este caso será mediante email.
			 * Si el usuario con un email asociado existe, no puede crear un nuevo usuario con el mismo email.
			 * Si no hay un usuario con el email asociado, se crea un nuevo usuario.
			 * Tenemos que definir la búsqueda específica por email (findByEmail) utilizando una consulta de tipo JPQL, la cual se realiza dentro la interface UserRepository ya que ahí se implementan todas los métodos de JPA
			 */
			public Lugares addLugar(Lugares lugar) {
				//Crear una variable de tipo User para buscar el email de usuario. Traemos el valor de la DB y después realizo la sentencia condicional (!if), si es true se cumple, en caso contrario, arrojar una excepción
				//Lugares existingLugar = repository.findByNombre(lugar.getNombre());
				//if (existingLugar != null) {
					//throw new IllegalStateException("El lugar registrado ya esta asociado a un lugar existente");
				//}
				return repository.save(lugar);
			}
			
			/*
			 * Crear metodo put para actualizar la informacion de un usuario.
			 * Debemos iterar cada key/value del objeto para observar las modificaciones y aplicarlas en el atributo especifico. Para ello nos valemos de un metodo .map
			 * */
			
			public Lugares replaceLugar(Lugares lugar, Long id) {
				return repository.findById(id)
						.map(lugarMap -> {  //Funcion lambda
							lugarMap.setEspacio(lugar.getEspacio());
							lugarMap.setNombre(lugar.getNombre());
							lugarMap.setCapacidad(lugar.getCapacidad());
							lugarMap.setCalle(lugar.getCalle());
							lugarMap.setNo_int(lugar.getNo_int());
							lugarMap.setNo_ext(lugar.getNo_ext());
							lugarMap.setAlcaldia(lugar.getAlcaldia());
							lugarMap.setEstado(lugar.getEstado());
							lugarMap.setCodigo_postal(lugar.getCodigo_postal());
							lugarMap.setPrecio(lugar.getPrecio());
							lugarMap.setImagen(lugar.getImagen());
							return repository.save(lugarMap);
						})
						.orElseGet(() -> {
							lugar.setId(id);
							return repository.save(lugar);
						});
			}
			
		/*
		 * Podemos buscar un usuario por medio de su correo para recuperar informacion para ello dependemos de JPQL en el repository y ResponseEntity que se ejecutara en el controller
		 * Vamos a crear un metodo para buscar un usuario por email 'getUserbyEmail'
		 * */
			public Lugares getLugarByNombre(String nombre) {
				return repository.findByNombre(nombre);
			}
		
		
		
}
