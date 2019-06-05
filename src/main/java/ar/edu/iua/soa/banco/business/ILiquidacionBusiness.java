package ar.edu.iua.soa.banco.business;

import java.util.List;

import ar.edu.iua.soa.banco.model.Liquidacion;

public interface ILiquidacionBusiness {
	
	public Liquidacion saveLiquidacion(Liquidacion liquidacion) throws BusinessException;
	public List<Liquidacion> getAll() throws BusinessException;
	public List<Liquidacion> getAllByDate(String date) throws BusinessException;

}
