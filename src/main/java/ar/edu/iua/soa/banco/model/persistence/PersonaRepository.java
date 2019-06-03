package ar.edu.iua.soa.banco.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.iua.soa.banco.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	// getOneByLegajo
	@Query(value="SELECT * FROM persona WHERE legajo=?", nativeQuery=true)
	public Persona findByLegajo(Integer legajo);

}

