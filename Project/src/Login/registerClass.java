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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class registerClass extends JFrame {
   
   public static final JPanel pane = new JPanel();
   public static final JPanel USER = new JPanel();
   public static final JPanel PASS = new JPanel();
   
   public static final JTextField userInput = new JTextField();
   public static final JTextField passInput = new JTextField();
   public static final JLabel userInfo = new JLabel();
   public static final JLabel passInfo = new JLabel();

   public static final JButton reg = new JButton();
   
   public registerClass() {
      this.setTitle("Register");
      this.setLocationRelativeTo(null);
      this.setSize(400, 150);
      this.setResizable(false);
      this.setVisible(true);
      
      reg.setPreferredSize(new Dimension(90, 50));
      userInput.setPreferredSize(new Dimension(90, 20));
      passInput.setPreferredSize(new Dimension(90, 20));
      userInfo.setPreferredSize(new Dimension(35, 20));
      passInfo.setPreferredSize(new Dimension(90, 20));
      
      reg.setText("Register");
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
      pane.add(reg, BorderLayout.CENTER);
      
      reg.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent arg0) {
            try {
               
            Connection connect;
            //String jv_userCode = "";
            String jv_userID = "root";
            String jv_userPW = "1234";
            String databaseName = "userinfodb";      //schema?!
            String url = "jdbc:mysql://localhost:3306/" + databaseName + "?verifyServerCertificate=false&useSSL=true";
            Class.forName("com.mysql.jdbc.Driver");      //드라이버 로드하기
            connect = DriverManager.getConnection(url, jv_userID, jv_userPW);   //Connection 얻어오기
            
            Statement st =connect.createStatement();   //Statement 얻기, 쿼리문 작성하여 적용하기 위한 용도
            ResultSet res = st.executeQuery("SELECT * FROM userinfodb.userinformation WHERE db_userID='" + userInput.getText() + "'");
            System.out.println("Connected");
               if(res.next()) {
                  System.out.println("Connected");
                  if(res.getString("db_userID").equalsIgnoreCase(userInput.getText())) {
                     JOptionPane.showMessageDialog(null, "The username is already registered");
                  } else {
                     String sql = "Insert INTO 'userinfodb'.'userinformation' ('userCode', 'db_userID', 'db_userPW') VALUES ('?', '?', '?')";
                     PreparedStatement resReg = connect.prepareStatement(sql);
                     resReg.setString(1, userInput.getText()); 
                     resReg.setString(2, passInput.getText());
                    
                     resReg.executeUpdate();
                     System.out.println("회원등록이 완료되었습니다.");
                     JOptionPane.showMessageDialog(null, "정상 등록되었습니다.");
                     //resReg.executeQuery();
                     JOptionPane.showMessageDialog(null, "Registered Username: " +  userInput.getText());
                  }
               }
            } catch(Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}