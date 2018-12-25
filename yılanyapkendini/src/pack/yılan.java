package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;



public class yýlan extends JLabel {
	public kutu mhead = new kutu();
	public Timer mTimer=null;
	public ArrayList<kutu> Liste =new ArrayList<kutu>();
	public yem myem=new yem();
	public Random mrandom=null;
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2=(Graphics2D) g;
		Rectangle2D rect=new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(20));
		g2.draw(rect);
	}
    yýlan() {
    	
    
 	mrandom=new Random(System.currentTimeMillis());
 	addKeyListener(new klavyekontrol());
 	setFocusable(true);
 	mTimer =new Timer(100,new Timerkontrol() );
    mTimer.start();
 	
    kutu A =mhead.kutuolustur();
 	
 	
 	
    
 	Liste.add(mhead);
 	  for(int i=0;i<6;i++){
 	    	
 	    	kuyrukekle();
 	    	
 	    }
 	  add(mhead);
 	  
 	 add(myem);
 	  
		
}
    public void kuyrukekle(){
    	kutu K=Liste.get(Liste.size()-1).kutuolustur();
	    	Liste.add(K);
	    	add(K);
    }
    public void yemekle(){
    	int width =getWidth()-40-myem.mgenislik;
    	int height=getWidth()-40-myem.mgenislik;
    	int posX=20+Math.abs(mrandom.nextInt())%width;
    	int posY=20+Math.abs(mrandom.nextInt())%height;
    	posX=posX-posX%20;
    	posY=posY-posY%20;
    	
    	for(int i=0; i<Liste.size();i++){
    		if((posX==Liste.get(i).getX())&&(posY==Liste.get(i).getY()))
    				{
    			 yemekle();
    			return;
    				}
    	}
    	
    	
    	myem.setPosition(posX, posY);
    	
    	
    	
    }
    public void hepsihareket(){
    	for(int i=Liste.size()-1;i>0;i--){
    		kutu onceki=Liste.get(i-1);
    		kutu sonraki=Liste.get(i);
    		
    		
    		
    		Liste.get(i).hareket();
    		sonraki.myon=onceki.myon ;
    	}
    	mhead.hareket();
    	
    	
    }
    public boolean CarpismaVarmi(){
    	
    	int kalem=10;
    	int genislik=getWidth();
    	
    	int uzunluk=getHeight();
    	
    	if(mhead.getX()<=10)
    		return true;
    	if(mhead.getX()+mhead.mgenislik>=genislik-kalem)
    	    return true;
    	if(mhead.getY()<=10)
    		return true;
    	if(mhead.getY()+mhead.mgenislik>=uzunluk-kalem)
    	    return true;
    	for(int i=1;i<Liste.size();i++){
    		int x=Liste.get(i).getX();
    		int y=Liste.get(i).getY();
    		if((x==mhead.getX())&&(y==mhead.getY()))
    				return true;
    		
    	}
    	
    	
    	
    	if(myem.getX()==mhead.getX()&&(myem.getY()==mhead.getY()))
    	{
    		kuyrukekle();
    		yemekle();
    		
    	}
    	return false;
    	
    }
  
	class klavyekontrol implements KeyListener{

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
			{
				if(mhead.myon!=yön.sag)
				mhead.myon=yön.sol;
				
				
				
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
			   if(mhead.myon!=yön.sol)
				mhead.myon=yön.sag;
				
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP)
			{
				if(mhead.myon!=yön.asagi)
				mhead.myon=yön.yukarý;
				
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				if(mhead.myon!=yön.yukarý)
				mhead.myon=yön.asagi;
				
				}
			
		}
				
				


		public void keyReleased(KeyEvent arg0) {
		
			
		}




		public void keyTyped(KeyEvent arg0) {
			
			
		}

	
	}
	

    class Timerkontrol implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			
				
			hepsihareket();
			if(CarpismaVarmi())
				mTimer.stop();
			
		}
		}
	

		

		
			 
			
		}

		
    

