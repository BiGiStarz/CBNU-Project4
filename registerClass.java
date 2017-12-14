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

import numberBaseball.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;

public class registerClass extends JFrame {
   
   public static final JPanel pane = new JPanel();
   public static final JPanel USER = new JPanel();
   public static final JPanel PASS = new JPanel();
   
   public static final JTextField userInput = new JTextField();
   public static final JPasswordField passInput = new JPasswordField();
   public static final JLabel userInfo = new JLabel();
   public static final JLabel passInfo = new JLabel();
   
   public static boolean registercheck;
   
   Statement stmt;

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
               createTable();
               insertInfo();
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }            
         } 
      }); 
      
      
   }
   
   public Connection getConnection() throws Exception{   
         try {
               String jv_userID = "root";
               String jv_userPW = "1234";
               String databaseName = "useinfo_schema";      //schema?!
               String driver = "com.mysql.jdbc.Driver";
               
               String url = "jdbc:mysql://localhost:3306/" + databaseName + "?verifyServerCertificate=false&useSSL=true";
               Class.forName(driver);
               
               Connection connection = DriverManager.getConnection(url, jv_userID, jv_userPW);
               System.out.println("Connected");
               return connection;
            } catch(Exception e) {System.out.println(e);}
         return null;
         
         }
         
      public void createTable() throws Exception {
         try {
            Connection Connect = getConnection();
            System.out.println("Connected?");
            String sql = "CREATE TABLE IF NOT EXISTS `useinfo_schema`.`userinfo_table` ("
                  + "`userCODE` INT NOT NULL AUTO_INCREMENT, "
                  + "`userID` VARCHAR(45) NULL, "
                  + "`userPW` VARCHAR(45) NULL, "
                  + "`userSCORE` INT(11) NULL, "
                  + "PRIMARY KEY (`userCODE`))";
                  
            PreparedStatement create = Connect.prepareStatement(sql);
            create.executeUpdate();
            
            System.out.println("createT_Done?");
         }catch(Exception e) {System.out.println(e);}
      }
       
      public void insertInfo() throws Exception {

            try {
               Connection connect = getConnection();
               String qwe = "INSERT INTO `useinfo_schema`.`userinfo_table`"
                         + "(userID, userPW) VALUES (?, ?)";
               
               PreparedStatement stmt = connect.prepareStatement(qwe); 
               stmt.setString(1, userInput.getText()); 
               stmt.setString(2, passInput.getText());
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "Sucessfully registered!");
               System.out.println("register_Done?");
               this.setVisible(false);
               Main.MainFrame.setVisible(false);
               registercheck = true;
               if(registercheck == true) {
                  new NumberBaseBall();
                  
               }
            }catch(Exception e) {System.out.println(e);}
            
         }
}