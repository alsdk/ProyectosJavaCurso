package tipoParametroRestringido;

/**
 * Esta versión introduce un parámetro de tipo dependiente.
 */
public class Box<T> {

    private T t;          

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // limitamos la variable de tipo a Number
    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.add(new Integer(10));
        integerBox.inspect(integerBox.get());
        
        //integerBox.inspect("some text"); // error: esto es todavía String! 
    }
}