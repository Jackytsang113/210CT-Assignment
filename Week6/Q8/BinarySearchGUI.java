
/**
 * Write a description of class BinarySearch here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;   
public class BinarySearchGUI extends JFrame implements ActionListener{
    private JTextField jtfArray = new JTextField(20);
    private JTextField jtfNumber = new JTextField(5);
    private JTextField jtfResult = new JTextField(5);
    private JButton jbCompute = new JButton("OK");
    private JTextPane textPane = textPane = new JTextPane();
    private int numArray[] = { 2, 6, 10, 15, 23, 32, 42, 55, 61};
    public static void main(String[] args){
        BinarySearchGUI frame = new BinarySearchGUI();
        frame.pack();
        frame.setTitle("Binary Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public BinarySearchGUI(){
        // Panel gui to hold labels and text fields
        jtfArray.setEditable(false);
        jtfResult.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(new JLabel("Array:"));
        panel.add(jtfArray);
        panel.add(new JLabel("Search Number:"));
        panel.add(jtfNumber);
        panel.add(new JLabel("Number index:"));
        panel.add(jtfResult);

        String printArr = "[ ";
        for(int n: numArray){
            printArr += n + " ";
        }
        printArr += " ]";
        jtfArray.setText(printArr);

        this.setMinimumSize(new Dimension(50, 150));
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
                int arrSize = numArray.length;
                int high = arrSize - 1 ; 
                int low, mid;
                low = mid = 0; 
                int number = Integer.parseInt(jtfNumber.getText());
                while(low <= high){
                    mid = (high + low) / 2;
                    if(numArray[mid] == number){
                        break;
                    }else if(numArray[mid] > number)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

                if(high < low)
                    jtfResult.setText("Number is not found");
                else
                    jtfResult.setText(Integer.toString(mid));
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
