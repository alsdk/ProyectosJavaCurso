package ClaseAnidadaEstatica;

// la clase contenedora tiene que ser public o privada al paquete
public class ClaseExterna {

	private int a=10;
	private static int b=5;
	
	private static class B {
		public B() {
			// creamos un objeto de la clase externa para poder acceder a los miembros no static
			ClaseExterna objetoExterno = new ClaseExterna();
			System.out.println(objetoExterno.a);
			System.out.println(objetoExterno.b);
			System.out.println(b);
		}
	}
	
	public static void main(String[] args) {
		ClaseExterna.B ab = new ClaseExterna.B();
	}

}
