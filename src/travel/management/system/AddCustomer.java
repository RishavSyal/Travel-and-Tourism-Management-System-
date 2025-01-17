
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{

    JLabel labelusername,labelName;
    JComboBox comboid;
    JTextField tfnumber , tfcountry ,tfaddress ,tfemail,tfphonenumber;
    JRadioButton rmale ,rfemale;
    JButton add,back;
    
     AddCustomer(String username ) {
         setBounds(250,150,800,500);
         setLayout(null);
         getContentPane().setBackground(Color.white);
         
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
         comboid = new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Ration Card"});
         comboid.setBounds(220,90,150,25);
         comboid.setBackground(Color.white);
         add(comboid);
         
         
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
         
         rmale = new JRadioButton("Male");
         rmale.setBounds(220,210,70,25);
         rmale.setBackground(Color.white);
         add(rmale);
         // female 
              rfemale  = new JRadioButton("Female");
         rfemale.setBounds(290,210,70,25);
         rfemale.setBackground(Color.white);
         add(rfemale);
         
         ButtonGroup bg = new ButtonGroup();
         bg.add(rmale);
         bg.add(rfemale);
         
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
         
         //  email
          JLabel lblemail= new JLabel("Email");
          lblemail.setBounds(30,330,150,25);
         add( lblemail );
         
         tfemail  = new JTextField();
        tfemail.setBounds(220,330,150,25);
         add(tfemail);
         
           //  phonenumber
          JLabel lblphonenumber= new JLabel("Phone Number");
         lblphonenumber.setBounds(30,370,150,25);
         add(lblphonenumber);
         
        tfphonenumber  = new JTextField();
        tfphonenumber.setBounds(220,370,150,25);
         add(tfphonenumber);
         
         
         
         // button
         add= new JButton("Add");
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
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
         Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         
         JLabel image = new JLabel(i3);
         image.setBounds(440, 40, 350,420);
         add(image);
         
         
         try{
             Conn c = new Conn();
           ResultSet rs=  c.s.executeQuery("select * from account where username = '"+username+"'");
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                 labelName.setText(rs.getString("name"));
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
              String id  = (String) comboid.getSelectedItem();
              String number = tfnumber.getText();
              String name = labelName.getText();
              
              String gender = null ;
              if(rmale.isSelected()){
                  gender = "Male";
              }
              else{
                  gender="Female ";
              }
              String country = tfcountry.getText();
              String address = tfaddress.getText();
              String phonenumber = tfphonenumber.getText();
              String email = tfemail.getText();
              
             // JOptionPane.showMessageDialog(null,"Customer Added Sucessfully");
            //  System.exit(0);
        
              
           try{
               Conn c = new Conn();
               
               String query = "insert into customerdetails values('"+username+"' ,   '"+id+"' , '"+number+"' , '"+name+"' , '"+gender+"' , '"+country+"' , '"+address+"' ,'"+phonenumber+"',  '"+email+"' )";
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Customer details added successfully ");
           }   catch (Exception e){
               e.printStackTrace();
           }
              
              
         
          
          
          
          }
          else{
              setVisible(false);
          }
      }
    
    
    
    
    
    public static void main(String[] args){
        
        new  AddCustomer("username");
        
        
    }
}
