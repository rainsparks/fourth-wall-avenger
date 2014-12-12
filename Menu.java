import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;


public class Menu extends JFrame {

    public Menu() {
        initUI();
    }

    public final void initUI() {
    
       JPanel panel = new JPanel();
       getContentPane().add(panel);
       panel.setLayout(null);
       panel.setBackground(Color.black);
       
       
       JLabel title=new JLabel("ASSEMBLER / DISASSEMBLER");
       title.setForeground(Color.GRAY);
       title.setFont(new Font("Courier", Font.BOLD, 24));
       title.setBounds(70, 30, 200, 200);
       title.setSize(350,100);
       
       panel.add(title);
       
       JButton button1 = new JButton("C TO ASM");
       button1.setBackground(Color.GRAY);
       button1.setForeground(Color.WHITE);
       button1.setFocusPainted(false);
       button1.setFont(new Font("Arial", Font.BOLD, 18));
       button1.setBounds(50, 150, 80, 30);
       button1.setSize(150,50);
              
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   AssemblerFrame frame1 = new AssemblerFrame();
       	       frame1.setVisible(true);
          }
       });

       panel.add(button1);
      
       JButton button2 = new JButton("ASM TO C");
       button2.setBackground(Color.GRAY);
       button2.setForeground(Color.WHITE);
       button2.setFocusPainted(false);
       button2.setFont(new Font("Arial", Font.BOLD, 18));
       button2.setBounds(280, 150, 80, 30);
       button2.setSize(150,50);
       
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   DisassemblerFrame frame2 = new DisassemblerFrame();
        	    frame2.setVisible(true);
          }
       });

       panel.add(button2);

       
       setTitle("Assembler/Disassembler");
       setSize(500, 400);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
      
           Menu x = new Menu();
           x.setVisible(true);
           
      
    }
}
