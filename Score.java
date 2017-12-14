package numberBaseball;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import numberBaseball.NumberBaseBall;
import javax.swing.JOptionPane;
import numberBaseball.registerClass;
import numberBaseball.loginClass;

public class Score {

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
      public void insertScore() {
         
          try {
             Connection connect = getConnection();
             if (loginClass.logincheck == true) {
             String qwe = "UPDATE userinfo_table SET userSCORE = " + NumberBaseBall.AScore + " + userSCORE WHERE userID = '" + loginClass.userInput.getText() +"'" ;
             PreparedStatement stmt = connect.prepareStatement(qwe);
             stmt.executeUpdate();
             } else if(registerClass.registercheck == true) {
                  String qwe = "UPDATE userinfo_table SET userSCORE = " + NumberBaseBall.AScore + " WHERE userID = '" + registerClass.userInput.getText() +"'" ;
                  PreparedStatement stmt = connect.prepareStatement(qwe);
                  System.out.println(stmt);
                  stmt.executeUpdate();
             }
          }catch(Exception e) {System.out.println(e);}
             
          }
   }
