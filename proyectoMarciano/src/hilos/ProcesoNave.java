package hilos;

import javax.swing.JButton;

public class ProcesoNave extends Thread {

	private int xNave,yNave, xMisil,yMisil ,dir,tope;
	private boolean parar;
	private JButton nave,misil;
	public ProcesoNave(JButton btNave,JButton btMisil,int ancho)
	{
		nave=btNave;
		misil=btMisil;
		tope=ancho;
		dir=1;
		yNave=btNave.getLocation().y;
		xNave=btNave.getLocation().x;
		yMisil=btMisil.getLocation().y;
		xMisil=btMisil.getLocation().x;
	}
	public void run()
	{
		while(!parar)
		{
			try {
				mover();
				rebotar();
				sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void mover()
	{
		if (dir==1)
		{
			xNave+=5;
			xMisil+=5;
		}
		else if (dir==0)
		{
			xNave-=5;
			xMisil-=5;
		}
		nave.setLocation(xNave, yNave);
		misil.setLocation(xMisil, yMisil);
	}
	public void rebotar()
	{
		if (xNave<=0)
		{
			dir=1;
		}
		else if (xNave>=tope)
		{
			dir=0;
		}
	}
	public void cambiarDir(int valor)
	{
		dir=valor;
	}
	public void parada()
	{
		parar=true;
	}
}
