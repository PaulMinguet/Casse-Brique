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
 
 
public class Menu extends JPanel implements KeyListener{
	int fenetreW = 1440;
	int fenetreH = 850;
	int gr = 100;
	int gg = 100;
	int gb = 100;
	int touche = KeyEvent.VK_UNDEFINED;
	int etat = 0;
	Game game = null;
 
	public int getEtat() {
		return etat;
	}
 
	public void setEtat(int pEtat) {
		etat = pEtat;
	}
 
	public void setGame (Game pGame) {
		game = pGame;
	}
 
	public Menu(JFrame pFrame) {
		pFrame.setSize(fenetreW, fenetreH);
 
		addKeyListener(this);
 
		addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
	        	  int xm = me.getX();
	        	  int ym = me.getY();
	        	  if (xm >= ((fenetreW/2)-60) && xm <= ((fenetreW/2)+60) && ym >= (fenetreH/2-34) && ym <= (fenetreH/2) && gr<125 && gg<125 && gb<125){
	        		  gr = gr+25;
	        		  gg = gg+25;
	        		  gb = gb+25;
	        	  }
	          } 
	          public void mouseReleased(MouseEvent me) { 
	        	  int xm = me.getX();
	        	  int ym = me.getY();
 
	        	  if (xm >= ((fenetreW/2)-60) && xm <= ((fenetreW/2)+60) && ym >= (fenetreH/2-34) && ym <= (fenetreH/2)){
 
		            System.out.println(me.getX() + ", " + me.getY());
		            etat = 1;
	        	  }
 
	        	  if (xm >= ((fenetreW/2)-83) && xm <= ((fenetreW/2)+83) && ym >= ((fenetreH/2)+25) && ym <= ((fenetreH/2)+72)){
	        		  System.out.println("options");
	        		  JFrame frame = new JFrame("Options");
	        		  Options options = new Options(frame);
	        		  //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        		  frame.add(options);
	        		  frame.setLocationRelativeTo(null);
	        		  frame.setVisible(true);
	        		  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	  }
	          } 
		}); 
 
 
 
		setFocusable(true);
	}
 
	private void Bouton_Action (KeyEvent e) {
 
	}
 
	public void toucheP() {
		if (touche == KeyEvent.VK_SPACE);
	}
 
	public void boutons() {					
 
	}
 
	Color grisclair = new Color(gr,gg,gb);
 
	public void paint(Graphics g) {	
		grisclair = new Color(gr,gg,gb);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, fenetreW, fenetreH);					//fond fenetre
		g.setColor(grisclair);
		g.fillRect((fenetreW/2)-61, (fenetreH/2)-34, 124, 36);
		g.fillRect((fenetreW/2)-83, (fenetreH/2)+25, 169, 47);
	    g.setColor(Color.black);
	    g.setFont(new Font("TimesRoman", Font.BOLD, 50));
	    g.drawString("Casse-Brique", (fenetreW/2)-141, 150);	//taille : 282px*45px
	    g.drawString("Jouer", (fenetreW/2)-60, fenetreH/2);		//taille : 120px*34px
	    g.drawString("Options", (fenetreW/2)-83, fenetreH/2+60);//taille : 166px*45px
	    g.drawRect(0, 0, fenetreW-17, fenetreH-40);				//contour fenetre
	}	
 
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Jeu");
		Menu menug = new Menu(frame);
		Game jeu = new Game(frame);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	//plein écran
		frame.add(menug);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int etat = 0;
 
		while(menug.getEtat()!=-1){
 
 
			if (menug.getEtat()==1 && etat == 0) {
				System.out.println("addjeu");
				//frame.remove(menug);
				menug.setGame (jeu);
 
				frame.add(jeu);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				etat = 1;
			}
 
			if (etat == 1) {
				//System.out.println("  move Jeux");
				jeu.demarrage();
				jeu.balle_move();
				jeu.trait_move();
				jeu.trait2_move();
				jeu.repaint();
			}
			else
				menug.repaint();
 
			if (jeu.gameOver>0) {
				Thread.sleep(3000);
				frame.add(menug);
				jeu.setGameOver(0);
				menug.setEtat (0);
				etat = 0;
				frame.remove(jeu);
			}
			Thread.sleep(10);
		}
 
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		game.keyPressed(e);
 
	}
 
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		game.keyReleased(e);
	}
 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
 
	}
 
 
}