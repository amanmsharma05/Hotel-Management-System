package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    Choice carModel;
    JCheckBox available;
    
    Pickup(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed=new JLabel("Car Model");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        carModel=new Choice();
        carModel.setBounds(150,100,200,25);
        add(carModel);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select *from driver");
            while(rs.next()){
                carModel.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel lbl1=new JLabel("Name");
        lbl1.setBounds(60,170,100,20);
        add(lbl1);
        
        JLabel lbl2=new JLabel("Age");
        lbl2.setBounds(210,170,100,20);
        add(lbl2);
        
        JLabel lbl3=new JLabel("Gender");
        lbl3.setBounds(350,170,100,20);
        add(lbl3);
        
        JLabel lbl4=new JLabel("Company");
        lbl4.setBounds(500,170,100,20);
        add(lbl4);
        
        JLabel lbl5=new JLabel("Model");
        lbl5.setBounds(650,170,100,20);
        add(lbl5);
        
        JLabel lbl6=new JLabel("Availability");
        lbl6.setBounds(790,170,100,20);
        add(lbl6);
        
        JLabel lbl7=new JLabel("Address");
        lbl7.setBounds(920,170,100,20);
        add(lbl7);
        
        table=new JTable();
        table.setBounds(2,200,1035,300);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setBounds(300,150,1000,600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from driver where brand = '"+carModel.getSelectedItem()+"'";
                
                Conn conn=new Conn();
                ResultSet rs;
                
                rs=conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
           setVisible(false);
           new Reception(); 
        }
    }
    public static void main(String[] args){
        new Pickup();
    }
}
