
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class  BookHotel  extends JFrame implements ActionListener{
 String    username ;
 Choice    chotel ,cac ,cfood;
 JTextField tfpersons ,tfdays;
     JLabel   labelusername , labelid     , labelnumber , labelphonenumber , labelprice  ;
     JButton  checkprice    , bookpackage , back ;
     
    BookHotel(String username) {
        
        this.username = username;
       
        setBounds(250,150,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100,10,200,40);
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        add(text);
        
        
    //  username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,60,150,15);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN,15));

        add(lblusername);
         
        labelusername = new JLabel();
        labelusername.setBounds(250,60,200,20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(labelusername);
         
       
    //  SELECT HOTEL 
        JLabel lblhotel = new JLabel("Select Hotel ");
        lblhotel.setBounds(40,90,150,15);
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(lblhotel);
         
        chotel = new Choice();
        chotel.setBounds(250,90,200,15);
        add(chotel);
         
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from  hotel");
             while(rs.next()){
                 chotel.add(rs.getString("name"));
             }
         }
         catch (Exception e){
             
             e.printStackTrace();
         }
         
  
         
    //  totalperson
         JLabel lblpersons = new JLabel("Total Persons");
         lblpersons.setBounds(40,120,150,15);
           lblpersons.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblpersons);
         
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,120,200,20);
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(tfpersons);
       
         
          //  No. of Days 
         JLabel lbldays = new JLabel("No. of Days");
         lbldays.setBounds(40,150,150,15);
         lbldays.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lbldays);
         
        tfdays = new JTextField("1");
        tfdays.setBounds(250,150,200,20);
        tfdays.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(tfdays);
         
         
          //   ac or non ac
         JLabel lblac = new JLabel("Ac/Non-Ac");
         lblac.setBounds(40,180,150,15);
         lblac.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblac);
         
         cac = new Choice();
         cac.add("AC");
         cac.add("Non-AC");
         cac.setBounds(250,180,200,15);
         add(cac);
         
    //   food
         JLabel lblfood = new JLabel("Food Included");
         lblfood.setBounds(40,210,150,15);
         lblfood.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblfood);
         
         cfood = new Choice();
         cfood.add("Yes");
         cfood.add("No");
         cfood.setBounds(250,210,200,15);
         add(cfood);
         
    //  id
         JLabel lblid = new JLabel("ID");
         lblid.setBounds(40,240,150,15);
          lblid.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblid);
 
          labelid = new JLabel();
       labelid.setBounds(250,240,200,15);
         labelid.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(labelid);
        
        
         //  id --- number 
         JLabel number = new JLabel("Number");
         number.setBounds(40,270,150,15);
         number.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(number);
         
         
          labelnumber = new JLabel();
         labelnumber.setBounds(250,270,200,15);
          labelnumber.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(labelnumber);
         
         // phonenumber
         JLabel lblphonenumber = new JLabel("Phone");
          lblphonenumber.setBounds(40,300,150,15);
          lblphonenumber.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblphonenumber);
         
         
        labelphonenumber= new JLabel();
        labelphonenumber.setBounds(250,300,200,15);
        labelphonenumber.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(labelphonenumber);
        
        // price 
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(40,330,150,15);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(lblprice);
        
         labelprice = new JLabel();
          labelprice.setBounds(250,330,150,15);
        labelprice.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(labelprice);
        
        
        try{
             Conn  c = new Conn();
             String query = "select * from customerdetails where username = '"+username+"'  ";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
                 labelusername.setText(rs.getString("username"));
                 labelid.setText(rs.getString("id"));
                 labelnumber.setText(rs.getString("number"));
      
                 labelphonenumber.setText(rs.getString("phonenumber"));
                
                 
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
        
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,370 ,120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
         
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(220,370 ,120, 25);
                bookpackage.addActionListener(this);

        add(bookpackage);
        
        
        
         
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(150,400 ,100, 25);       
        back.addActionListener(this);

        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image  i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(480,30,400,400);
        
        add(image);      
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource() == checkprice ){
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"' ");
            while(rs.next()){
               int cost = Integer.parseInt(rs.getString("costperperson"));
               int food = Integer.parseInt(rs.getString("foodincluded"));
               int ac = Integer.parseInt(rs.getString("acroom"));
               
               
               int persons = Integer.parseInt(tfpersons.getText());
               int days = Integer.parseInt(tfdays.getText());
               
               String acselected = cac.getSelectedItem();
               String foodselected = cfood.getSelectedItem();
               
               if(persons * days > 0){
                   int total = 0 ;
                   total += acselected.equals("AC")? ac :  0;
                   total += foodselected.equals("Yes")? food :0;
                   total += cost;
                   total = total * persons * days;
                   labelprice.setText("Rs"+total);
               }
               else {
                   JOptionPane.showMessageDialog(null, "Please enter a valid number");
         
                    }        
            }
           
       } catch(Exception e){
           e.printStackTrace();
       }
        }
        else if ( ae.getSource() == bookpackage) {
            try{
             Conn c  = new Conn();
             c.s.executeUpdate("insert into bookhotel values( '" +labelusername.getText() + "'  ,  '"+chotel.getSelectedItem()+"',   '"+tfpersons.getText()+"' ,  '"+tfdays.getText()+"' ,'"+cac.getSelectedItem()+"'  , '"+cfood.getSelectedItem()+"','"+labelid.getText()+"' , '"+labelnumber.getText()+"' ,  '"+labelphonenumber.getText()+"',   '"+labelprice.getText()+"' )");
           
            JOptionPane.showMessageDialog(null,"Hotel Booked Sucessfully");
                setVisible(false);
            }  
            catch(Exception e){
                e.printStackTrace();
            }
            
        } 
        
        else {
            setVisible(false);
        }  
    }
    
    
    public static void main(String[] args){
        new BookHotel("username");
    }
}
