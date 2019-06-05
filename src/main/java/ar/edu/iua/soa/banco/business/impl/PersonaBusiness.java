package ar.edu.iua.soa.banco.business.impl;

import java.util.Date;

import org.apache.log4j.Logger;
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
	
	final static Logger logger = Logger.getLogger("PersonaBusiness.class");
	
	// Busco el CBU y sueldo de la persona con Legajo indicado
	@Override
	public TransaccionDTO getPersona(Integer legajo) throws CBUnotFoundException, NotFoundException, BusinessException {
		
		logger.trace("Ingresa al BO persona con legajo:" + legajo);
		Persona p = new Persona();
		if (personaDAO.findByLegajo(legajo) == null) {
			throw new NotFoundException("Legajo no registrado");
		}
		p = personaDAO.findByLegajo(legajo);
		
		logger.trace("Vuelve del Persona DAO como " + p.toString());
		if (p.getCbu() == null || p.getCbu().length() < 1) {
			logger.error("CBU error");
			logger.error("CBU obtained: " + p.getCbu());
			throw new CBUnotFoundException();
			
		}
		
		// Tx DTO
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		transaccionDTO.setCbu(p.getCbu());
		transaccionDTO.setMonto(p.getMontoMensual());
		
		transaccionRC.sentDataToTx(transaccionDTO);
		logger.trace("Volvi al personaBO");
		
		// Persisto la liquidacion
		Date date = new Date();
		Date fechaPago = new java.sql.Date(date.getTime()); 
		
		Liquidacion liquidacion = new Liquidacion();
		
		liquidacion.setMonto(transaccionDTO.getMonto());
		liquidacion.setFechaPago(fechaPago);
		liquidacion.setLegajo(p.getLegajo());
		liquidacion.setCodigo(transaccionDTO.getCodigo());
		liquidacion.setEstado(transaccionDTO.getEstado());
		logger.trace("Liquidacion a persistir:" + liquidacion.toString());
		
		liquidacionBO.saveLiquidacion(liquidacion);
		logger.trace("Vuelve del liquidacion BO");
		
		return transaccionDTO;
	}
}
