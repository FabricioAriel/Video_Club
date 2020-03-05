package Vistas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	ImageIcon imagen;
	public PanelFondo(String direc_fondo) {
		super();
		imagen=new ImageIcon(getClass().getResource(direc_fondo));
	}
	protected void paintComponent (Graphics g) 
	{
		Dimension d=this.getSize();
		g.drawImage(imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}