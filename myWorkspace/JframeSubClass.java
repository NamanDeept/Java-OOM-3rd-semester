import java.awt.*;
import javax.swing.*;

class JframeSubClass extends JFrame{
    private JLabel item;
    public JframeSubClass(){
        super("This is the message bar");
        setLayout(new FlowLayout());
        item = new JLabel("Hello World");
        item.setToolTipText("You hovered over this sentence");
        add(item);
    }
}
