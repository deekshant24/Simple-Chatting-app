/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatting.application;

import static chatting.application.Server.dout;
import static chatting.application.Server.f;
import static chatting.application.Server.formatLabel;
import static chatting.application.Server.vertical;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.net.*;
import java.io.*;

public class Client implements ActionListener{ // server is a class
    
        JTextField text;
        static JPanel a1;
        static Box vertical =Box.createVerticalBox(); // to send message (ek ke niche ek)
        static DataOutputStream dout;
        
        static JFrame f = new JFrame();
    
    Client(){
        f.setLayout(null); // if we do so then we need to tell the panel where it should be placed;
        
        JPanel p1 = new JPanel(); // for addings extra things in frame like header
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        p1.setLayout(null); // to allow label to set their own bound;
        f.add(p1);  //to set component inside frame 
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png")); // to choose image from directory
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); // to get original size of image in lower size
         ImageIcon i3 = new ImageIcon(i2); // can not use i2 because not in ImageIcon sore create another imageicon object;
        JLabel back = new JLabel(i3); // to set image in framme
        back.setBounds(5,20,25,25);
        p1.add(back);// image kp panel ke upr add krne ke liye
        
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
            System.exit(0);
            }
    });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png")); // to choose image from directory
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT); // to get original size of image in lower size
         ImageIcon i6 = new ImageIcon(i5); // can not use i2 because not in ImageIcon sore create another imageicon object;
        JLabel profile = new JLabel(i6); // to set image in framme
        profile.setBounds(40,10,50,50);
        p1.add(profile);// image kp panel ke upr add krne ke liye
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png")); // to choose image from directory
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT); // to get original size of image in lower size
         ImageIcon i9 = new ImageIcon(i8); // can not use i2 because not in ImageIcon sore create another imageicon object;
        JLabel video = new JLabel(i9); // to set image in framme
        video.setBounds(300,20,30,30);
        p1.add(video);// image kp panel ke upr add krne ke liye
        
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png")); // to choose image from directory
        Image i11 = i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT); // to get original size of image in lower size
         ImageIcon i12 = new ImageIcon(i11); // can not use i2 because not in ImageIcon sore create another imageicon object;
        JLabel phone = new JLabel(i12); // to set image in framme
        phone.setBounds(360,20,35,30);
        p1.add(phone);// image kp panel ke upr add krne ke liye
        
        
         ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png")); // to choose image from directory
        Image i14 = i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT); // to get original size of image in lower size
         ImageIcon i15 = new ImageIcon(i14); // can not use i2 because not in ImageIcon sore create another imageicon object;
        JLabel morevert = new JLabel(i15); // to set image in framme
        morevert.setBounds(420,20,10,25);
        p1.add(morevert);// image kp panel ke upr add krne ke liye
        
        
        JLabel name = new JLabel("Kittu");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);
        
        
         JLabel status = new JLabel("Online");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(status);
        
         a1 = new JPanel(); // for chatting area
        a1.setBounds(5,75,440,570);
        f.add(a1);
        
        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);
        
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,74,84));
        send.setForeground(Color.white);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(send);
        
        
        
        
    f.setSize(450,700);           // to define sizwe of frame;
    f.setLocation(800,50);
    f.getContentPane().setBackground(new Color(255,253,208));             //in setBackground is a class in awt package;
    f.setUndecorated(true);
    
    f.setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String out = text.getText();
            
            JPanel p2 = formatLabel(out);                   // for convert string out to use // because jlabel is return type
            
            a1.setLayout(new BorderLayout());
            
            JPanel right = new JPanel(new BorderLayout());          // message right side align hoga
            right.add(p2,BorderLayout.LINE_END);        // we pass p2 because it doesnot take string // line end 
            vertical.add(right); // for ek ke niche ek
            vertical.add(Box.createVerticalStrut(15));          // 15 space between two message
            
            a1.add(vertical, BorderLayout.PAGE_START);          // vertical start me chaiye to PAGE START
            
            dout.writeUTF(out);
            
            text.setText("");
            
            f.repaint(); // for reload frame when click on send
            f.invalidate(); // to show message after click on send
            f.validate(); // to show message
        }catch(Exception e){
        e.printStackTrace();
        }
            
            
    
    }// in actionListener there is umimplemented method 
    // if we implement such mothed which contain abstract method then override this method;
    
    public static JPanel formatLabel(String out){
    JPanel panel = new JPanel();
    
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    
    JLabel output = new JLabel("<html><p style=\"width: 150px\">"+ out + "</p></html>");
    output.setFont(new Font("Tahoma",Font.PLAIN,16));
    output.setBackground(new Color(37,211,102));
    
    output.setOpaque(true);
    output.setBorder(new EmptyBorder(15,15,15,50));
    
    panel.add(output);
    
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    
    JLabel time = new JLabel();
    time.setText(sdf.format(cal.getTime()));
    
    panel.add(time);
    
    return panel;
    }
    
    public static void main(String []args){
        new Client();  // make annonomous object of  class;
        try{
        Socket s = new Socket("127.0.0.1",6001);        // with the help of this socket it connected to server
        DataInputStream din = new DataInputStream(s.getInputStream());  // to receive message and also with help of socket s
        dout = new DataOutputStream(s.getOutputStream());  // to send messsage with help of socket s 
        
         while(true){        // to receive and send message infinitly
             a1.setLayout(new BorderLayout());
        String msg = din.readUTF();  // readUTF - To read messsage // the message come from client is stored in this msg
        JPanel panel = formatLabel(msg); // to show message in panel
        
        JPanel left =new JPanel(new BorderLayout()); // to show message in left side
        left.add(panel,BorderLayout.LINE_START);
        vertical.add(left);
        
        f.validate();             // to refresh frame
        
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical,BorderLayout.PAGE_START);
        
        
         }
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
}

