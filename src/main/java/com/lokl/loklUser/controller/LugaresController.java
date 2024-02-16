package com.lokl.loklUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokl.loklUser.model.Lugares;
import com.lokl.loklUser.service.LugaresService;

@RestController 
@RequestMapping("admin")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LugaresController {

	private LugaresService lugaresService;
	
	
	@Autowired
	public LugaresController(LugaresService lugaresService) {
		this.lugaresService = lugaresService;
	}
	
	
	@GetMapping("lugares")
	public List<Lugares> getLugares() {
		return lugaresService.allLugares();
		}
	
	//path variable, ya que buscamos por id y los id son diferentes entonces necesito definir el endpoint entre llaves y dentro del meteodo debo crear una anotacion @PathVariable
	@GetMapping("lugares/{id}")
	public Lugares getOne(@PathVariable(name = "id") Long id) {
		return lugaresService.getOne(id);
	}
	
	//Delete, de tipo void define un path variable 
	@DeleteMapping("lugares/{id}")
	public void deleteLugar(@PathVariable(name = "id") Long id) {
		lugaresService.deleteLugar(id);
	}
	
	//Post, crear un nuevo usuario
	//¿como agrego usaurios desde Postman? Tenemos que establecer 
	@PostMapping("lugares")
	public Lugares newLugar(@RequestBody Lugares newLugar) {
		return lugaresService.addLugar(newLugar);
	}
	
	//Put, modificar/actualizar a un usuario existente
	@PutMapping("lugares/{id}")
	public Lugares replaceLugar(@RequestBody Lugares lugar, @PathVariable(name = "id") Long id) {
		return lugaresService.replaceLugar(lugar, id);
	}
	
	/*
	 * -- ResponseEntity<> clase de SpringFramework que representa una respuesta HTTP personalizable. Permite controlar el body de la respuesta. Posee dos parámetros:
	 * 		1. Especifica el tipo de datos
	 * 		2. Especifica el código de estado HTTP
	 * -- @RequestParam anotación de springFramework que se utiliza para vincular parámetros de solicitud HTTP que se enviará a la respuesta. Es decir, permite controlar las llaves-valores dentro del parámetro  
	 * */
	//Método para traer un usuario por Email
		@GetMapping("/lugares/byNombre")
		public ResponseEntity<Lugares> getLugarByNombre(@RequestParam(name="nombre") String nombre){
			Lugares lugar = lugaresService.getLugarByNombre(nombre);
			return new ResponseEntity<>(lugar, HttpStatus.OK);
		}
	
}
