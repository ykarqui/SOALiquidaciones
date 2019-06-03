package ar.edu.iua.soa.banco.web.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.soa.banco.model.Liquidacion;

@RestController
@RequestMapping(Constantes.URL_LIQUIDACION)
public class LiquidacionRestController {

	// Implementar GET: /verPagos^fecha:”22/05/2019”	//llega como string la fecha
	/* hago un get sobre la tabla con fecha de pago
		solo legajo 
		fecha pago
		monto
		estado
		codigo*/
	// Get all Liquidaciones with specific day
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Liquidacion>> getAll(
			@RequestParam(required = false, value = "fecha", defaultValue = "*") String fecha) {
				return null;
		
	}
	
	/*
	 * // Get all tasks
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Orden>> getAll(
			@RequestParam(required = false, value = "ob", defaultValue = "*") String ob) {
		try {

			if (ob.equals("*")) {
				logger.trace("Getting all Tasks");
				return new ResponseEntity<List<Orden>>(taskBusiness.getAll(), HttpStatus.OK);
			} else if (ob.equalsIgnoreCase("priority")) {
				logger.trace("Getting all Tasks, Order By Priority");
				return new ResponseEntity<List<Orden>>(taskBusiness.getAllByPriority(), HttpStatus.OK);
			} else if (ob.equalsIgnoreCase("created")) {
				logger.debug("Getting all Tasks Order By Created Date");
				return new ResponseEntity<List<Orden>>(taskBusiness.getAllByCreated(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Orden>>(HttpStatus.BAD_REQUEST);
			}

		} catch (BusinessException e) {
			logger.error("Http status:" + HttpStatus.INTERNAL_SERVER_ERROR + " in getAll()");
			logger.error(e);
			return new ResponseEntity<List<Orden>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 */
	
}
