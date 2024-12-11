
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Payment extends JFrame implements ActionListener{

    JButton pay , back;
    
    Payment (){
        setBounds(300,150,850,500);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(850,500,Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,500);
        add(image);
        
        
        pay = new JButton("Pay");
        pay.setBounds(320,0,80,40);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(420,0,80,40);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource() == pay){
            new Paytm();
        }
        else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Payment();
    }
    
}
