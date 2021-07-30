package com.proyectos.grupo01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyectos.grupo01.model.Persona;

/**
 * Usuario Repository<br>
 * @author Desiree
 * @version 30/07/2021/A
 */

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer> {
	

}
