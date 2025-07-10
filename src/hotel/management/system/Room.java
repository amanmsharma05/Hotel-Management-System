package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Room(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel rm1=new JLabel("Room Number");
        rm1.setBounds(10,15,100,20);
        add(rm1);
        
        JLabel rm2=new JLabel("Availability");
        rm2.setBounds(130,15,100,20);
        add(rm2);
        
        JLabel rm3=new JLabel("Status");
        rm3.setBounds(240,15,100,20);
        add(rm3);
        
        JLabel rm4=new JLabel("Price");
        rm4.setBounds(340,15,100,20);
        add(rm4);
        
        JLabel rm5=new JLabel("Bed Type");
        rm5.setBounds(425,15,100,20);
        add(rm5);
        
        table=new JTable();
        table.setBounds(5,40,510,400);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(300,150,1050,600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Room();
    }
}
