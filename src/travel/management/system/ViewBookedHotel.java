

package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//import java.awt.Color;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

public class ViewBookedHotel extends JFrame implements ActionListener{

    JButton back;
        
    
    ViewBookedHotel(String username){
         
         setBounds(300,150,850,500);
         getContentPane().setBackground(Color.white);
         
         setLayout(null);
         
         JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS ");
         text.setFont(new Font("Tahoma",Font.BOLD, 15));
         text.setBounds(60,10,300,20);
         add(text);
         
         // username
          JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(30,50,150,25);
         add(lblusername);
         
        JLabel labelusername = new JLabel();
       labelusername.setBounds(220,50,150,25);
         add(labelusername);
         
         // hotel name  
            JLabel lblhotelname = new JLabel("Hotel Name");
            lblhotelname.setBounds(30,80,150,25);
            add(lblhotelname);
         
           JLabel labelhotelname= new JLabel();
           labelhotelname.setBounds(220,80,150,25);
           add(labelhotelname);
         
         // totalpersons
             JLabel lblpersons = new JLabel("Total Persons");
             lblpersons.setBounds(30,110,150,25);
             add(lblpersons);
         
            JLabel labelpersons = new JLabel();
            labelpersons.setBounds(220,110,150,25);
            add(labelpersons);
         
          
         
          // total days
             JLabel lbldays = new JLabel("Total Days");
             lbldays.setBounds(30,140,150,25);
             add(lbldays);
         
             JLabel labeldays = new JLabel();
             labeldays.setBounds(220,140,150,25);
             add(labeldays);
         
          // ac or non ac
             JLabel lblac = new JLabel("AC or Non Ac");
         lblac.setBounds(30,170,150,25);
         add(lblac);
         
        JLabel labelac = new JLabel();
       labelac.setBounds(220,170,150,25);
         add(labelac);
         
         
         /// 
         
             JLabel lblfood = new JLabel("Food Included ?");
         lblfood.setBounds(30,200,150,25);
         add(lblfood);
         
        JLabel labelfood = new JLabel();
       labelfood.setBounds(220,200,150,25);
         add(labelfood);
         
          // id   
            JLabel lblid = new JLabel("ID");
         lblid.setBounds(30,230,150,25);
         add(lblid);
         
        JLabel labelid = new JLabel();
       labelid.setBounds(220,230,150,25);
         add(labelid);
         
          //pnumber    
            JLabel lblnumber = new JLabel("Number");
         lblnumber.setBounds(30,260,150,25);
         add(lblnumber);
         
        JLabel labelnumber = new JLabel();
       labelnumber.setBounds(220,260,150,25);
         add(labelnumber);
         
           // phonenumber    
            JLabel lblphonenumber = new JLabel("Phone number");
         lblphonenumber.setBounds(30,290,150,25);
         add(lblphonenumber);
         
        JLabel labelphonenumber = new JLabel();
       labelphonenumber.setBounds(220,290,150,25);
         add(labelphonenumber);
         
           // price
            JLabel lblprice  = new JLabel("Price");
         lblprice .setBounds(30,320,150,25);
         add(lblprice );
         
        JLabel labelprice = new JLabel();
       labelprice.setBounds(220,320,150,25);
         add(labelprice);
         
          
         
        
         // button
         back = new JButton("Back");
         back.setBackground(Color.BLUE);
         back.setForeground(Color.white);
         back.setBounds(130,380,100, 25);
         back.addActionListener(this);
         add(back);        
       
      // image 
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
         Image i5 = i4.getImage().getScaledInstance(400,350, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         
         JLabel image2 = new JLabel(i6);
         image2.setBounds(400,50, 400,350);
         
         add(image2);
         
         
         // fetching data from database 
         
         try{
             Conn  c = new Conn();
             String query = "select * from bookhotel where username = '"+username+"'  ";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
                 
                 labelusername.setText(rs.getString("username"));
               // labelpackage.setText(rs.getString("package"));
                  labelhotelname.setText("name");
                  labelpersons.setText(rs.getString("persons"));
                  labeldays.setText("days");
                  labelac.setText("ac");
                  labelfood.setText("food");
                  labelid.setText(rs.getString("id"));
                  labelnumber.setText(rs.getString("number")); 
                  labelphonenumber.setText(rs.getString("phone"));
                  labelprice.setText(rs.getString("price"));
                      
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
         
         
         
         
         setVisible(true);
    }
     
     public void actionPerformed(ActionEvent ae){
          setVisible(false);
               
         
     }
    
    
    
    
    
    public static void main(String[] args){
        new ViewBookedHotel("username");
    }
    
}
