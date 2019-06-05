package ar.edu.iua.soa.banco.web.service;

import java.util.List;

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

	// Implementar GET: /verPagos^fecha:”22/05/2019” //llega como string la fecha
	/*
	 * hago un get sobre la tabla con fecha de pago solo legajo fecha pago monto
	 * estado codigo
	 */
	@Autowired
	private ILiquidacionBusiness liquidacionBusiness;

	// Get all Liquidaciones with specific day
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Liquidacion>> getAll(
			@RequestParam(required = false, value = "fecha", defaultValue = "*") String fecha) {
		
		try {
			if (fecha.equals("*")) {
				// logger.trace("Getting all liquidaciones");
				return new ResponseEntity<List<Liquidacion>>(liquidacionBusiness.getAll(), HttpStatus.OK);
			} else if (fecha.length() == 10)  {
				// logger.trace("Getting all liquidaciones, according Date");
				return new ResponseEntity<List<Liquidacion>>(liquidacionBusiness.getAllByDate(fecha), HttpStatus.OK);
				} 
			}catch (BusinessException e) { 
				 // logger.error("Http status:" + HttpStatus.INTERNAL_SERVER_ERROR + " in getAll()"); logger.error(e); 
				return new ResponseEntity<List<Liquidacion>>(HttpStatus.INTERNAL_SERVER_ERROR); 
			}
		
		return null;

	}

	/*
	 * // Get all tasks
	 * 
	 * @RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces =
	 * "application/json") public ResponseEntity<List<Orden>> getAll(
	 * 
	 * @RequestParam(required = false, value = "ob", defaultValue = "*") String ob)
	 * { try {
	 * 
	 * if (fecha.equals("*")) { logger.trace("Getting all Tasks"); return new
	 * ResponseEntity<List<Orden>>(taskBusiness.getAll(), HttpStatus.OK); } else if
	 * (fecha.length()) { logger.trace("Getting all Tasks, Order By Priority");
	 * return new ResponseEntity<List<Orden>>(taskBusiness.getAllByPriority(),
	 * HttpStatus.OK); } else if (ob.equalsIgnoreCase("created")) {
	 * logger.debug("Getting all Tasks Order By Created Date"); return new
	 * ResponseEntity<List<Orden>>(taskBusiness.getAllByCreated(), HttpStatus.OK); }
	 * else { return new ResponseEntity<List<Orden>>(HttpStatus.BAD_REQUEST); }
	 * 
	 * } catch (BusinessException e) { logger.error("Http status:" +
	 * HttpStatus.INTERNAL_SERVER_ERROR + " in getAll()"); logger.error(e); return
	 * new ResponseEntity<List<Orden>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
