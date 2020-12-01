/**
 * Write a description of class Q1 here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;   
import javax.swing.table.DefaultTableModel;
public class BullAndCowGUI extends JFrame implements ActionListener{
    private JTextField jtfSecret = new JTextField(10);
    //private JTextField jtfGuesse = new JTextField(10);
    private JTextField jtfResult = new JTextField(20);
    private JButton jbCompute = new JButton("OK");
    private JTextPane textPane = textPane = new JTextPane();
    private String secNum,gueNum, header;
    private boolean reset = false;
    private int bulls, cows, round, skip;
    private boolean incorrect;
    public static void main(String[] args){
        BullAndCowGUI frame = new BullAndCowGUI();
        frame.pack();
        frame.setTitle("Bulls and Cows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public BullAndCowGUI(){
        header = "************ Bulls and Cows Game ************\nRound\tGuess\tBull\tCows\n";
        //jtfGuesse.setEditable(false);
        // Panel gui to hold labels and text fields
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(2, 3));
        panel.add(new JLabel("Secret Number"));
        panel.add(jtfSecret);
        //panel.add(new JLabel("Guesse Number"));
        //panel.add(jtfGuesse);
        panel.add(jbCompute);

        textPane.setEditable(false);
        JScrollPane jscrollpane = new JScrollPane(textPane);
        textPane.setText(header);

        this.setMinimumSize(new Dimension(500, 400));
        this.setResizable(false);
        // Add gui to the frame
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.NORTH);
        this.getContentPane().add(jscrollpane, BorderLayout.CENTER);
        // Register listener
        jbCompute.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == jbCompute) {
            try{
                if(jtfSecret.getText().equals("")){ 
                    JOptionPane.showMessageDialog(null, "Type the Secret number");
                }else{
                    if(reset){                                                             // reset the game
                        reset = false;
                        textPane.setText(header);
                    }
                    round = bulls = 0;
                    Integer.parseInt(jtfSecret.getText());                             // if it is not a number, a warning is trigger.
                    jtfSecret.setEditable(false);
                    secNum = jtfSecret.getText();
                    System.out.println("Secret Number: " + secNum);
                    jtfSecret.setText("Number length: " + secNum.length());            // Hide the secret number
                    String isCorr[] = new String[secNum.length()];
                    for(int i=0; i < secNum.length(); i++){
                        isCorr[i] += "false";
                    }
                    while(secNum.length() != bulls){ 
                        runGame(randomNumber(secNum.length()), isCorr);
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "!Error Please enter the same length as the secret number");

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input Number Format Error!");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input Error!");
            }
        }
    }

    public void runGame(String num,String isCorr[]){
        gueNum = solver(num, isCorr);
        String[] storeSecert = secNum.split("");                           // store the Secert number
        // check that the guessed number is more than the length of the secret number
        if(gueNum.length() > secNum.length()){
            JOptionPane.showMessageDialog(null, "!Error Please enter the same length as the secret number");
        }else{
            String[] storeGuesse = gueNum.split("");                      //store the guesse number to array
            bulls = cows = skip = 0;
            boolean incorrect = false;
            for(int i=0; i < secNum.length(); i++){
                for(int j=0 + skip; j < secNum.length(); j++){
                    if(storeSecert[i].equals(storeGuesse[j])){           //check if the number exists
                        cows++;
                        skip++;                                          // [i] has the same number as [j], next time to skip this position [j]
                        if(incorrect)
                            skip--;
                        break;
                    }else{
                        incorrect = true;
                    }
                }
                if(storeSecert[i].equals(storeGuesse[i])){              // check if the number position is correct
                    bulls++;
                    isCorr[i] = "true";                                 // right the number
                    if(cows > 0){
                        cows--;
                    }
                }
            }
            textPane.setText(textPane.getText() + ++round + "\t" + gueNum + "\t" + bulls + "\t" + cows + "\n");
            isEndGame(bulls == gueNum.length());                        // guess all the numbers and end the game
        }
    }

    public void isEndGame(boolean isEnd){
        if(isEnd){
            textPane.setText(textPane.getText() + "**************** You Win Game ****************\nSecret: " + secNum +", You guessed it " + round +" rounds.");
            jtfSecret.setEditable(true);
            jtfSecret.setText("");
            reset =  true;
        }
    }

    public String randomNumber(int v){
        int min = 0;
        int max = 9;
        String result = "";
        for(int i=0; i < v; i++){
            result += (int)(Math.random() * (max - min + 1) + min);
        }
        return result;
    }

    public String solver(String num, String isCorr[]){
        String[] storeNum = secNum.split("");
        String result = "";
        for(int i=0; i < num.length();i++){
            if(!isCorr[i].equals("true"))               // if the number is incorrect, other numbers will be used
                result += randomNumber(1);
            else
                result += storeNum[i];                  // If the number is correct, it will continue to be used 
        }
        return result;
    }
}
