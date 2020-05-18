import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Options extends JPanel{
	int fenetreW = 1440;
	int fenetreH = 850;
	int d = 0;
 
	public Options(JFrame pFrame) {
		pFrame.setSize(fenetreW, fenetreH);
 
		addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
	          } 
	          public void mouseReleased(MouseEvent me) { 
	        	  int xm = me.getX();
	        	  int ym = me.getY();
 
	        	  if (xm >= ((fenetreW/2)-60) && xm <= ((fenetreW/2)+60) && ym >= (fenetreH/2-45) && ym <= (fenetreH/2)){
	        	  }
	        	  if (xm >= (fenetreW/2-31) && xm <= (fenetreW/2+31) && ym >= fenetreH/4+103 && ym <= fenetreH/4+120){
	        		  System.out.println("Menu");
	        		  d = 1;
	        	  }
	          }
		});
 
	}
 
	public void paint(Graphics g) {	
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, fenetreW, fenetreH);					//fond fenetre
		g.setColor(Color.BLUE);
		g.fillRect((fenetreW/5)-1, (fenetreH/4)-19, 117, 21);
		g.fillRect((fenetreW/5), (fenetreH/4)+60-20, 174, 26);
		g.fillRect((fenetreW/2-31), (fenetreH/4)+120-18, 66, 19);
		g.setColor(Color.black);
	    g.setFont(new Font("TimesRoman", Font.BOLD, 50));
	    g.drawString("Casse-Brique", (fenetreW/2)-141, 150);	//taille : 282px*45px
	    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
	    g.drawString("Résolution", (fenetreW/5), fenetreH/4);		//taille : 61px*17px
	    g.drawString("Couleur de fond", (fenetreW/5), fenetreH/4+60);//taille : 83px*22px
	    g.drawString("Menu", fenetreW/2-31, fenetreH/4+120);			//taille : 62px*17px
	    g.drawRect(0, 0, fenetreW-17, fenetreH-40);				//contour fenetre
	}	
 
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Options");
		Options options = new Options(frame);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(options);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true){
			options.repaint();
			Thread.sleep(10);
		}
 
	}
}