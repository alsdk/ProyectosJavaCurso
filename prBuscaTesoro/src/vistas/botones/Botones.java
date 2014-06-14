package vistas.botones;

import javax.swing.JButton;

public class Botones extends JButton {
	private double premio;
	private String nombrefich;
	private boolean pulsado;
	
	public double getPremio() {
		return premio;
	}
	public void setPremio(double premio) {
		this.premio = premio;
	}
	public String getNombrefich() {
		return nombrefich;
	}
	public void setNombrefich(String nombrefich) {
		this.nombrefich = nombrefich;
	}
	public boolean isPulsado() {
		return pulsado;
	}
	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}
	
	
}
