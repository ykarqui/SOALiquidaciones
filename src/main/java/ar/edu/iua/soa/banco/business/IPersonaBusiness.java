package ar.edu.iua.soa.banco.business;

import ar.edu.iua.soa.banco.model.dto.TransaccionDTO;
import ar.edu.iua.soa.banco.model.exception.CBUnotFoundException;
import javassist.NotFoundException;

public interface IPersonaBusiness {
	public TransaccionDTO getPersona(Integer legajo) throws CBUnotFoundException, BusinessException, NotFoundException;

}
