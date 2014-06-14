package lib;

public class Pasajeros {
	private String nombre;
	private String origen;
	private String destino;
	
	public Pasajeros(String nom) {
		this.nombre = nom;
	}
	
	public void setOrigen(String orig) {
		this.origen = orig;
	}
	
	public void setDestino(String dest) {
		this.destino = dest;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public String getDestino() {
		return destino;
	}
}