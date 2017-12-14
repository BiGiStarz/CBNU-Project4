package numberBaseball;
import javax.swing.*;

import numberBaseball.loginClass;
import numberBaseball.registerClass;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
   
      //버튼
   public static JButton Login = new JButton("Login");
   public static JButton Register = new JButton("Register");
   public static JFrame MainFrame = new JFrame();
      //패널생성
   public static JPanel pane1 = new JPanel();
   
      //프레임 세팅
   public Main() {
      MainFrame.setTitle("Start");
      MainFrame.setSize(255, 140);
      MainFrame.setLocationRelativeTo(null);
      MainFrame.setResizable(false);
      MainFrame.setVisible(true);
      
      Login.setPreferredSize(new Dimension(100, 80));
      Register.setPreferredSize(new Dimension(100, 80));
      
         //패널에 추가
      MainFrame.add(pane1);
      pane1.add(Login);
      pane1.add(Register);
      
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
      //registerClass rM = new registerClass();
      new Main();
      
      
      
      
   }
}