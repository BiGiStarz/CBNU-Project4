package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Login.loginClass;
import Login.registerClass;

public class Main extends JFrame {
   
      //��ư
   public static JButton Login = new JButton("Login");
   public static JButton Register = new JButton("Register");
   
      //�гλ���
   public static JPanel pane = new JPanel();
   
      //������ ����
   public Main() {
      this.setTitle("Start");
      this.setSize(255, 140);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
      
      Login.setPreferredSize(new Dimension(100, 80));
      Register.setPreferredSize(new Dimension(100, 80));
      
         //�гο� �߰�
      this.add(pane);
      pane.add(Login);
      pane.add(Register);
      
         //�α��� & ȸ������ �׼Ǹ����� Ȱ��ȭ
      Login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            loginClass lC = new loginClass();
         }
      });
      
      Register.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            registerClass rC = new registerClass();
         }
      });
   }
   
   public static void main (String args[]) {
      new Main();
   }
}