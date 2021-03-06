package ar.edu.iua.soa.banco.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.iua.soa.banco.model.Liquidacion;

public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer> {

	// get One By Legajo
	@Query(value = "SELECT * FROM liquidacion WHERE legajo=?", nativeQuery = true)
	public List<Liquidacion> findByLegajo(Integer legajo);
	
	// get One By Fecha
	@Query(value = "SELECT * FROM liquidacion WHERE fecha_pago LIKE CONCAT('%',:fecha_pago,'%')", nativeQuery = true)
	public List<Liquidacion> findAllByDate(@Param("fecha_pago") String fecha_pago);
	
	// get One By Fecha
	@Query(value = "SELECT * FROM liquidacion ORDER BY fecha_pago", nativeQuery = true)
	public List<Liquidacion> getAll();
		

}
