package ar.edu.iua.soa.banco.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.soa.banco.business.BusinessException;
import ar.edu.iua.soa.banco.business.IPersonaBusiness;
import ar.edu.iua.soa.banco.model.Persona;
import ar.edu.iua.soa.banco.model.dto.TransaccionDTO;
import ar.edu.iua.soa.banco.model.exception.CBUnotFoundException;
import javassist.NotFoundException;


@RestController
@RequestMapping(Constantes.URL_PERSONA)
public class PersonaRestController {
	
	@Autowired
	private IPersonaBusiness personaBusiness;
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<TransaccionDTO> add (@RequestBody Persona persona) {
		try {
			System.out.println("\n\nIngresa al RC persona \n\n");
			System.out.println("Legajo: " + persona.getLegajo());
			TransaccionDTO p = personaBusiness.getPersona(persona.getLegajo());
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", "/transaccion/" + p.getCbu());
			System.out.println("\n\nTermina el request enviado \n\n");
			return new ResponseEntity<TransaccionDTO>(p, responseHeaders, HttpStatus.CREATED);
			
		} catch (CBUnotFoundException cbu) {
			// CBU not found
			System.out.println("CBU no registrado aun");
			System.out.println(cbu);
			return new ResponseEntity<TransaccionDTO>(HttpStatus.NOT_FOUND);
		} catch (NotFoundException nfe) {
			// not found legajo
			return new ResponseEntity<TransaccionDTO>(HttpStatus.NOT_FOUND);
		} catch (BusinessException e) {
			// BO exception
			System.err.println(e);
			return new ResponseEntity<TransaccionDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
}