
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
     JButton addPersonalDetails , viewPersonalDetails ,updatePersonalDetails ,checkPackages ,bookPackage , viewPackage , viewHotels ,Destination ,  bookHotel ;
     JButton viewbookedHotel, payments ,calculator ,notepad ,about;
    String username;
    Dashboard(String username) {
        this.username = username ;
    //  setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(null);
        
        
        
        JPanel p1= new JPanel();
        p1.setLayout(null);
        
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,50);
        add(p1);
        
    //  setting image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        
          JLabel heading = new JLabel("Dashboard");
          heading.setBounds(80,5,300,40);
          heading.setForeground(Color.white);
          heading.setFont(new Font("Tahoma",Font.BOLD,30)); 
        
         p1.add(heading);
         
         
         // side bar
         
         
         JPanel p2= new JPanel();
        p2.setLayout(null);
        
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,50,250,900);
        add(p2);
        
         // All button in side bar 
         
        /// addPersonalDetails button
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,250,35);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
         
        /// updatePersonalDetails button
        updatePersonalDetails  = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,35,250, 35);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
        updatePersonalDetails.setMargin(new Insets(0,0,0,35));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails );
         
        
         
            /// viewPersonalDetails button
       viewPersonalDetails  = new JButton("View Details");
       viewPersonalDetails.setBounds(0,70,250, 35);
       viewPersonalDetails.setBackground(new Color(0,0,102));
       viewPersonalDetails.setForeground(Color.white);
       viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
       viewPersonalDetails.setMargin(new Insets(0,0,0,110));
       viewPersonalDetails.addActionListener(this);
       p2.add(viewPersonalDetails);
         
         /// deletePersonalDetails button
      JButton deletePersonalDetails = new JButton("Delete Personal Details");
      deletePersonalDetails.setBounds(0,105,250, 35);
      deletePersonalDetails.setBackground(new Color(0,0,102));
      deletePersonalDetails.setForeground(Color.white);
      deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
      deletePersonalDetails.setMargin(new Insets(0,0,0,40));   
      p2.add(deletePersonalDetails);
        
          /// checkPacakages button
       checkPackages = new JButton("Check Package");
      checkPackages.setBounds(0,140,250, 35);
    checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.white);
       checkPackages.setFont(new Font("Tahoma",Font.PLAIN,15));
       checkPackages.addActionListener(this);
        checkPackages.setMargin(new Insets(0,0,0,90));
         
         p2.add(checkPackages);
         
         // bookPackage button 
         bookPackage = new JButton("Book Pacakge");
     bookPackage.setBounds(0,175,250, 35);
    bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
       bookPackage.setFont(new Font("Tahoma",Font.PLAIN,15));
       bookPackage.setMargin(new Insets(0,0,0,100));
       bookPackage.addActionListener(this);
         
         p2.add(bookPackage);
         
           // viewPackage button 
        viewPackage = new JButton("View Pacakge");
         viewPackage.setBounds(0,210,250, 35);
         viewPackage.setBackground(new Color(0,0,102));
         viewPackage.setForeground(Color.white);
         viewPackage.setFont(new Font("Tahoma",Font.PLAIN,15));
         viewPackage.setMargin(new Insets(0,0,0,100));
         viewPackage.addActionListener(this);
         
         p2.add(viewPackage);
         
        // viewHotels button 
        
         viewHotels = new JButton("View Hotels");
         viewHotels.setBounds(0,245,250, 35);
         viewHotels.setBackground(new Color(0,0,102));
         viewHotels.setForeground(Color.white);
         viewHotels.setFont(new Font("Tahoma",Font.PLAIN,15));
         viewHotels.setMargin(new Insets(0,0,0,110));
         viewHotels.addActionListener(this);
         
         p2.add(viewHotels);


            // bookHotel button 
          bookHotel = new JButton("Book Hotel");
         bookHotel.setBounds(0,280,250, 35);
         bookHotel.setBackground(new Color(0,0,102));
         bookHotel.setForeground(Color.white);
         bookHotel.setFont(new Font("Tahoma",Font.PLAIN,15));
        bookHotel.setMargin(new Insets(0,0,0,120));
        bookHotel.addActionListener(this);
         
         p2.add(bookHotel);
         
        // viewbookedHotel button 
         viewbookedHotel = new JButton("View Booked Hotel");
        viewbookedHotel.setBounds(0,315,250, 35);
        viewbookedHotel.setBackground(new Color(0,0,102));
         viewbookedHotel.setForeground(Color.white);
         viewbookedHotel.setFont(new Font("Tahoma",Font.PLAIN,15));
       viewbookedHotel.setMargin(new Insets(0,0,0,70));
       viewbookedHotel.addActionListener(this);
         
         p2.add(viewbookedHotel);
       
            // Destination button 
         Destination = new JButton("Destination");
         Destination.setBounds(0,350,250, 35);
         Destination.setBackground(new Color(0,0,102));
         Destination.setForeground(Color.white);
         Destination.setFont(new Font("Tahoma",Font.PLAIN,15));
        Destination.setMargin(new Insets(0,0,0,110));
        Destination.addActionListener(this);
         
         p2.add(Destination);
         
            //  payment button
              payments = new JButton("Payments");
         payments.setBounds(0,385,250, 35);
         payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
         payments.setFont(new Font("Tahoma",Font.PLAIN,15));
        payments.setMargin(new Insets(0,0,0,120));
         payments.addActionListener(this);
         p2.add(payments);
         
            //  calculator button
              calculator = new JButton("Calculator");
         calculator.setBounds(0,420,250, 35);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,15));
        calculator.setMargin(new Insets(0,0,0,110));
        calculator.addActionListener(this);
     
         
         p2.add(calculator);
         
           //  notepad button
             notepad = new JButton("Notepad");
         notepad.setBounds(0,455,250, 35);
         notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
         notepad.setFont(new Font("Tahoma",Font.PLAIN,15));
        notepad.setMargin(new Insets(0,0,0,120));
         notepad.addActionListener(this);
         p2.add(notepad);
         
           // about button
             about  = new JButton("About");
         about.setBounds(0,490,250, 35);
         about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
         about.setFont(new Font("Tahoma",Font.PLAIN,15));
        about.setMargin(new Insets(0,0,0,140));
         about.addActionListener(this);
         p2.add(about);
         
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         
         JLabel image =  new JLabel(i6);
         image.setBounds(0,0,1650,1000);
         add(image);
         
         JLabel text = new JLabel("Travel and Tourism Management System");
         text.setBounds(350,60 ,1000,60);
         text.setForeground(Color.white);
         text.setFont(new Font("Raleway",Font.BOLD,40));
        image.add(text);
         
      
        setVisible(true);
    }
      
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        } else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        } else if(ae.getSource() == checkPackages){
            new CheckPacakage();
        } else if(ae.getSource() == bookPackage){
            new BookPackage(username);
        } else if (ae.getSource() == viewPackage){
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels){
            new CheckHotels();
        } else if (ae.getSource() == Destination){
            new Destinations();              
        } else if(ae.getSource() == bookHotel){
            new BookHotel(username);
        } else if(ae.getSource() == viewbookedHotel ){
            new ViewBookedHotel(username);
        } else if(ae.getSource() == payments){
            new Payment();
        }  else if(ae.getSource() == calculator){
            try{
               Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            } 
            
        } else if(ae.getSource() == notepad){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == about){
            new About();
        }
    }

     
    
    public static void main(String[] args){
  
        new Dashboard("");
        
        
    }
    
    
    
}
