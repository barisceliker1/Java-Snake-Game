package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class yem extends JLabel{
	public int mgenislik=20;
	
	yem(){
		 
		  setPosition(20, 20);
	  }
	  @Override
	  public void paint(Graphics g){
		    Graphics2D g2=(Graphics2D) g;
			Ellipse2D ellipse=new Ellipse2D.Double(1, 1, mgenislik-1, mgenislik-1);
			g2.setColor(Color.red);
			g2.setStroke(new BasicStroke(2));
			g2.draw(ellipse);
			g2.fill(ellipse);
			
			
	  }

	  public void setPosition(int PosX,int PosY){
		  setBounds(PosX,PosY,mgenislik,mgenislik);
		  
	  }
}	  

	  
