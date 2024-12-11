
package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPacakage extends JFrame{

     CheckPacakage() {
         setBounds(300, 150,850,500);
         
         String[]  pacakage1 = {"Gold PACKAGE ", "6 Days & 7 Nights", "Airport Assistance","Half Day City Tour", "Daily buffet", "Soft drinks", "Full Day 3 Island Cruise","English Speaking Guide","BOOK PACKAGE","SUMMER SPECIAL","RS 12000/-" ,"package1.jpg"};
         String[] pacakage2 = {"SILVER PACKAGE" ,"5 Days & 6 Nights", "Toll Free ", "Entrance Free Tickets" ,"Meet and Greet at Aiport","Welcome drinks on Arrival","Night Safari","Cruise with Dinner","BOOK NOW","WINTER SPECIAL","RS 24000/-" ,"package2.jpg"};
         String[] pacakage3 = {"BRONZE PACKAGE" ,"6 Days & 5 Nights","Return Airfare","Free Clubbing,Horse Ridding " ,"River Rafting" , "Welcome drinks on arrival","Daily Buffet", "BBQ Dinner","BOOK NOW","WINTER SPECIAL","RS 32000/-",  "package3.jpg"};
         
         
         JTabbedPane tab = new JTabbedPane();
         JPanel p1 = createPacakage(pacakage1);   
        tab.addTab("Package 1",null , p1);
        
         JPanel p2 = createPacakage(pacakage2); 
        tab.addTab("Package 2",null ,p2);
        
         JPanel p3 = createPacakage(pacakage3); 
        tab.addTab("Package 3",null,p3);
        
        add(tab);
         
         setVisible(true);
     }
    
     public JPanel createPacakage(String[] pack){
          
         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBackground(Color.white);
         
         
         JLabel l1 = new JLabel(pack [0]);
         l1.setBounds(50,10,300,30);
         l1.setForeground(Color.yellow);
         l1.setFont(new Font("Tahoma",Font.BOLD,25));
         p1.add(l1);
         
           
         JLabel lf = new JLabel("Features ");
         lf.setBounds(30,40,300,30);
         lf.setForeground(Color.black);
         lf.setFont(new Font("Tahoma",Font.BOLD,10));
         p1.add(lf);
         
         
           JLabel l2 = new JLabel(pack [1]);
         l2.setBounds(30,60,300,30);
         l2.setForeground(Color.red);
         l2.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l2);
     
          JLabel l3 = new JLabel(pack [2]);
         l3.setBounds(30,110,300,30);
         l3.setForeground(Color.blue);
         l3.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l3);
         
           JLabel l4 = new JLabel(pack [3]);
       l4.setBounds(30,160,300,30);
         l4.setForeground(Color.red);
         l4.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l4);
         
            JLabel l5 = new JLabel(pack [4]);
       l5.setBounds(30,210,300,30);
         l5.setForeground(Color.blue);
         l5.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l5);
         
           JLabel l6 = new JLabel(pack [5]);
       l6.setBounds(30,260,300,30);
         l6.setForeground(Color.blue);
         l6.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l6);
         
         
        JLabel l7 = new JLabel(pack [6]);
        l7.setBounds(30,310,300,30);
         l7.setForeground(Color.red);
         l7.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l7);
         
          JLabel l8 = new JLabel(pack [7]);
        l8.setBounds(30,360,300,30);
         l8.setForeground(Color.blue);
         l8.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l8);
         
             JLabel l9 = new JLabel(pack [8]);
        l9.setBounds(60,400,300,30);
         l9.setForeground(Color.black);
         l9.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l9);
         
              JLabel l10 = new JLabel(pack [9]);
        l10.setBounds(300,350,300,30);
         l10.setForeground(Color.magenta);
        l10.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l10);
         
               JLabel l11 = new JLabel(pack [10]);
        l11.setBounds(300,390,300,30);
         l11.setForeground(Color.green);
        l11.setFont(new Font("Tahoma",Font.BOLD,15));
         p1.add(l11);
         
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
         Image i2 = i1.getImage().getScaledInstance(450,300, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
          
         JLabel image = new JLabel(i3);
         image.setBounds(350,50,450,300);
          p1.add(image);
          
          return p1;
     }
    
    
    public static void main(String[] args) {
        new CheckPacakage();
    }
}
