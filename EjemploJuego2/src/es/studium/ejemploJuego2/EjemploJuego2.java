package es.studium.ejemploJuego2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.ImageIcon;

public class EjemploJuego2 extends Frame implements WindowListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	// Las coordenadas del cuadrado
	int posX, posY;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas;
	
	int alto=20;
	int ancho=20;
	
	ImageIcon imagenSusto=new ImageIcon("susto.jpg");
	
	private int puntuacion=0;
	Random rnd = new Random();
	public EjemploJuego2(){
		vidas = 3;
		// Obtener los valores iniciales del cuadrado
		obtenerPosicion();
		setTitle("Moviendo...");
		addWindowListener(this);
		addMouseListener(this);
		setSize(220,240);
		setVisible(true);
		setLocationRelativeTo(null);
		setLocation(480, 200);
		}
	public void obtenerPosicion(){
		// Obtenemos los valores teniendo en cuenta los límites del escenario
		posX=rnd.nextInt(186)+8;
		posY=rnd.nextInt(160)+52;
		}
	public void paint(Graphics g){
		g.drawRect(posX, posY, ancho, alto);
		
//		g.setColor(Color.gray);
//		g.fillRect(0, 0, 220, 220);
		if(alto==1) {			
		imagenSusto.paintIcon(this, g, 10, 20);
		setSize(390,280);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial",Font.PLAIN,12));
		g.drawString("Puntuación: "+puntuacion,120,50);
		g.drawString("Vidas: "+vidas,50,50);
		}
	public void windowActivated(WindowEvent we) {
		
	}
	public void windowClosed(WindowEvent we) {
		
	}
	public void windowClosing(WindowEvent we){
		System.exit(0);
		
	}
	public void windowDeactivated(WindowEvent we) {
		
	}
	public void windowDeiconified(WindowEvent we) {
		
	}public void windowIconified(WindowEvent we) {
		
	}public void windowOpened(WindowEvent we) {
		
	}
	public static void main(String[] args) {
		new EjemploJuego2();
	}
	public void mouseClicked(MouseEvent me){
		// Obtenemos las coordenadas del lugar donde se ha pulsado con el ratón
		pulX = me.getX();
		pulY = me.getY();
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((posX<pulX)&&(pulX<posX+20)&&(posY<pulY)&&(pulY<posY+20)){
			System.out.println("Acertaste");
			puntuacion++;
			// Obtenemos una nueva posición del cuadrado
			obtenerPosicion();
			// Y lo dibujamos
			
			if(alto!=1 && ancho!=1) {
				alto--;
				ancho--;
			}
			
			repaint();
		}
		else{
			vidas--;
			if(vidas==0){
				vidas=0;
				System.out.println("Has acabado todas las vidas. ¡FIN!");
				// Deshabilitamos el MouseListener pues se ha acabado el juego
				this.removeMouseListener(this);
				repaint();
				}else{
					System.out.println("Has perdido una vida. Te quedan "+vidas+ " vidas.");
					repaint();
				}
			}
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
