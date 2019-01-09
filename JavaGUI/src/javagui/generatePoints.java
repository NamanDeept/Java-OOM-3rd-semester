/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;
/**
 *
 * @author Naman Deept
 */
public class generatePoints extends JComponent {
    /*
    This class will generate points
    */
    private final Ellipse2D.Double move =new Ellipse2D.Double(100,100,20,20);
    private ArrayList<Integer> xCoordinates;
    private ArrayList<Integer>yCoordinates;
 
    public generatePoints() {
     xCoordinates = new ArrayList<Integer>();
     yCoordinates = new ArrayList<Integer>();     
    }
    public int getXC(int index){
        return xCoordinates.get(index);
    }
    public int getYC(int index){
        return yCoordinates.get(index);
    }
    public void addXC(int pt){
        xCoordinates.add(pt);
    }
    public void addYC(int pt){
        yCoordinates.add(pt);
    }
    public int getXSize(){
        return xCoordinates.size();
    }
     public int getYSize(){
        return yCoordinates.size();
     }
}