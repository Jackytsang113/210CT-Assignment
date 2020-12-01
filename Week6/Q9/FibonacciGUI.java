
/**
 * Write a description of class Fibonacci here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
public class FibonacciGUI extends JFrame implements ActionListener{
    private JTextField jtfCount = new JTextField(5);
    private JTextField jtfResult = new JTextField(10);
    private JButton jbCompute = new JButton("OK");
    private JTextPane textPane = textPane = new JTextPane();

    public static void main(String[] args){
        FibonacciGUI frame = new FibonacciGUI();
        frame.pack();
        frame.setTitle("Fibonacci Series");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public FibonacciGUI(){
        // Panel gui to hold labels and text fields
        jtfResult.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("Count:"));
        panel.add(jtfCount);
        panel.add(new JLabel("Result:"));
        panel.add(jtfResult);

        this.setMinimumSize(new Dimension(300, 120));
        this.setResizable(false);
        // Add gui to the frame
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.CENTER);
        this.getContentPane().add(jbCompute,BorderLayout.SOUTH);
        // Register listener
        jbCompute.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == jbCompute) {
            try{
                int count = Integer.parseInt(jtfCount.getText());
                int num1 = 0;
                int num2 = 1;
                int num3;
                String result = num1 + " " + num2;
                for(int i=0; i < count - 2; i++){
                    num3 = num1 + num2;
                    num1 = num2;
                    num2 = num3;
                    result += " " + num3;
                }
                jtfResult.setText(result);
            }catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "!Error Please enter the same length as the secret number");

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input Number Format Error!");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input Error!");
            }
        }
    }
}
