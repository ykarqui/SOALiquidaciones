package ar.edu.iua.soa.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "legajo")
	private Integer legajo;
	
	@Column(name = "cbu")
	private String cbu;
	
	@Column(name = "monto_mensual")
	private Double montoMensual;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(Integer id, Integer legajo, String cbu, Double montoMensual) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.cbu = cbu;
		this.montoMensual = montoMensual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public Double getMontoMensual() {
		return montoMensual;
	}

	public void setMontoMensual(Double montoMensual) {
		this.montoMensual = montoMensual;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", legajo=" + legajo + ", cbu=" + cbu + ", montoMensual=" + montoMensual + "]";
	}
}
