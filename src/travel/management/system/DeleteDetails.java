
package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener{

    JButton back;
        
    String username;
     DeleteDetails(String username) {
         this.username=username;
         setBounds(300,130,870,500);
         getContentPane().setBackground(Color.white);
         
         setLayout(null);
         
         // username
          JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(30,50,150,25);
         add(lblusername);
         
        JLabel labelusername = new JLabel();
       labelusername.setBounds(220,50,150,25);
         add(labelusername);
         
         // id 
            JLabel lblid = new JLabel("ID");
         lblid.setBounds(30,90,150,25);
         add(lblid);
         
        JLabel labelid = new JLabel();
       labelid.setBounds(220,90,150,25);
         add(labelid);
         
         // number 
             JLabel lblnumber = new JLabel("Number");
         lblnumber.setBounds(30,130,150,25);
         add(lblnumber);
         
        JLabel labelnumber = new JLabel();
       labelnumber.setBounds(220,130,150,25);
         add(labelnumber);
         
         
         
          // name   
            JLabel lblname = new JLabel("Name");
         lblname.setBounds(30,170,150,25);
         add(lblname);
         
        JLabel labelname = new JLabel();
       labelname.setBounds(220,170,150,25);
         add(labelname);
         
          // gender    
            JLabel lblgender = new JLabel("Gender");
         lblgender.setBounds(30,210,150,25);
         add(lblgender);
         
        JLabel labelgender = new JLabel();
       labelgender.setBounds(220,210,150,25);
         add(labelgender);
         
           // country    
            JLabel lblcountry = new JLabel("Country");
         lblcountry.setBounds(400,50,150,25);
         add(lblcountry);
         
        JLabel labelcountry = new JLabel();
       labelcountry.setBounds(600,50,150,25);
         add(labelcountry);
         
           // address  
            JLabel lbladdress   = new JLabel("Address");
         lbladdress .setBounds(400,90,150,25);
         add(lbladdress );
         
        JLabel labeladdress = new JLabel();
       labeladdress.setBounds(600,90,150,25);
         add(labeladdress);
           // phonenumber    
            JLabel lblphonenumber  = new JLabel("Phone number");
         lblphonenumber .setBounds(400,130,150,25);
         add(lblphonenumber );
         
        JLabel labelphonenumber  = new JLabel();
       labelphonenumber .setBounds(600,130,150,25);
         add(labelphonenumber );
         
           // email  
            JLabel lblemail   = new JLabel("Email");
         lblemail  .setBounds(400,170,150,25);
         add(lblemail  );
         
        JLabel labelemail   = new JLabel();
       labelemail  .setBounds(600,170,150,25);
         add(labelemail  );
         
         // button
         back = new JButton("Delete");
         back.setBackground(Color.BLUE);
         back.setForeground(Color.white);
         back.setBounds(350,250,100, 25);
         back.addActionListener(this);
         add(back);
         
         
         // image 
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
         Image i2 = i1.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         
         JLabel image = new JLabel(i3);
         image.setBounds(10,270, 600,200);
         
         add(image);
         
         // image 
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
         Image i5 = i4.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         
         JLabel image2 = new JLabel(i6);
         image2.setBounds(600,270, 600,200);
         
         add(image2);
         
         
         // fetching data from database 
         
         try{
             Conn  c = new Conn();
             String query = "select * from customerdetails where username = '"+username+"'  ";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                 labelid.setText(rs.getString("id"));
                 labelnumber.setText(rs.getString("number"));
                 labelname.setText(rs.getString("name"));
                 labelgender.setText(rs.getString("gender"));
                 labelcountry.setText(rs.getString("country"));
                 labeladdress.setText(rs.getString("address"));
                 labelphonenumber.setText(rs.getString("phonenumber"));
                 labelemail.setText(rs.getString("email"));
                 
                 
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
         
         
         
         
         setVisible(true);
    }
     
     public void actionPerformed(ActionEvent ae){
          try{
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customerdetails where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
          
            
            JOptionPane.showMessageDialog(null,"Data Deleted Sucessfully ");
             
              
              System.exit(0);
          }   
          catch(Exception e){
              e.printStackTrace();
          }
         
     }
    
    
    
    
    
    public static void main(String[] args){
        new DeleteDetails("username");
    }
    
}
