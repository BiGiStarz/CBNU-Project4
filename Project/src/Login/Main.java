package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Login.loginClass;
import Login.registerClass;

public class Main extends JFrame {
   
      //버튼
   public static JButton Login = new JButton("Login");
   public static JButton Register = new JButton("Register");
   
      //패널생성
   public static JPanel pane = new JPanel();
   
      //프레임 세팅
   public Main() {
      this.setTitle("Start");
      this.setSize(255, 140);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
      
      Login.setPreferredSize(new Dimension(100, 80));
      Register.setPreferredSize(new Dimension(100, 80));
      
         //패널에 추가
      this.add(pane);
      pane.add(Login);
      pane.add(Register);
      
         //로그인 & 회원가입 액션리스너 활성화
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