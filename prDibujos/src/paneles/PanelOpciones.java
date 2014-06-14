package paneles;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// panel que tiene los radiobutton
public class PanelOpciones extends JPanel {
	private JRadioButton rbClick, rbArrastrar;
	
	public PanelOpciones() {
		setLayout(new GridLayout(2, 1));
		rbClick = new JRadioButton("Click");
		rbClick.setSelected(true);		// por defecto viene marcado click en vez de arrastrar
		rbArrastrar = new JRadioButton("Arrastrar");
		
		// creamos un grupo de radiobutons para que solo nos
		// deje seleccionar uno de ellos
		ButtonGroup grupoOpcion = new ButtonGroup();
		grupoOpcion.add(rbClick);
		grupoOpcion.add(rbArrastrar);
		
		add(rbClick);
		add(rbArrastrar);
	}
	
	// sin esta funcion funcionaran las dos formas de pintar con el raton:
	// mediante click o arrastre independientemente de lo que este seleccionado
	//
	public String getOpciones() {
		if (rbClick.isSelected())
			return "click";
		else
			return "arrastrar";
	}
}
