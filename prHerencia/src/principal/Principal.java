package principal;
import empresas.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Luis");
		//p1.setNombre("pepe");
		p1.setSalario(1000);
		
		System.out.println("Nombre: "+ p1.getNombre());
		System.out.println("Salario: " + p1.getSalario());
		System.out.println();
		// variables y metodos protected no salen en las clases que no son del paquete empresas:
		//p1.salario;
	
		Operadores op1 = new Operadores(10);
		op1.setNombre("maria");
		op1.setSalario(1000);
		op1.setLlamadas(60);
		System.out.println("Nombre: " + op1.getNombre());
		System.out.println("Llamadas: " + op1.getLlamadas());
		System.out.println("Salario: " + op1.calcularSalario());
		System.out.println();
		
		Vendedor vend1 = new Vendedor("Antonio", 50);
		vend1.setNombre("manuela");
		vend1.setSalario(900);
		vend1.setNumeroVentas(10);
		System.out.println("Nombre: " + vend1.getNombre());
		System.out.println("Llamadas: " + vend1.getNumeroVentas());
		System.out.println("Salario: " + vend1.calcularSalario());
		System.out.println();
		
		// POLIMORFISMO
		Persona p2 = new Vendedor("ana", 50);	//esto se puede hacer pq un vendedor es una persona, p1.* accede a los metodos de persona
		System.out.println("Nombre: " +p2.getNombre());
		System.out.println("Salario: " + p2.calcularSalario()); 			// depende de la instanciacion ejecutamos el calcularSalario de vendedor
																			// estamos sobreescribiendo calcularSalario de persona con el de Vendedor
																			// los metodos visibles del padre que coincidan con los del hijo, son los que
																			// se veran
		
		p2 = new Operadores(40);
		System.out.println("Salario: " + p1.calcularSalario()); 			// dependiendo del new las llamadas son a operadores
	}																		

}
