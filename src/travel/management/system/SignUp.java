
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// import java.awt.event;

public class SignUp extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;

    public SignUp() {
        
        setBounds(300,180,850,350);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0, 0, 450, 350);
        p1.setLayout(null);
        add(p1);
         
        // username 
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        
         tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        
        // Name 
         JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        
          tfname = new JTextField();
        tfname.setBounds(190,60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        // Password
        
        JLabel lblpassword = new JLabel("Password ");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        
         tfpassword = new JTextField();
        tfpassword.setBounds(190,100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        
        // choice question
        
        security =new Choice();
        security.add("Fav Character from the Boys");
        security.add("Fav marvel superhero");
        security.add("Your lucky Number");
        security.add("Your childhood superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        
        // answer
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        
        
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        
        // button 
        
               create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        //  back button
              back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        
        // image
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
         Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
          JLabel image = new JLabel(i3);
          image.setForeground(Color.white);
           image.setBounds(500,50,200,200);
         add(image);
        
        
        
        
        setVisible(true);
        
        
        
    }
      
    
    
    
    
    // overridding abstract method
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String answer=tfanswer.getText();
            // to get value from dropdown and choice we use getselectedItem method
            String question = security.getSelectedItem();
            
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                
                new Login();
                     
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
 
    
    
    public static void main(String[] args){
        new SignUp();
    }
}
