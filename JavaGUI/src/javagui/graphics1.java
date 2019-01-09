/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Naman Deept
 */
public class graphics1 extends JComponent{
    private BufferedImage buffer;
    private int XCoordinate;
    private int YCoordinate;
    private int counter=0;
    private generatePoints gp;
    private Graphics2D g2;
    private int speed = 10;
    Ellipse2D.Double ball = new Ellipse2D.Double(100,100,15,15);
    
	public graphics1() {
         addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ball.x = e.getX();
				ball.y = e.getY();
                                System.out.println(ball.x+" "+ball.y);
			}
			
		});
            addComponentListener(new ComponentAdapter() {

                        @Override
			public void componentResized(ComponentEvent e) {
				buffer = null;
			}
			
		});
        }
    @Override
     protected void paintComponent(Graphics g){
        if(buffer==null){
        buffer = new BufferedImage(600,400,BufferedImage.TYPE_INT_RGB);
        }
        g2 = (Graphics2D)buffer.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,600,400);
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(100,100, 15, 15));
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(100,0, 15, 15));
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(0,100, 15, 15));
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(0,0, 15, 15));
        g2.setColor(Color.RED);
        g2.fill(ball);
        g.drawImage(buffer,0,0,null);
     }
     public void update(){
         ball.x-=10.0;
         ball.y+=10.0;
         repaint();
     }
     @Override
      public void update(Graphics g){
         paint(g);
      }
} 