package disenyo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ficheros.FicheroDibujo;
import figuras.Linea;
import paneles.PanelOpciones;

public class VentanaDibujo extends JFrame implements MouseListener, MouseMotionListener {
	// panel para dibujar dentro
	private JPanel pPizarra;
	private PanelOpciones pOpciones;
	private int x1, y1;
	private int click;
	private ArrayList<Linea> lineas;
	
	public VentanaDibujo () {
		setTitle("Ventana Dibujos");
		setBounds(150, 150, 500, 400);
		pPizarra = new JPanel();
		pPizarra.setBackground(Color.WHITE);
		pPizarra.addMouseListener(this);	// en esta clase esta el escuchador
		pPizarra.addMouseMotionListener(this);
		add(pPizarra, BorderLayout.CENTER);
	
		// añadir PanelOpciones a la ventana
		pOpciones = new PanelOpciones();
		add(pOpciones, BorderLayout.EAST);
		
		// grabar
		lineas = new ArrayList<Linea>();
	}

	// evento al hacer click (pulsar y levantar rapido)
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// foco activo
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// foco desactivado
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// boton pulsado
	@Override
	public void mousePressed(MouseEvent e) {
		if (pOpciones.getOpciones().equals("click")) {		// se pinta linea cuando este activado el radiobutton click 
			if ( click == 0 ) {
				// guardamos la coordenada donde hemos pinchado
				x1 = e.getX();
				y1 = e.getY();
				click = 1;
			} 
			else {
				// segundo click, pintar la linea
				pintar(e.getX(), e.getY());
				click = 0;
			}
		}
		else {				// si no es click (es arrastre) capturamos el punto de comienzo 
							// del arrastre. Sin esto al arrastrar una segunda vez pintaria una linea
							// recta entre el primer arrastre y el segundo
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	// boton presionado
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void pintar(int x2, int y2) {
		// pintar linea desde la coordenada x1 y1 hasta x2 y2
		Graphics g = pPizarra.getGraphics();		// devuelve un obj de tipo grafico donde se encuentra el area grafica del panel
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
		
		// una vez pintada la linea la almacenamos en un objeto Linea (solo tiene coordenadas)
		// para mas tarde guardar() en FicheroDibujo
		Linea line = new Linea();
		line.setX1(x1);
		line.setY1(y1);
		line.setX2(x2);
		line.setY2(y2);
		lineas.add(line);
	}
	
	// pintar() de leer
	public void pintarTodo() {
		FicheroDibujo fd = new FicheroDibujo();
		lineas = fd.leer();
		Graphics g = pPizarra.getGraphics();
		g.setColor(Color.BLUE);
		
		//recorrer para pintar
		for (Linea line : lineas) {
			g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
		}

	}

	// eventos de MouseMotionListener
	// arrastrar con el raton
	@Override
	public void mouseDragged(MouseEvent e) {
		if ( pOpciones.getOpciones().equals("arrastrar") ) {
			int x2 = e.getX();
			int y2 = e.getY();
			pintar(x2, y2);
			x1 = x2;
			y1 = y2;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public ArrayList<Linea> getLineas() {
		return lineas;
	}
	
}
