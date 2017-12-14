package numberBaseball;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.PreparedStatement;

public class Ranking {
   
      private static JFrame f;
       private static JButton btn;
      private static JTable table;
      private static JScrollPane scrollPane; 
      public static Connection connection = null;
      public static PreparedStatement stmt = null;
      public static ResultSet rs = null;
      static String column[] = {"Rank","ID","Score"}; 
      private static DefaultTableModel model = new DefaultTableModel(column,0) {
         public boolean isCellEditable(int i, int c) { 
            return false;
         }
      };
      
      
      
   public static Connection getConnection() throws Exception{   
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
   
    public static void select() {
        try {
           Connection connect = getConnection();
           String sql = "SELECT * from userinfo_table order by userSCORE DESC";
           stmt = (PreparedStatement) connect.prepareStatement(sql);
           rs = stmt.executeQuery();
           
              int k = 1;
           while(rs.next()) {
              model.addRow(new Object[] {k, rs.getString("userID"), rs.getString("userSCORE")});
              k++;
              }
        }catch(Exception e) {System.out.println(e);}
        
        finally {
           try {
              rs.close();
              stmt.close();
              
              connection.close();
              
           }catch(Exception e2) {System.out.println(e2);}
        }
        
     }
          
      public static void Ranking() {   
            try {
            
            f = new JFrame();
            table = new JTable(model);
            scrollPane = new JScrollPane(table);
            btn = new JButton("Return");
                         
             select();
             scrollPane.setBounds(30, 40, 200, 300);          
             btn.setBounds(200,600, 100, 50);
            
             table.getTableHeader().setReorderingAllowed(false); // 이동 불가 
             table.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
             
             f.add(btn);
             f.add(scrollPane);
             f.setSize(500, 760);
             f.setVisible(true);
             f.setResizable(false);
             
             btn.addActionListener(listener);
             
         } catch (Exception e) {System.out.println(e);}
      }
      static ActionListener listener = new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
               
               if(e.getActionCommand().equals("Return")) {
                  model.setNumRows(0);
                  f.setVisible(false);
               }
            }
      };
}