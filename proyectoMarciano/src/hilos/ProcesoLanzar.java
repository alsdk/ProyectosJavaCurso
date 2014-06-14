package hilos;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ProcesoLanzar extends Thread{
	public static ArrayList<ProcesoMarciano> tropas;
	private JPanel tablero;
	private boolean parar=false;
	
	public ProcesoLanzar(JPanel pTablero)
	{
		tropas=new ArrayList<ProcesoMarciano>();
		tablero=pTablero;
	}
	
	public void run()
	{
		
		while(!parar)
		{
			synchronized (tropas) {
					
				ProcesoMarciano pm=new ProcesoMarciano(tablero);
				tropas.add(pm);
			    pm.start();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public void parada()
	{
		parar=true;
	}
}
