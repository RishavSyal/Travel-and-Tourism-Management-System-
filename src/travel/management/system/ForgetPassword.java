
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import javax.swing.JTextField;
import java.sql.*;


public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername ,  tfname ,  tfquestion, tfanswer ,tfpassword;
  
    JButton  search,retrieve, back ;
    

    ForgetPassword() {
        
        setBounds(250,180,850,400);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,300);
        add(p1);
        
        // username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        
        p1.add(lblusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(200,20 , 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        // search button
        
        search =new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
              
              // name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        
        p1.add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200,60 , 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        // Question
        
          JLabel lblquestion = new JLabel("Your Security Question");
        lblquestion.setBounds(40, 100, 180, 25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        
        p1.add(lblquestion);
        
         tfquestion = new JTextField();
        tfquestion.setBounds(200,100 , 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
         // Answer
        
          JLabel lblanswer = new JLabel("Answer ");
        lblanswer.setBounds(40, 140, 180, 25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        
        p1.add(lblanswer);
        
         tfanswer = new JTextField();
        tfanswer.setBounds(200,140 , 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        // retrieve button
        
        retrieve =new JButton("Retrieve ");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        //Password
        
          JLabel lblpassword = new JLabel("Password ");
        lblpassword.setBounds(40, 180, 180, 25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        
        p1.add(lblpassword);
        
         tfpassword = new JTextField();
        tfpassword.setBounds(200,180 , 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        // back button
        
        back =new JButton("Back ");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
             //   c.s.executeQuery(query);   data fetchinngg and storing in the object of result set 
                
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                  tfname.setText(rs.getString("name"));
                  tfquestion.setText(rs.getString("security"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == retrieve){
            
            
            try{
                String query = "select * from account where answer= '"+tfanswer.getText()+"'  AND username = '"+tfusername.getText()+"' ";
                Conn c = new Conn();  // connection class object 
                
             //   c.s.executeQuery(query);   data fetchinngg and storing in the object of result set 
                
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                  tfpassword.setText(rs.getString("password"));
         
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }
        
        else{
            setVisible(false);
            new Login();
    }
        
    }
    
    public static void main(String[] args){
        
        new ForgetPassword();
    }
    
}
