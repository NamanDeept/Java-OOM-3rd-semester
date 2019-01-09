/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics.of.applet;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Naman Deept
 */
public class mainClass extends JFrame implements ActionListener{
      private Timer timer;
      private game Game;
     mainClass(){
         
         super("Animation");
         Game = new game();
         timer = new Timer(20, (ActionListener) this);
         setSize(800,600);
         setLayout(new BorderLayout());
         timer.start();
         add(Game,BorderLayout.CENTER);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
           Game.update();

    }
}
