package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel rm1=new JLabel("Document Type");
        rm1.setBounds(25,15,100,20);
        add(rm1);
        
        JLabel rm2=new JLabel("Document Number");
        rm2.setBounds(140,15,150,20);
        add(rm2);
        
        JLabel rm3=new JLabel("Name");
        rm3.setBounds(295,15,100,20);
        add(rm3);
        
        JLabel rm4=new JLabel("Gender");
        rm4.setBounds(425,15,100,20);
        add(rm4);
        
        JLabel rm5=new JLabel("Country");
        rm5.setBounds(545,15,100,20);
        add(rm5);
        
        JLabel rm6=new JLabel("Room No.");
        rm6.setBounds(670,15,100,20);
        add(rm6);
        
        JLabel rm7=new JLabel("CheckIn Time");
        rm7.setBounds(780,15,100,20);
        add(rm7);
        
        JLabel rm8=new JLabel("Deposit");
        rm8.setBounds(910,15,100,20);
        add(rm8);
        
        table=new JTable();
        table.setBounds(5,40,1000,400);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}
