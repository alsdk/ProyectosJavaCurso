package procesos;

import javax.swing.JButton;

import paneles.PanelPelota;

public class HiloPelota extends Thread {
	private boolean parar;
	private PanelPelota pPelota;
	private int dir;
	private int anchoTablero;
	private JButton barra;
	
	public HiloPelota(PanelPelota p, int anchoTablero, JButton vBarra) {
		parar = false;
		pPelota = p;
		dir = 1;
		this.anchoTablero = anchoTablero;
		barra=vBarra;
	}
	
	@Override
	public void run() {
		while (!parar) {
			try {
				mover();
				rebotar();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void setParar(boolean par) {
		parar = par;
	}
	
	private void mover() {
		int x, y;
		
		x = pPelota.getLocation().x;
		y = pPelota.getLocation().y;
		if (dir == 1) {
			x += 5;
		}
		else if (dir == 0){
			x -= 5;
		}
		
		pPelota.setLocation(x, y);
	}
	
	private void rebotar() {
		int x = pPelota.getLocation().x;
		int y = pPelota.getLocation().y;
		                 
		if ( x <= 0 )
			dir = 1;
		else if ( x+pPelota.getWidth() >= anchoTablero ){
			parar = true;
		}
		else if (x + pPelota.getWidth() >= barra.getLocation().x 
				&& y >= barra.getLocation().y
				&& y <= barra.getLocation().y + barra.getHeight()) {
			dir = 0;
		}
		else if (x + pPelota.getWidth() >= barra.getLocation().x 
				&& y+pPelota.getHeight() >= barra.getLocation().y
				&& y+pPelota.getHeight() <= barra.getLocation().y + barra.getHeight()) {
			dir = 0;
		}
	}
}	
