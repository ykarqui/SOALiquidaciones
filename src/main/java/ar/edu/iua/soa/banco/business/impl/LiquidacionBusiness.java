package ar.edu.iua.soa.banco.business.impl;

import java.util.List;

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
		try {
			return liquidacionDAO.save(liquidacion);	
		} catch (Exception e) {
			System.out.println("No se pudo persistir la liquidacion");
			throw new BusinessException();
		}
	}

	@Override
	public List<Liquidacion> getAll() throws BusinessException {
		try {
			return liquidacionDAO.getAll();	
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Liquidacion> getAllByDate(String date) throws BusinessException {
		return liquidacionDAO.findAllByDate(date);
	}
	

}
