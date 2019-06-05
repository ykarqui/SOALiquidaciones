package ar.edu.iua.soa.banco.business.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.soa.banco.business.BusinessException;
import ar.edu.iua.soa.banco.business.IPersonaBusiness;
import ar.edu.iua.soa.banco.model.Liquidacion;
import ar.edu.iua.soa.banco.model.Persona;
import ar.edu.iua.soa.banco.model.dto.TransaccionDTO;
import ar.edu.iua.soa.banco.model.exception.CBUnotFoundException;
import ar.edu.iua.soa.banco.model.persistence.PersonaRepository;
import ar.edu.iua.soa.banco.web.service.TransaccionRestController;
import javassist.NotFoundException;

@Service
public class PersonaBusiness implements IPersonaBusiness {

	@Autowired
	private TransaccionRestController transaccionRC;
	
	@Autowired
	private LiquidacionBusiness liquidacionBO;
	
	@Autowired
	private PersonaRepository personaDAO;
	
	TransaccionDTO transaccionDTO = new TransaccionDTO();
	
	// Busco el CBU y sueldo de la persona con Legajo indicado
	@Override
	public TransaccionDTO getPersona(Integer legajo) throws CBUnotFoundException, BusinessException, NotFoundException {
		
		System.out.println("\n\nIngresa al BO persona con legajo:" + legajo +" \n\n");
		Persona p = new Persona();
		p = personaDAO.findByLegajo(legajo);
		
		System.out.println("\n\nVuelve del Persona DAO como " + p.toString() + "\n\n");
		if (p.getCbu() == null || p.getCbu().length() < 1) {
			
			throw new CBUnotFoundException();
			
		}
		// Tx DTO
		transaccionDTO.setCbu(p.getCbu());
		transaccionDTO.setMonto(p.getMontoMensual());
		
		transaccionRC.sentDataToTx(transaccionDTO);
		System.out.println("\n\nVolvi al personaBO \n\n");
		
		// Persisto la liquidacion
		Date date = new Date();
		Date fechaPago = new java.sql.Date(date.getTime()); 
		
		Liquidacion liquidacion = new Liquidacion();
		
		liquidacion.setMonto(transaccionDTO.getMonto());
		liquidacion.setFechaPago(fechaPago);
		liquidacion.setLegajo(p.getLegajo());
		liquidacion.setCodigo(transaccionDTO.getCodigo());
		liquidacion.setEstado(transaccionDTO.getEstado());
		System.out.println("\n\nLiquidacion a persistir: "+liquidacion.toString()+ "\n\n");
		liquidacionBO.saveLiquidacion(liquidacion);
		
		System.out.println("\n\nVuelve del liquidacion BO \n\n");
		return transaccionDTO;
	}
}
