package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    EmployeeInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel rm1=new JLabel("Name");
        rm1.setBounds(45,15,100,20);
        add(rm1);
        
        JLabel rm2=new JLabel("Age");
        rm2.setBounds(180,15,100,20);
        add(rm2);
        
        JLabel rm3=new JLabel("Gender");
        rm3.setBounds(295,15,100,20);
        add(rm3);
        
        JLabel rm4=new JLabel("Job");
        rm4.setBounds(425,15,100,20);
        add(rm4);
        
        JLabel rm5=new JLabel("Salary");
        rm5.setBounds(545,15,100,20);
        add(rm5);
        
        JLabel rm6=new JLabel("Phone");
        rm6.setBounds(670,15,100,20);
        add(rm6);
        
        JLabel rm7=new JLabel("Email");
        rm7.setBounds(790,15,100,20);
        add(rm7);
        
        JLabel rm8=new JLabel("Aadhar");
        rm8.setBounds(910,15,100,20);
        add(rm8);
        
        table=new JTable();
        table.setBounds(5,40,1000,400);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
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
        new EmployeeInfo();
    }
}
