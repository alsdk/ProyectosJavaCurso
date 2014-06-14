package hilos;

import javax.swing.JPanel;

import paneles.Marciano;

public class ProcesoMarciano extends Thread{
	
	private static int numero;
	private int codigo;
	private Marciano enemigo;
	private boolean parar=false;
	private int x,y;
	private JPanel tablero;
	public ProcesoMarciano(JPanel pTablero)
	{
		enemigo=new Marciano(pTablero);
		numero++;
		x=enemigo.getLocation().x;
		y=enemigo.getLocation().y;
		tablero=pTablero;
		codigo=numero;
		pTablero.add(enemigo);
	}
	public void run()
	{
		while(!parar && x<tablero.getHeight())
		{
			try {
				y+=5;
				enemigo.setLocation(x, y);
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		eliminar();
	}
	public void parada()
	{
		parar=true;
		
		enemigo.setLocation(-20, -20);
	}
	public void eliminar()
	{
		synchronized (ProcesoLanzar.tropas) {
			for(int i=0;i<ProcesoLanzar.tropas.size();i++)
			{
				if (ProcesoLanzar.tropas.get(i).getCodigo()==codigo)
				{
					ProcesoLanzar.tropas.remove(i);
				}
			}	
		}
	}
	public int getCodigo()
	{
		return codigo;
	}
	public int getX()
	{ 
		return x;
	}
	public int getY()
	{
		return y;
	}

}
