package hilos;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProcesoMisil extends Thread{

	private JButton misil;
	private int x,y;
	private boolean parar=false;
	
	public ProcesoMisil(JButton btMisil,JPanel pTablero)
	{
		misil=new JButton();
		misil.setBackground(btMisil.getBackground());
		x=btMisil.getLocation().x;
		y=btMisil.getLocation().y;
		misil.setBounds(x, y, 10, 10);
		pTablero.add(misil);
	}
	public void run()
	{
		while (!parar && y>-11)
		{
			try {
				y-=5;
				misil.setLocation(x, y);
				chocar();
				sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void parada()
	{
		parar=true;
	}
	public void chocar()
	{
		
			int tam=ProcesoLanzar.tropas.size();
			for (int i=0;i<tam;i++)
			{
				ProcesoMarciano aux=ProcesoLanzar.tropas.get(i);
				if ((y<aux.getY()+25 && y>aux.getY()) && (x>aux.getX() && x<aux.getX()+25))
				{
					aux.parada();
					break;
				}
				else if ((y<aux.getY()+25 && y>aux.getY()) && (x+10>aux.getX() && x+10<aux.getX()+25))
				{
					aux.parada();
					break;
				}
				
			}
		
	}
}
