package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRooms(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType=new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available=new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel rm1=new JLabel("Room Number");
        rm1.setBounds(60,170,100,20);
        add(rm1);
        
        JLabel rm2=new JLabel("Availability");
        rm2.setBounds(280,170,100,20);
        add(rm2);
        
        JLabel rm3=new JLabel("Status");
        rm3.setBounds(495,170,100,20);
        add(rm3);
        
        JLabel rm4=new JLabel("Price");
        rm4.setBounds(700,170,100,20);
        add(rm4);
        
        JLabel rm5=new JLabel("Bed Type");
        rm5.setBounds(880,170,100,20);
        add(rm5);
        
        table=new JTable();
        table.setBounds(2,200,1035,300);
        add(table);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
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
                String query1="select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2="select * from room where availability = 'Available' AND bed_type= '"+bedType.getSelectedItem()+"'";
                
                Conn conn=new Conn();
                ResultSet rs;
                
                if(available.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }else{
                    rs=conn.s.executeQuery(query1);
                }
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
        new SearchRooms();
    }
}
