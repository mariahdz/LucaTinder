package com.proyectos.grupo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.error.UsuarioNotFoundException;

//import com.proyectos.grupo01.error.EventoNotFoundException;
//import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Persona;
import com.proyectos.grupo01.repository.PersonaRepository;


	/**
	* Usuario Controller <br>
	* @author Desiree
	* @version 30/07/2021/A
	*/
	@RestController
	@RequestMapping("/")
	public class PersonaController {
	
	private static final Logger log = Logger.getLogger("UsuarioRepository.class");
	
	@Autowired
	PersonaRepository repo;
	
	
	/**
	* Método para añadir un nuevo usuario a la base de datos
	* @param usuarioRequest
	* @return creado
	*
	*/
	@PostMapping("/usuario/save")
	public ResponseEntity <Persona> addUsuario (@RequestBody Persona personaRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ADD USUARIO");
		log.infof("Request: ",personaRequest);
		
		Persona persona = repo.save(personaRequest);
		return new ResponseEntity <> (persona, HttpStatus.CREATED);
	}
	
		/**
		* Método para EDITAR un usuario según su ID
		* @param evento, id
		* @return Usuario
		* @author Desiree
		* @version 30/07/2021
		*/
		@PutMapping("usuario/edit/{id}")
		public ResponseEntity<?> editarUsuario(@RequestBody Persona persona, @PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/EDITAR");
			log.info("----Editando usuario con ID = " + id);
			
			if(!repo.existsById(id)) {
				throw new UsuarioNotFoundException(id);
		
			}else {
		
				persona.setNombre(persona.getNombre());
				persona.setApellido(persona.getApellido());
				persona.setMail(persona.getMail());
				persona.setPassword(persona.getPassword());
		
				return ResponseEntity.ok(repo.save(persona));
		
		}
		
		}
	
	
	/**
	* Método para dar de baja un usuario según su Id
	* @author Desiree
	* @version 14/07/2021
	*/
		@DeleteMapping("persona/delete/{id}")
		public ResponseEntity<?> eliminarUsuario(@PathVariable("nombre") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/BORRAR POR ID");
			log.info("----La persona con ID = " + id);
			int i; //para encontrar usuarios
			repo.deleteById(id);
			return ResponseEntity.noContent().build();
	}
	
	
	
		/**
		* Metodo para listar un usuario por su ID
		*
		* @param String
		* @return usuario
		* @author Desiree
		* @version 14/07/2021
		*/
		@GetMapping(value = "/persona/{id}")
		public Persona encontrarPorNombre(@PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ENCONTRAR POR ID");
			Optional<Persona> personaId = repo.findById(id);
			return personaId.orElseThrow(() -> new UsuarioNotFoundException(id));
		}
	
	
	
}