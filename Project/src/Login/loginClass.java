package Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;

public class loginClass extends JFrame {
   
   public static final JPanel pane = new JPanel();
   public static final JPanel USER = new JPanel();
   public static final JPanel PASS = new JPanel();
   
   public static final JTextField userInput = new JTextField();
   public static final JTextField passInput = new JTextField();
   public static final JLabel userInfo = new JLabel();
   public static final JLabel passInfo = new JLabel();
   public static final JButton logon = new JButton();
   
   public loginClass() {      
      this.setTitle("Login");
      this.setLocationRelativeTo(null);
      this.setSize(400, 150);
      this.setResizable(false);
      this.setVisible(true);
      
      logon.setPreferredSize(new Dimension(90, 50));
      logon.setText("Login");
      
      userInput.setPreferredSize(new Dimension(90, 20));
      passInput.setPreferredSize(new Dimension(90, 20));
      userInfo.setPreferredSize(new Dimension(35, 20));
      passInfo.setPreferredSize(new Dimension(90, 20));
      userInput.setToolTipText("Username");
      passInput.setToolTipText("Password");
      userInfo.setText("ID");
      passInfo.setText("PASSWORD");
      
      this.add(USER);
      USER.add(userInfo);
      USER.add(userInput);
      this.add(PASS);
      PASS.add(passInfo);
      PASS.add(passInput);
      
      this.add(pane);
      pane.add(USER, BorderLayout.WEST);
      pane.add(PASS, BorderLayout.WEST);
      pane.add(logon, BorderLayout.CENTER);
      
      logon.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent arg0) {
            try {
            Connection connect;
            String jv_userCode = "";
            String jv_userID = "root";
            String jv_userPW = "1234";
            String databaseName = "userinfodb";      //schema?!
            String url = "jdbc:mysql://localhost:3306/" + databaseName + "?verifyServerCertificate=false&useSSL=true";
            Class.forName("com.mysql.jdbc.Driver");      //드라이버 로드
            connect = DriverManager.getConnection(url, jv_userID, jv_userPW);
            Statement st =connect.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM userinformation WHERE db_userID='" +userInput.getText() + "' AND db_userPW='"+passInput.getText()+"'");   //
            if(res.next()) {
               JOptionPane.showMessageDialog(null, "You have Logged in!");
            } else {
               JOptionPane.showMessageDialog(null, "Wrong ID or PW");
            }
            } catch(Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}