
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BookPackage extends JFrame implements ActionListener{
 String username ;
 Choice cpackage;
 JTextField tfpersons ;
     JLabel labelusername , labelid ,labelnumber ,labelphonenumber ,labelprice ;
     JButton checkprice , bookpackage , back ;
     
    BookPackage(String username) {
        
       this.username = username;
        setBounds(250,150,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
           JLabel text = new JLabel("BOOK PACKAGE");
         text.setBounds(100,5,200,40);
         text.setFont(new Font("Tahoma", Font.BOLD,25));
         add(text);
        
        
         // username
          JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(40,60,150,15);
         lblusername.setFont(new Font("Tahoma", Font.PLAIN,15));

         add(lblusername);
         
        labelusername = new JLabel();
       labelusername.setBounds(250,60,200,20);
         labelusername.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(labelusername);
         
         // package 
            JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,90,150,15);
         lblpackage.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblpackage);
         
         cpackage = new Choice();
         cpackage.add("Gold Package");
         cpackage.add("Silver Package");
         cpackage.add("Bronze Package");
         cpackage.setBounds(250,90,200,15);
         add(cpackage);
         
         // totalperson
             JLabel lblpersons = new JLabel("Total Persons");
         lblpersons.setBounds(40,120,150,15);
           lblpersons.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblpersons);
         
        tfpersons = new JTextField("1");
       tfpersons.setBounds(250,120,200,20);
         tfpersons.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(tfpersons);
         
         
         // id
         JLabel lblid = new JLabel("ID");
         lblid.setBounds(40,150,150,15);
          lblid.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblid);
 
          labelid = new JLabel();
       labelid.setBounds(250,150,200,15);
         labelid.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(labelid);
        
        
         //  id ---number 
         JLabel number = new JLabel("Number");
         number.setBounds(40,180,150,15);
          number.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(number);
         
         
          labelnumber = new JLabel();
         labelnumber.setBounds(250,180,200,15);
          labelnumber.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(labelnumber);
         
         // phonenumber
         JLabel lblphonenumber = new JLabel("Phone ");
          lblphonenumber.setBounds(40,210,150,15);
          lblphonenumber.setFont(new Font("Tahoma", Font.PLAIN,15));
         add(lblphonenumber);
         
         
          labelphonenumber= new JLabel();
        labelphonenumber.setBounds(250,210,200,15);
        labelphonenumber.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(labelphonenumber);
        
        
        // price 
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(40,240,150,15);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(lblprice);
        
         labelprice = new JLabel();
          labelprice.setBounds(250,240,150,15);
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
        checkprice.setBounds(60,300 ,120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
         
       bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(220,300 ,120, 25);
                bookpackage.addActionListener(this);

        add(bookpackage);
        
        
        
         
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(120,350 ,100, 25);       
        back.addActionListener(this);

        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image  i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(480,30,400,400);
        
        add(image);
        
        
        
        
        
        
        setVisible(true);
    
    }
    
    
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource() == checkprice ){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")){
                cost +=12000;
            }else if(pack.equals("Silver Package")){
                cost +=25000;
            }else {
            cost +=32000;
        
            }
       
        int persons = Integer.parseInt(tfpersons.getText());
            cost *=persons;
            labelprice.setText("Rs " + cost);
       } 
        else if ( ae.getSource() == bookpackage) {
            try{
             Conn c  = new Conn();
             c.s.executeUpdate("insert into bookpackage values( '"+labelusername.getText()+"'  ,  '"+cpackage.getSelectedItem()+"',   '"+tfpersons.getText()+"' ,      '"+labelid.getText()+"' ,   '"+labelnumber.getText()+"' ,  '"+labelphonenumber.getText()+"',   '"+labelprice.getText()+"' )");
           
            JOptionPane.showMessageDialog(null,"Package Booked Sucessfully ");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } 
        
        else {
            
            setVisible(false);
        }
            
        
        
        
    }
    
    
    public static void main(String[] args){
        new BookPackage("username");
    }
}
