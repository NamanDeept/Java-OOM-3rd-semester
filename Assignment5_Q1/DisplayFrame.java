import javax.swing.*;

public class DisplayFrame extends screenGUI{
    public static void main(String []args){
      createFrame frame = new createFrame();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(GetScreenWidth(),GetScreenHeight());
      frame.setVisible(true);
    }
}
 