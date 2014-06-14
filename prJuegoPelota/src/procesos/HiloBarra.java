package procesos;

import javax.swing.JButton;

public class HiloBarra implements Runnable {

	private JButton btBarra;
	private int dir;	// direccion recorrido de la barra, izq o derecha
	private boolean parar;
	private int altoTablero;
	
	public HiloBarra(JButton vBarra, int alto) {
		btBarra = vBarra;
		altoTablero = alto;
		dir = 1;
		parar = false;
	}
	
	@Override
	public void run() {
		while(!parar) {
			try {
				mover();
				rebote();
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * @params: dir es 1 (hacia arriba) o 2 (hacia abajo)
	 */
	public void setDireccion(int dir) {
		this.dir = dir;
	}
	
	private void mover() {
		int x = btBarra.getLocation().x;
		int y = btBarra.getLocation().y;
		
		if ( dir == 1 ) {
			y += 5;		// desplazar arriba
		}
		else if ( dir == 0 ) {
			y -= 5;		// desplazar abajo
		}
		btBarra.setLocation(x, y);
	}
	
	private void rebote() {
		int y = btBarra.getLocation().y;
		
		if (y<=0) {
			dir = 1;		// rebotar arriba
		}
		else if ( y + btBarra.getHeight() >= altoTablero ) {
			dir = 0;		// rebotar abajo
		}
	}

	public void setParar(boolean b) {
		parar = b;
	}

}
