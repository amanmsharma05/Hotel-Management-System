package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomerid;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout,back;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        JLabel lblid=new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomerid=new Choice();
        ccustomerid.setBackground(Color.WHITE);
        ccustomerid.setBounds(150,85,150,25);
        add(ccustomerid);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,85,20,20);
        add(tick);
        
        JLabel lblroom=new JLabel("Room No.");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber=new JLabel();
        lblroomnumber.setBounds(150,130,150,30);
        add(lblroomnumber);
        
        JLabel lblcheckin=new JLabel("CheckIn Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,119,30);
        add(lblcheckintime);
        
        JLabel lblcheckout=new JLabel("CheckOut Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date=new Date();
        
        lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,119,30);
        add(lblcheckouttime);
        
        checkout=new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,290,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(180,290,120,30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomerid.add(rs.getString("number")); //column name from sql table
                lblroomnumber.setText(rs.getString("roomnumber"));
                lblcheckintime.setText(rs.getString("check_In_Time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==checkout){
            String query1="delete from customer where number = '"+ccustomerid.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+lblroomnumber.getText()+"'";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Checkout();
    }
}
