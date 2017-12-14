package numberBaseball;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;

public class loginClass extends JFrame {
   
   public static final JFrame loginF = new JFrame();
   public static final JPanel pane = new JPanel();
   public static final JPanel USER = new JPanel();
   public static final JPanel PASS = new JPanel();
   
   public static final JTextField userInput = new JTextField();
   public static final JPasswordField passInput = new JPasswordField();
   public static final JLabel userInfo = new JLabel();
   public static final JLabel passInfo = new JLabel();
   public static final JButton logon = new JButton();
   
   public static boolean logincheck = false;
   
   public loginClass() {      
      loginF.setTitle("Login");
      loginF.setLocationRelativeTo(null);
      loginF.setSize(400, 150);
      loginF.setResizable(false);
      loginF.setVisible(true);
      
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
      
      loginF.add(USER);
      USER.add(userInfo);
      USER.add(userInput);
      loginF.add(PASS);
      PASS.add(passInfo);
      PASS.add(passInput);
      
      loginF.add(pane);
      pane.add(USER, BorderLayout.WEST);
      pane.add(PASS, BorderLayout.WEST);
      pane.add(logon, BorderLayout.CENTER);
      
      logon.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent arg0) {
            try {
            Connection connect;
            String jv_userID = "root";
            String jv_userPW = "1234";
            String databaseName = "useinfo_schema";      //schema?!
            String url = "jdbc:mysql://localhost:3306/" + databaseName + "?verifyServerCertificate=false&useSSL=true";
            Class.forName("com.mysql.jdbc.Driver");      //드라이버 로드
            connect = DriverManager.getConnection(url, jv_userID, jv_userPW);
            Statement st =connect.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM userinfo_table WHERE userID='" +userInput.getText() + "' AND userPW='"+passInput.getText()+"'");   //
               if(res.next()) {
                  JOptionPane.showMessageDialog(null, "You have Logged in!");
                  loginF.setVisible(false);
                    Main.MainFrame.setVisible(false);
                    logincheck = true;
                     if(logincheck == true) {
                        new NumberBaseBall();
                     }
               } else {
                  JOptionPane.showMessageDialog(null, "Wrong ID or PW");
               }
            } catch(Exception e) {System.out.println(e);}
         }

      });
   }
}