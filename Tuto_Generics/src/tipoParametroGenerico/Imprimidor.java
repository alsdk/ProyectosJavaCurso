/*
 * Como ejemplo vamos a crear una pequeña clase que almacene un objeto, 
 * con su getter y setter, y que permita imprimir la cadena que lo representa, 
 * o bien imprimir la cadena al revés.
 */


package tipoParametroGenerico;

// por convencion se usa una letra mayuscula para designar el tipo generico
public class Imprimidor<T> {
	private T objeto;

	public Imprimidor(T objeto) {
		this.objeto = objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public T getObjeto() {
		return objeto;
	}

	public void imprimir() {
		System.out.println(objeto.toString());
	}

	public void imprimir_reves() {
		StringBuffer sb = new StringBuffer(objeto.toString());
		System.out.println(sb.reverse());
	}
}