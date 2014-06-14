
public class Taller {
	//variables de clase
	private String nombre;
	private double ingresos, precioh;
	private Coches coche;
	
	//constructor
	public Taller(String nombre) {
		this.nombre = nombre;
	}
	
	//funciones y metodos
	public void entrar(Coches co) {
		if (this.coche == null) {
			this.coche = co;
			System.out.println("El coche ha entrado en el taller satisfactoriamente");
		}
		else
			System.out.println("ERROR, solo puede haber un coche en el taller");
	}
	
	public void setPrecioH(double precio) {
		this.precioh = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioH() {
		return precioh;
	}
	
	public double getIngresos() {
		return ingresos;
	}
	
	public Coches getCoche() {
		return coche;
	}
	
	public double reparar() {
		double reparacion_precio = 0;
		
		try {
			reparacion_precio = this.getPrecioH() * coche.getHoras();
			
			//ingresos es el precio por hora del taller * horas de reparacion del coche
			ingresos += reparacion_precio;
			//sacamos el coche del taller poniendo el obj a nulo
			this.coche = null;
		}
		catch (NullPointerException ex) {
			System.out.println("No hay coche en el taller");
		}

		//devolver precio de la reparacion
		return reparacion_precio;
	}
}
