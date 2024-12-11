
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author RISHAV SYAL
 */

public class About extends JFrame implements ActionListener{
  JButton back;
  
    About() {
        setBounds(300,150,850,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200,20,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma" , Font.BOLD ,20));
        add(l1);
        
        
        TextArea area = new TextArea("About projects",10,40,Scrollbar.VERTICAL);
        
        area.setEditable(false);
        area.setBounds(20,100,450,300); 
        add(area);
        
        
        
          
         back = new JButton("Back");
        back.setBounds(200,420,100,40);
        back.addActionListener(this);
        add(back);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent  ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new About();
    }
}
