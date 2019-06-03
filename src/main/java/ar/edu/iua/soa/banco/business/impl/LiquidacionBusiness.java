package ar.edu.iua.soa.banco.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.soa.banco.business.BusinessException;
import ar.edu.iua.soa.banco.business.ILiquidacionBusiness;
import ar.edu.iua.soa.banco.model.Liquidacion;
import ar.edu.iua.soa.banco.model.persistence.LiquidacionRepository;

@Service
public class LiquidacionBusiness implements ILiquidacionBusiness{

	@Autowired
	LiquidacionRepository liquidacionDAO;
	
	@Override
	public Liquidacion saveLiquidacion(Liquidacion liquidacion) throws BusinessException {
		
		liquidacionDAO.save(liquidacion);
		
		return null;
	}
	

}
