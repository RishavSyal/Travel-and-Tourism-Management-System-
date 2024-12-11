
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{

    JLabel labelusername,labelName;
  
    JTextField tfnumber , tfcountry ,tfaddress ,tfemail,tfphonenumber , tfid , tfgender;
  
    JButton add,back;
    
      UpdateCustomer(String username ) {
         setBounds(300,150,850,500);
         setLayout(null);
         getContentPane().setBackground(Color.white);
         
         JLabel text =  new JLabel("UPDATE CUSTOMER DETAILS");
         text.setBounds(50,0,500,25);
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         add(text);
         
         
         // username
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(30, 50,150, 25);
         add(lblusername);
         
           labelusername = new JLabel("");
          labelusername.setBounds(220, 50,150, 25);
         add( labelusername);
         
         // id 
             JLabel  lblid = new JLabel("ID");
         lblid.setBounds(30,90,150, 25);
         add(lblid );
         
         // dropdown for id
         tfid = new JTextField();
          tfid .setBounds(220,90,150,25);
         add( tfid );
         
         
         // no. for id 
            JLabel  lblnumber = new JLabel("Number");
         lblnumber.setBounds(30,130,150, 25);
         add(lblnumber );
         
         
         tfnumber = new JTextField();
         tfnumber.setBounds(220,130,150,25);
         add(tfnumber);
         
         // name
          JLabel lblname = new JLabel("Name");
         lblname.setBounds(30, 170,150, 25);
         add(lblname);
         
           labelName = new JLabel("");
          labelName.setBounds(220, 170,150, 25);
         add(labelName);
         
         // gender radio button
           JLabel lblgender = new JLabel("Gender");
         lblgender.setBounds(30, 210,150, 25);
         add(lblgender);
         
         tfgender = new JTextField();
         tfgender.setBounds(220,210,150,25);
         add(tfgender);
         
         // country 
         
         JLabel lblcountry = new JLabel("Country");
         lblcountry.setBounds(30,250,150,25);
         add(lblcountry);
         
         tfcountry = new JTextField();
         tfcountry.setBounds(220,250,150,25);
         add(tfcountry);
         // address
         
         JLabel lbladdress = new JLabel("Address");
         lbladdress .setBounds(30,290,150,25);
         add(lbladdress );
         
          tfaddress = new JTextField();
         tfaddress.setBounds(220,290,150,25);
         add(tfaddress);
            //  phonenumber
          JLabel lblphonenumber= new JLabel("Phone Number");
         lblphonenumber.setBounds(30,370,150,25);
         add(lblphonenumber);
         
        tfphonenumber  = new JTextField();
        tfphonenumber.setBounds(220,370,150,25);
         add(tfphonenumber);
         
         //  email
          JLabel lblemail= new JLabel("Email");
          lblemail.setBounds(30,330,150,25);
         add( lblemail );
         
         tfemail  = new JTextField();
        tfemail.setBounds(220,330,150,25);
         add(tfemail);
         
         
         
         
         
         // button
         add= new JButton("Update ");
         add.setBackground(Color.black);
         add.setForeground(Color.white);
         add.setBounds(100,430,100,25);
         add.addActionListener(this);
         add(add);
         
         back= new JButton("Back");
         back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(230,430,100,25);
        back.addActionListener(this);
         add(back);
         
         // right side image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
         Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         
         JLabel image = new JLabel(i3);
         image.setBounds(440, 90, 300,300);
         add(image);
         
         
         try{
             Conn c = new Conn();
           ResultSet rs=  c.s.executeQuery("select * from  customerdetails where username = '"+username+"' ");
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                    
                          tfid.setText(rs.getString("id"));
  
                      tfnumber.setText(rs.getString("number"));
                     labelName.setText(rs.getString("name"));
                      tfgender.setText(rs.getString("gender"));
                     tfcountry.setText(rs.getString("country"));
                     tfaddress.setText(rs.getString("address"));
                 tfphonenumber.setText(rs.getString("phonenumber"));
                       tfemail.setText(rs.getString("email"));
                    
                    
                 
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }         
         
         
         
         
         
         setVisible(true);
    }
   
     
     
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == add){
              String username = labelusername.getText();
              String id  =  tfid.getText();
              String number = tfnumber.getText();
              String name = labelName.getText();
              
              String gender = tfgender.getText();
              String country = tfcountry.getText();
              String address = tfaddress.getText();
              String phonenumber = tfphonenumber.getText();
              String email = tfemail.getText();
        
              
           try{
               Conn c = new Conn();
               
               String query = "update  customerdetails set username = '"+username+"' , id =   '"+id+"' , number = '"+number+"' , name = '"+name+"' , gender = '"+gender+"' , country=  '"+country+"' , address= '"+address+"' , phonenumber = '"+phonenumber+"', email= '"+email+"' ";
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully ");
           }   catch (Exception e){
               e.printStackTrace();
           }
              
     
          
          }
          else{
              setVisible(false);
          }
      }
    
    
    
    
    
    public static void main(String[] args){
        
        new  UpdateCustomer("username");
        
        
    }
}
