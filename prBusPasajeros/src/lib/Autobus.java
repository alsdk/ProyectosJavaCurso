package lib;

public class Autobus {
	private String [] ciudades = {"Cuenca", "Malaga", "Barcelona", "Madrid", "Asperones"};			// la ruta del viaje
	private Pasajeros [] pasajero;
	private int ciudad;				// en que ciudad estamos actualmente (ahora mismo 0 = malaga)
	
	// constructor que define el numero de pasajeros del autobus maximo
	public Autobus(int s) {
		pasajero = new Pasajeros[s];
	}

	public void introducir(Pasajeros pas) {
		boolean encontrado = false;
		
		for (int i = 0; i < pasajero.length && !encontrado; ++i) {			// buscamos un sitio libre en el array pasajero[]
			if (pasajero[i] == null) { 										// hay un sitio libre
				pasajero[i] = pas;
				encontrado = true;											// flag para salir del bucle
				System.out.println("[+] Pasajero " + pas.getNombre() + " introducido satisfactoriamente");
			}
		}
		if (!encontrado) 
			System.out.println("[-] ERROR, no hay sitio para mas pasajeros");
	}

	private void imprimir(Pasajeros p) {
		System.out.print("[+] \"" + p.getNombre() + "\" ");
		if (p.getOrigen() != null)
			System.out.println("subio en la estacion de \"" + p.getOrigen() + "\"");
		else
			System.out.println("[+] No tiene estacion de origen");
		if (p.getDestino() != null)
			System.out.println("[+] se baja en la estacion de \"" + p.getDestino() + "\"");
		else
			System.out.println("[+] No tiene estacion de destino");
	}
	
	// bajar pasajero del autobus buscandolo por su nombre
	public void bajar(String nombre) {
		boolean encontrado = false;
		
		for (int i = 0; i < pasajero.length && !encontrado; ++i) {
			try {
				if (pasajero[i].getNombre().equals(nombre)) {						// el pasajero existe en el array
					imprimir(pasajero[i]);
					pasajero[i] = null; 										// marcar como libre
					encontrado = true;
				}
			}
			catch (NullPointerException e) {
			}
		}
	
		if (!encontrado)
			System.out.println("[-] ERROR, el pasajero \"" + nombre + "\" no esta en el autobus");
		else
			System.out.println("[+] Pasajero " + nombre + " se ha bajado del autobus");
		System.out.println();
	}
	
	// bajar el pasajero al llegar a una ciudad concreta
	public void bajar() {
		for (int pos = 0; pos < pasajero.length; pos++) {
			try {
				if (ciudades[ciudad].equals(pasajero[pos].getDestino())) {			// la ciudad en la que estoy es igual al destino del pasajero
					imprimir(pasajero[pos]);
					pasajero[pos] = null;		// marcar como libre
					//System.gc();				// llamar al recolector de basura
				}
			}
			catch (NullPointerException e) {
			}
		}
	}
	
	public void mover() {
		//ciudad = (ciudad+1) % ciudades.length;			// lo mismo sin if ...
		
		if (ciudad < ciudades.length - 1)
			ciudad++;
		else
			ciudad = 0;
	}
	
	public Pasajeros getPasajero(int pos) {
		Pasajeros p = null;
	
		try {
			p = pasajero[pos];
		}
		catch (ArrayIndexOutOfBoundsException e) {
		//	System.out.println("[-] ERROR, posicion index incorrecta; pasajero[" + pos + "]");
		}
		
		return p;
	}
	
	public String getCiudad(int pos) {
		String ciudad = null;
		
		try {
			ciudad = this.ciudades[pos];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		return ciudad;
	}
	
	// retornar la ciudad por donde va el autobus
	public String getCiudad() {
		return ciudades[ciudad];
	}
}