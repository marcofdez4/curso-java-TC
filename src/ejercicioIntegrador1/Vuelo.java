package ejercicioIntegrador1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vuelo extends EmpresaAeronautica{

	private String nombreVuelo;
	private Integer numeroPasajeros;
	private TipoPasaje tipoPasaje;
	private Double valorUnitarioPasaje;
	private LocalDate fechaVuelo;
	
	public Vuelo(String nombreEmpresa, String nombreVuelo, Integer numeroPasajeros, TipoPasaje tipoPasaje,
			Double valorUnitarioPasaje, LocalDate fechaVuelo) {
		super(nombreEmpresa);
		this.nombreVuelo = nombreVuelo;
		this.numeroPasajeros = numeroPasajeros;
		this.tipoPasaje = tipoPasaje;
		this.valorUnitarioPasaje = valorUnitarioPasaje;
		this.fechaVuelo = fechaVuelo;
	}
	
	public String getNombreVuelo() {
		return nombreVuelo;
	}

	public void setNombreVuelo(String nombreVuelo) {
		this.nombreVuelo = nombreVuelo;
	}

	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}

	public void setNumeroPasajeros(Integer numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	public TipoPasaje getTipoPasaje() {
		return tipoPasaje;
	}

	public void setTipoPasaje(TipoPasaje tipoPasaje) {
		this.tipoPasaje = tipoPasaje;
	}

	public Double getValorUnitarioPasaje() {
		return valorUnitarioPasaje;
	}

	public void setValorUnitarioPasaje(Double valorUnitarioPasaje) {
		this.valorUnitarioPasaje = valorUnitarioPasaje;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Double valorFinalPorVuelo() {
		return this.valorUnitarioPasaje*this.numeroPasajeros;
	}
	
	public Integer diasDeDiferencia() {
		LocalDate hoy = LocalDate.now();
		Long dias = ChronoUnit.DAYS.between(hoy, this.fechaVuelo);
		
		return Integer.valueOf(dias.intValue());
	}
	
	public String segmentación() {
		String segmentacion = "";
		Double valor=valorFinalPorVuelo();
		if(this.tipoPasaje.equals(TipoPasaje.ECONOMICO)) {
			if(valor>100) {
				segmentacion = "Rentable";
			}
			else if(valor<100){
				segmentacion = "No rentable";
			}
			else {
				segmentacion = "A confirmar";
			}
		}
		else {
			if(valor>1500) {
				segmentacion = "Rentable";
			}
			else if(valor<1500){
				segmentacion = "No rentable";
			}
			else {
				segmentacion = "A confirmar";
			}
		}
		return segmentacion;
	}

	@Override
	public String toString() {
		return "Vuelo [nombreVuelo=" + nombreVuelo + ", numeroPasajeros=" + numeroPasajeros + ", tipoPasaje="
				+ tipoPasaje + ", valorUnitarioPasaje=" + valorUnitarioPasaje + ", fechaVuelo=" + fechaVuelo + "]";
	}
	
	
	
	
}
