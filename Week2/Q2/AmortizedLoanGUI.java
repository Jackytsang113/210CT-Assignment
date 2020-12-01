/**
 * Write a description of class Amortized_Loan_Calculator here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;   
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
public class AmortizedLoanGUI extends JFrame implements ActionListener{
    private JTextField jtfAmount = new JTextField(10);
    private JTextField jtfYear = new JTextField(10);
    private JTextField jtfInterest = new JTextField(10);
    private JButton jbCompute = new JButton("CALCULATE");
    private JButton jbReset = new JButton("RESET");
    private DefaultTableModel tableModel = new DefaultTableModel();
    private DecimalFormat df = new DecimalFormat("#.##");
    private JTable table;
    private int month, monthly;
    private double amount, interest, piAmt, intExp,monPay;
    // https://www.fubonbank.com.hk/tc/calculator/mortgage-repayment-calculator.html
    public static void main(String[] args){
        AmortizedLoanGUI frame = new AmortizedLoanGUI();
        frame.pack();
        frame.setTitle("Amortized Loan Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public AmortizedLoanGUI(){
        // Panel gui to hold labels and text fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(new JLabel("Loan Amount"));
        panel.add(jtfAmount);
        panel.add(new JLabel("Loan term in Years"));
        panel.add(jtfYear);
        panel.add(new JLabel("interest rate"));
        panel.add(jtfInterest);
        panel.add(jbReset);
        panel.add(jbCompute);

        // Create Table
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Month");
        tableModel.addColumn("Monthly Amount");
        tableModel.addColumn("Interest Expense");
        tableModel.addColumn("Payable Amount");
        tableModel.addColumn("Balance Amount");

        this.setMinimumSize(new Dimension(600, 400));
        this.setResizable(false);
        // Add gui to the frame
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.NORTH);
        this.getContentPane().add(table,BorderLayout.SOUTH);
        JScrollPane jscrollpane = new JScrollPane(table);
        this.getContentPane().add(jscrollpane, BorderLayout.CENTER);
        // Register listener
        jbCompute.addActionListener(this);
        jbReset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == jbReset) {
            jtfAmount.setText("");
            jtfYear.setText("");
            jtfInterest.setText("");
            tableModel.setRowCount(0);                                              // clear all rows
        }
        if (event.getSource() == jbCompute) {
            try{
                if(tableModel.getRowCount() > 0)                                    // if table has rows
                    tableModel.setRowCount(0);                                      // clear all rows
                month = 0;
                amount = Double.parseDouble(jtfAmount.getText());
                monthly = Integer.parseInt(jtfYear.getText()) * 12;
                interest = Double.parseDouble(jtfInterest.getText())/100/12;
                
                // Count the principal amount payable
                monPay = amount * interest * Math.pow(1 + interest, monthly)/(Math.pow(1 + interest, monthly) - 1);
                for(int i=0; i < monthly; i++){
                    intExp = amount * interest; // Count the interest expense
                    piAmt = monPay - intExp; //  Count the principal amount payable
                    amount -=piAmt; // Count the outstanding balance amount
                    if(amount < 0)
                        amount = 0.0;
                    // add the table rows
                    tableModel.addRow(new Object[]{++month , df.format(monPay), df.format(intExp), df.format(piAmt), df.format(amount)});
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input Number Format Error!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input Error!");
            }
        }
    }
}
