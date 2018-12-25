package pack;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class anapencere extends JFrame{
	private int mgenislik=700;
	private int myukseklik=700;
	
	private static anapencere mpencere =null;
	
     private anapencere(){
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setResizable(false);
    	 
    	 SetDimension(mgenislik, myukseklik);
    	 yýlan y = new yýlan();
    	 add(y);
    	 
     }
     public static anapencere PencereGetir(){
	
		if(mpencere==null)
			mpencere=new  anapencere();
		
			
		
		return mpencere;
		}
		
     
     public void SetDimension(int genislik,int yukseklik){
    	Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	int PosX=0;
    	int PosY=0;
    	if(mgenislik+100>Dim.width)
    		mgenislik=Dim.width-100;
    	if(myukseklik+100>Dim.height)
    		myukseklik=Dim.height-100;
    	PosX=(Dim.width-mgenislik)/2;
    	PosY=(Dim.height-myukseklik)/2;
    	setBounds(PosX, PosY, mgenislik, myukseklik);
    	setTitle("YILAN SERDAR");
    	
    	}
    	
    	
     
}
