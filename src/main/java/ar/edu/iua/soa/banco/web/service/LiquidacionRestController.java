package ar.edu.iua.soa.banco.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.soa.banco.business.BusinessException;
import ar.edu.iua.soa.banco.business.ILiquidacionBusiness;
import ar.edu.iua.soa.banco.model.Liquidacion;

@RestController
@RequestMapping(Constantes.URL_LIQUIDACION)
public class LiquidacionRestController {

	@Autowired
	private ILiquidacionBusiness liquidacionBusiness;

	final static Logger logger = Logger.getLogger("LiquidacionRESTController.class");

	// Get all Liquidaciones with specific day
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Liquidacion>> getAll(
			@RequestParam(required = false, value = "fecha", defaultValue = "*") String fecha) {

		try {
			if (fecha.equals("*")) {
				logger.trace("Getting all liquidaciones");
				return new ResponseEntity<List<Liquidacion>>(liquidacionBusiness.getAll(), HttpStatus.OK);
			} else if (fecha.length() > 3) {
				logger.trace("Getting all liquidaciones, according Date");
				return new ResponseEntity<List<Liquidacion>>(liquidacionBusiness.getAllByDate(fecha), HttpStatus.OK);
			}
		} catch (BusinessException e) {
			logger.error("Http status:" + HttpStatus.INTERNAL_SERVER_ERROR + " in getAll()");
			logger.error(e);
			return new ResponseEntity<List<Liquidacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return null;

	}

}
