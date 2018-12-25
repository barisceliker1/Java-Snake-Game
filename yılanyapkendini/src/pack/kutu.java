package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class kutu extends JLabel{
	public int mgenislik=20;
	public int myon=yön.sag;
	
  kutu(){
	  setBounds(100, 100, mgenislik, mgenislik);
	  
  }
  @Override
  public void paint(Graphics g){
	    Graphics2D g2=(Graphics2D) g;
		Rectangle2D rect=new Rectangle2D.Double(1, 1, getWidth()-2, getHeight()-2);
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(2));
		
		g2.draw(rect);
		g2.setColor(Color.red);
		g2.fill(rect);
		
		
  }
  public void solagit(){
    int posx = getX();
	int posy =getY();
	posx-=mgenislik;
	setBounds(posx, posy, mgenislik, mgenislik);
  }
  public void sagagit(){
	    int posx = getX();
		int posy =getY();
		posx+=mgenislik;
		setBounds(posx, posy, mgenislik, mgenislik);
  }
  public void yukarýgit(){
	    int posx = getX();
		int posy =getY();
		posy-=mgenislik;
		setBounds(posx, posy, mgenislik, mgenislik);
  }
  public void asagit(){
	    int posx = getX();
		int posy =getY();
		posy+=mgenislik;
		setBounds(posx, posy, mgenislik, mgenislik);
  }
  public kutu kutuolustur(){
	  kutu K = new kutu ();
	  
	  int X = getX();
	  int y = getY();
	  K.setBounds(X, y, mgenislik, mgenislik);
	  
	  K.myon=-myon;
	  K.hareket();
	  K.myon=myon;
	  
	  return K;
	  
	
	   
	  
  }
  public void hareket(){
	  if(myon==yön.sag)
		  sagagit();
      else if(myon==yön.sol)
			  solagit();
      else if(myon==yön.asagi)
    	      asagit();
      else 
    	      yukarýgit();
	  
			 
	  
  }
  
  
}
