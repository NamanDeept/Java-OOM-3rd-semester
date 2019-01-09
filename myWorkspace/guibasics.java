import javax.swing.*;

class guibasics{
    public static void main(String []args){
        String fn = JOptionPane.showInputDialog("Enter the first number");
        String sn = JOptionPane.showInputDialog("Enter the Second number");
        
        int num1 = Integer.parseInt(fn);
        int num2 = Integer.parseInt(sn);
        int sum = num1 + num2;
        
        JOptionPane.showMessageDialog(null,"The answer is"+sum,"Title",JOptionPane.PLAIN_MESSAGE);
    }
}
        