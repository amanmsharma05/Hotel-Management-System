package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Department(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel rm1=new JLabel("Department");
        rm1.setBounds(150,20,100,20);
        add(rm1);
        
        JLabel rm2=new JLabel("Budget");
        rm2.setBounds(480,20,100,20);
        add(rm2);
        
        table=new JTable();
        table.setBounds(10,50,700,350);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,480);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Department();
    }
}