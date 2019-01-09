package basics.of.applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.Timer;

/**
 *
 * @author Naman Deept
 */
public class BasicsOfApplet extends JApplet implements ActionListener{
    private Timer timer;
    private game Game;
    
   @Override
   public void init(){
       System.out.println("init");
       timer = new Timer(20,this);
       setSize(800,600);
       setLayout(new BorderLayout());
       add(Game,BorderLayout.CENTER);
       
   }
    @Override
   public void start(){
       System.out.println("start");
       timer.start();
   }
    @Override
   public void destroy(){
       System.out.println("destroy");
   }
    @Override
   public void stop(){
       timer.stop();
       System.out.println("stop");
   }   

    @Override
    public void actionPerformed(ActionEvent e) {
      // System.out.println("Timer stsrted");
      // game.update();
      Game.update();
    }
}
