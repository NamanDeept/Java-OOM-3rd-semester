/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics.of.applet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Naman Deept
 */
public class game extends JComponent {
    private Ellipse2D.Double ball = new Ellipse2D.Double(100,100,20,20);
    private RoundRectangle2D.Double bat =  new RoundRectangle2D.Double(200,200,200,15,20,20);
    private  double speed = 10.0;
    private double batSpeed = 50.0;
    private  int xdirection =1;
    private  int ydirection =1;
    private BufferedImage bufferimg;
    private boolean intersectedChecked = true;
    
    public game(){
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                 bat.x = Math.abs(e.getX()-bat.getWidth()/2);
                 bat.y= Math.abs(e.getY()-bat.getHeight()/2);            
             }

            @Override
            public void mouseMoved(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         addMouseListener(new MouseAdapter(){
             @Override
             public void mouseClicked(MouseEvent e){
                 ball.x = e.getX();
                 ball.y = e.getY();
             }
        
    });
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                int key = e.getKeyCode();
                
                if(key== KeyEvent.VK_UP || key == KeyEvent.VK_W){
                    //  System.out.println ("up");
                    if(bat.y!=0)
                        bat.y -=batSpeed;
                    else bat.y =-bat.getHeight()/2;
                }
                
                if(key== KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
                    //  System.out.println("down");
                    if(bat.y!=getHeight())
                        bat.y +=batSpeed;
                    else bat.y=getHeight()-bat.getHeight()/2;
                }
                if(key== KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
                    //  System.out.println("left");
                    if(bat.x!=0)
                        bat.x -=batSpeed;
                    else bat.x=-bat.getWidth()/2;
                }
                if(key== KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
                    //  System.out.println("right");
                    if(bat.x!=getWidth())
                        bat.x +=batSpeed;
                    else bat.x=getWidth();
                }
                return false;
            }
        });
       Cursor hiddenC;
       hiddenC = getToolkit().createCustomCursor(new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB),new Point(1,1)," ");
       setCursor(hiddenC);
    }

   
    @Override
    protected void paintComponent(Graphics g) {
        if(bufferimg == null){ 
            bufferimg = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g_;
        g_ = (Graphics2D)bufferimg.getGraphics();
        g_.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g_.setColor(Color.white);
        g_.fillRect(0,0,getWidth(),getHeight());  
        g_.setColor(Color.BLACK);        
        g_.fill(ball);
        g_.setColor(Color.MAGENTA);
        g_.fill(bat);
        g.drawImage(bufferimg,0,0,null);
    }
     public void update(){
        //System.out.println(ball.x+" "+ball.y);
        ball.x+=xdirection*speed;
        ball.y+=ydirection*speed;
        if(ball.x<ball.getBounds().width){
            xdirection=1;
            ball.x=ball.getBounds().width;
        }
        else if(ball.x>getWidth()-ball.getBounds().width){
            xdirection=-1;
            ball.x= getWidth()-ball.getBounds().width;
        }
        else if(ball.y<ball.getBounds().height){
            ydirection =1;
            ball.y=ball.getBounds().height;
        }
        else if(ball.y>getHeight()-ball.getBounds().height)
        {
            ydirection =-1;
            ball.y=getHeight()-ball.getBounds().height;
        } 
        if(ball.intersects(bat.getBounds()))
         {
            if(intersectedChecked){
                ydirection = - ydirection;
                intersectedChecked = false;
            }
            else{
                intersectedChecked = true;
            }
        }
        repaint();    
    }     
}
