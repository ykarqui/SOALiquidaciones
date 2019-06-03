package ar.edu.iua.soa.banco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "liquidacion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Liquidacion {
	/*	- Legajo
		- Fecha de pago // saco del sistema
		- Monto pagado (de la transacción)	//saco del legajo
		- Estado de transacción	//recibo de otro lado
		- Código de aprobación	//recibo del servicio web
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "legajo")
	private Integer legajo;
	
	@Column(name = "fechaPago")
	private Date fechaPago;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "codigo")
	private String codigo;
	
	
	public Liquidacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Liquidacion(Integer legajo, Date fechaPago, Double monto, String estado, String codigo) {
		super();
		this.legajo = legajo;
		this.fechaPago = fechaPago;
		this.monto = monto;
		this.estado = estado;
		this.codigo = codigo;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	

}
