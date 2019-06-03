package ar.edu.iua.soa.banco.business;

import ar.edu.iua.soa.banco.model.Liquidacion;

public interface ILiquidacionBusiness {
	
	public Liquidacion saveLiquidacion(Liquidacion liquidacion) throws BusinessException;

}
