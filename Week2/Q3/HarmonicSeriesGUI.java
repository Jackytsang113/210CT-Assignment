
/**
 * Write a description of class HarmonicSeries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HarmonicSeriesGUI extends JFrame implements ActionListener{
    private JTextField jtfNumber = new JTextField(10);
    private JTextField jtfResult = new JTextField(10);
    private JButton jbCompute = new JButton("CALCULATE");
    private JButton jbReset = new JButton("RESET");
    private int number;
    private double result;
    public static void main(String[] args){
        HarmonicSeriesGUI frame = new HarmonicSeriesGUI();
        frame.pack();
        frame.setTitle("Harmonic Series");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public HarmonicSeriesGUI(){
        // Panel gui to hold labels and text fields
        //jtfResult.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(new JLabel("Number"));
        panel.add(jtfNumber);
        panel.add(new JLabel("Result"));
        panel.add(jtfResult);
        panel.add(jbReset);
        panel.add(jbCompute);

        // Add gui to the frame
        this.setMinimumSize(new Dimension(200, 50));
        this.setResizable(false);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.CENTER);

        // Register listener
        jbCompute.addActionListener(this);
        jbReset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == jbReset) {
            jtfNumber.setText("");
            jtfResult.setText("");
        }
        if (event.getSource() == jbCompute) {
            try{
                number = Integer.parseInt(jtfNumber.getText());
                result = 0;
                for(int i=1; i <= number; i++){
                    result += (double) 1 / i;
                }
                jtfResult.setText(Double.toString(result));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input Number Format Error!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input Error!");
            }
        }
    }
}
