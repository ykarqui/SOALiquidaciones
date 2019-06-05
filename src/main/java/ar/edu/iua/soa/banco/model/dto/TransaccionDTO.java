package ar.edu.iua.soa.banco.model.dto;

public class TransaccionDTO {

	private String cbu;
	private Double monto;
	private String codigo;
	private String estado;
	
	public TransaccionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransaccionDTO(String cbu, Double monto) {
		super();
		this.cbu = cbu;
		this.monto = monto;
	}
	

	public TransaccionDTO(String cbu, Double monto, String codigo, String estado) {
		super();
		this.cbu = cbu;
		this.monto = monto;
		this.codigo = codigo;
		this.estado = estado;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TransaccionDTO [cbu=" + cbu + ", monto=" + monto + ", codigo=" + codigo + ", estado=" + estado + "]";
	}
}
