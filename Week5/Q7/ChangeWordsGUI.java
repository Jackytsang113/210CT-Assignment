/**
 * Write a description of class ChangeWords here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;   
import javax.swing.table.DefaultTableModel;
public class ChangeWordsGUI extends JFrame implements ActionListener{
    //static Scanner input = new Scanner(System.in);
    private WordsStream dll = new WordsStream();
    private JTextField jtfWords = new JTextField(50);
    private JButton jbCompute = new JButton("OK");
    private JTextPane textPane = textPane = new JTextPane();
    private String words;
    public static void main(String[] args){
        ChangeWordsGUI frame = new ChangeWordsGUI();
        frame.pack();
        frame.setTitle("Words");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ChangeWordsGUI(){
        // Panel gui to hold labels and text fields
        JPanel panel = new JPanel();
        panel.add(new JLabel("Type the words:"));
        panel.add(jtfWords);
        panel.add(jbCompute);
        textPane.setEditable(false);
        Font font = new Font("Calibri", Font.BOLD, 20);
        textPane.setFont(font);
        JScrollPane jscrollpane = new JScrollPane(textPane);

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
                String[] storeWords = jtfWords.getText().split(" ");
                for(int i = 0; i < storeWords.length; i++){
                    dll.addToTail(storeWords[i]);
                }
                textPane.setText("Before: " + dll);
                dll.activeWord();
                textPane.setText(textPane.getText() + "\n\nAfter:    " + dll);
                dll.removeAllNode();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input Error!");
            }
        }
    }
}
