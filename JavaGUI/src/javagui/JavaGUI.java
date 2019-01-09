/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;

import java.awt.BorderLayout;
import javax.swing.JApplet;

/**
 *
 * @author Naman Deept
 */
public class JavaGUI extends JApplet {

        private graphics1 graphics;
  
        @Override
	public void destroy() {
		System.out.println("destroy");
	}


        @Override
	public void init() {
		graphics = new graphics1();
		setSize(600, 500);
		setLayout(new BorderLayout());
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
		System.out.println("init");
	}


        @Override
	public void start() {
		System.out.println("start");
                
        }
        @Override
	public void stop() {
		System.out.println("stop");
	}
      
}