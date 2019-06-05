package ar.edu.iua.soa.banco.business.impl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	final static Logger logger = Logger.getLogger("LiquidacionBusiness.class");
	
	@Override
	public Liquidacion saveLiquidacion(Liquidacion liquidacion) throws BusinessException {
		try {
			return liquidacionDAO.save(liquidacion);	
		} catch (Exception e) {
			logger.error("No se pudo persistir la liquidacion");
			logger.error(e);
			throw new BusinessException();
		}
	}

	@Override
	public List<Liquidacion> getAll() throws BusinessException {
		try {
			return liquidacionDAO.getAll();	
		} catch (Exception e) {
			logger.error("No se pudo obtener la lista de liquidaciones");
			logger.error(e);
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Liquidacion> getAllByDate(String date) throws BusinessException {
		try {
			return liquidacionDAO.findAllByDate(date);	
		} catch (Exception e) {
			logger.error("No se pudo obtener la lista de liquidaciones");
			logger.error(e);
			throw new BusinessException(e);
		}
	}
	

}
