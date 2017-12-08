import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.*;

public class NumberBaseBall {
    // MainŬ���� ����
    public static void main(String[] args) {
    	new Baseball();
      }

}

class Baseball extends JFrame implements KeyListener  {
   
    // �õ��� Ƚ�� �������� ���� (������ Ŭ������ �׼Ǹ����� Ŭ�������� �� �� �ʿ�)
    Label LabNum = new Label("0");
    
    // ���� ���� ����
    int LEVEL;
    
    int score;
    int AScore;
    
    
    //���̵� ���� ��
    final int EASY    = 2;
    final int NORMAL  = 3;
    final int HARD    = 4;
    final int HELL    = 5;
    
    //�õ� Ƚ��
    int easyNum      = 0;
    int normalNum    = 0;
    int hardNum      = 0;
    int hellNum      = 0;
    
    //��� ����
    
    //�ؽ�Ʈ �Ʒ��� ����
    StringBuffer textArea = new StringBuffer();
    int textAreaRow = 0;
 
    // ��ǻ�� �� & ����� �� ����
    StringBuffer comNum  = new StringBuffer();
    StringBuffer userNum = new StringBuffer();
   
    //�г� �κ�
    JPanel panelView     = new JPanel();
    JPanel panelProgress = new JPanel();
    JPanel panelButton     = new JPanel();
    JPanel panelInfo      = new JPanel();


    //�ؽ�ƮField + �ؽ�ƮArea
    JTextField fieldView = new JTextField(9);
    JTextArea areaView     = new JTextArea(10,20); 
    
    //���� â, ��ũ��
    JScrollPane scroll = new JScrollPane(areaView);
   
    //�޴�
    JMenuBar menubar       = new JMenuBar();
    JMenu menu             = new JMenu("���̵�");
    JMenu menuHelp          = new JMenu("Help");
    JMenuItem mItemEasy    = new JMenuItem("Easy");
    JMenuItem mItemNormal    = new JMenuItem("Normal");
    JMenuItem mItemHard    = new JMenuItem("Hard");
    JMenuItem mItemHell    = new JMenuItem("Hell");
    JMenuItem mHelp=new JMenuItem("����");
    JMenuItem mScore=new JMenuItem("Score");
    
  
    //��ư �߰��ϱ�
    JButton button0     = new JButton("0");
    JButton button1     = new JButton("1");
    JButton button2     = new JButton("2");
    JButton button3     = new JButton("3");
    JButton button4     = new JButton("4");
    JButton button5     = new JButton("5");
    JButton button6     = new JButton("6");
    JButton button7     = new JButton("7");
    JButton button8     = new JButton("8");
    JButton button9     = new JButton("9");
    JButton buttonBack    = new JButton("��");
    JButton buttonRandom = new JButton("Rand");
    JButton buttonGo     = new JButton("Go");
    JButton buttonReset    = new JButton("Reset");
    

       
       //������
   public Baseball() {
   
      //���̾ƿ� ����
      panelButton.setLayout(new GridLayout(3,4,7,7));
      panelButton.setPreferredSize(new Dimension(100, 200));
      panelView.setLayout(new GridLayout(1,3,7,7));
      panelView.setPreferredSize(new Dimension(0, 35));
      panelProgress.setLayout(new GridLayout(1,1));
      panelProgress.setPreferredSize(new Dimension(270, 100));
      panelInfo.setLayout(new GridLayout(3, 2));
      panelInfo.setPreferredSize(new Dimension(225, 10));
      setTitle("���ھ߱�����");

      //�ؽ�ƮEdit
      fieldView.setEditable(false);
      areaView.setEditable(false);
      
      //�гο� text, ��ư �߰�
      panelView.add(fieldView);
      //panelView.add(textArea);
      panelView.add(buttonGo);
      panelView.add(buttonReset);
      panelProgress.add(scroll);
         
      //��ư �߰�
      panelButton.add(button7);
      panelButton.add(button8);
      panelButton.add(button9);
      panelButton.add(buttonBack);
      panelButton.add(button4);
      panelButton.add(button5);
      panelButton.add(button6);
      panelButton.add(buttonRandom);
      panelButton.add(button1);
      panelButton.add(button2);
      panelButton.add(button3);
      panelButton.add(button0);
      
      //��ư ��Ʈ ����
      button0.setFont(new Font("���� ���", Font.BOLD, 20));
      button1.setFont(new Font("���� ���", Font.BOLD, 20));
      button2.setFont(new Font("���� ���", Font.BOLD, 20));
      button3.setFont(new Font("���� ���", Font.BOLD, 20));
      button4.setFont(new Font("���� ���", Font.BOLD, 20));
      button5.setFont(new Font("���� ���", Font.BOLD, 20));
      button6.setFont(new Font("���� ���", Font.BOLD, 20));
      button7.setFont(new Font("���� ���", Font.BOLD, 20));
      button8.setFont(new Font("���� ���", Font.BOLD, 20));
      button9.setFont(new Font("���� ���", Font.BOLD, 20));
      buttonBack.setFont(new Font("���� ���", Font.BOLD, 20));
      buttonRandom.setFont(new Font("���� ���", Font.BOLD, 20));
      
    
      //�޴� �κ�
      menubar.add(menu);
      menu.add(mItemEasy);
      menu.addSeparator();
      menu.add(mItemNormal);
      menu.addSeparator();
      menu.add(mItemHard);
      menu.addSeparator();
      menu.add(mItemHell);
      menubar.add(menuHelp);
      menuHelp.add(mHelp);
      menuHelp.add(mScore);
      setJMenuBar(menubar);
         
      //�޴����� ����
      menubar.setBackground(Color.gray);
      
      //Action list
      buttonGo.addActionListener(listener);
      buttonReset.addActionListener(listener);
      button0.addActionListener(listener);
      button1.addActionListener(listener);
      button2.addActionListener(listener);
      button3.addActionListener(listener);
      button4.addActionListener(listener);
      button5.addActionListener(listener);
      button6.addActionListener(listener);
      button7.addActionListener(listener);
      button8.addActionListener(listener);
      button9.addActionListener(listener);
      buttonBack.addActionListener(listener);
      buttonRandom.addActionListener(listener);
   
      menu.addActionListener(listener);
      mItemEasy.addActionListener(listener);
      mItemNormal.addActionListener(listener);
      mItemHard.addActionListener(listener);
      mItemHell.addActionListener(listener);
      menuHelp.addActionListener(listener);
      mHelp.addActionListener(listener);
      mScore.addActionListener(listener);
      
      //Infoâ UI
      Label LabID    = new Label(" ����� �̸� : ");
      Label LabUser = new Label(" BiGi ");
      Label LabTry  = new Label(" �õ��� Ƚ�� : ");
      Label LabRnk  = new Label(" �ְ� ���    : ");
      Label LabRnkN = new Label(" 10 ");
      LabID.setFont(new Font("���� ���", Font.BOLD, 15));
      LabTry.setFont(new Font("���� ���", Font.BOLD, 15));
      LabRnk.setFont(new Font("���� ���", Font.BOLD, 15));
      LabUser.setFont(new Font("���� ���", Font.PLAIN, 13));
      LabNum.setFont(new Font("���� ���", Font.PLAIN, 13));
      LabRnkN.setFont(new Font("���� ���", Font.PLAIN, 13));
      panelInfo.add(LabID);      panelInfo.add(LabUser);    
      panelInfo.add(LabTry);     panelInfo.add(LabNum);   
      panelInfo.add(LabRnk);     panelInfo.add(LabRnkN);
       
      //BoxLayout �����ϱ�
      setLayout(new BorderLayout());
      panelProgress.setBorder(new TitledBorder(new EtchedBorder(), "�������"));
      panelInfo.setBorder(new TitledBorder(new EtchedBorder(), "���� â"));
      
      //�����ӿ� �г� �߰�
      add(panelView, "North");
      add(panelProgress, "West");
      add(panelInfo, "East");
      add(panelButton, "South");
      
      //������ ����
      setBounds(20, 20, 500, 760);
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      panelView.requestFocus();
      panelView.addKeyListener((KeyListener)this);
      // --------------------------------------------------------------------------- //
      
      //�⺻ ���� ����
      LEVEL = NORMAL;
      
      //��ǻ�� �� ����
      comNumCreation();
   }
   //��ư �׼�
   ActionListener listener = new ActionListener() {
   
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
               //���̵� ���� 
            if(e.getActionCommand().equals("Easy")) {
               LEVEL = EASY;
               reset();
               comNumCreation();
               JOptionPane.showMessageDialog(panelProgress, "Easy Mode", "Information", 
                     JOptionPane.INFORMATION_MESSAGE);
            }
            
            if(e.getActionCommand().equals("Normal")) {
               LEVEL = NORMAL;
               reset();
               comNumCreation();
               JOptionPane.showMessageDialog(panelProgress, "Normal Mode", "Information", 
                     JOptionPane.INFORMATION_MESSAGE);
            }
            
            if(e.getActionCommand().equals("Hard")) {
               LEVEL = HARD;
               reset();
               comNumCreation();
               JOptionPane.showMessageDialog(panelProgress, "Hard Mode", "Information", 
                     JOptionPane.INFORMATION_MESSAGE);
            }
            
            if(e.getActionCommand().equals("Hell")) {
               LEVEL = HELL;
               reset();
               comNumCreation();
               JOptionPane.showMessageDialog(panelProgress, "Hell Mode", "Information", 
                       JOptionPane.INFORMATION_MESSAGE);
            }
            
            if(e.getActionCommand().equals("����")) {
                JOptionPane.showMessageDialog(panelProgress, "��Game Rule��\n\n"
                      + "1.�������� ������ ���ڸ� ���߸� �̱�ϴ�.\n"
                      + "2.�ߺ��� ���� ������� �ʽ��ϴ�.\n"
                      + "3.���ڿ� �ڸ��� ������ Strike, ���ڴ� ������ �ڸ��� �ٸ��� Ball\n"
                      + "4.ù ���ڴ� 0�� �� �� �����ϴ�.\n\n\n\n"
                      + "�����̵���\n\n"
                      + "Easy: 2���� ���� ����\n"
                      + "Nomal: 3���� ���� ����\n"
                      + "Hard: 4���� ���� ����\n"
                      + "Hell: 5���� ���� ����\n", 
                        "Game Rule", JOptionPane.INFORMATION_MESSAGE);
             }
            if(e.getActionCommand().equals("Score")) {
                JOptionPane.showMessageDialog(panelProgress, "Your score is "+AScore
                      +"points.\n---try---\n Easy:"+easyNum+"\nNormal: "+normalNum+
                      "\nHard:"+hardNum+"\nHell:"+hellNum,
                        "Score", JOptionPane.INFORMATION_MESSAGE);
             }
            
            if(e.getActionCommand().equals("Go")) {
           
               if(fieldView.getText().isEmpty()) {
                  // �Է� â�� ��� ������ �����޼��� ���
                  JOptionPane.showMessageDialog(panelProgress,"Number is not exists.","Warning",JOptionPane.WARNING_MESSAGE);
               }
               else if(userNum.length()!=LEVEL) {
                  // �Է� â�� ���ڰ� �� �Է� �Ǿ������� �����޼��� ���
                  JOptionPane.showMessageDialog(panelProgress,"Entered is not incorrect","Warning",JOptionPane.WARNING_MESSAGE);
               }
               else if(overlap(userNum.toString())) {
                  // �Է� �� �߿� �ߺ� ���ڰ� ������ �����޼��� ���
                  JOptionPane.showMessageDialog(panelProgress,"Duplicated Number exists!","Warning",JOptionPane.WARNING_MESSAGE);
               }
               
               else {
                  // ���������� �ԷµǾ��ٸ� '�õ��� Ƚ��' ����
                  LabNum.setText(String.valueOf(Integer.valueOf(LabNum.getText()) + 1));
               }
               
               Versus();
               userNum.delete(0, userNum.length());
               fieldView.setText(userNum.toString());
               
            }
            
            if(e.getActionCommand().equals("Reset")) {
               reset();
               comNumCreation();
            }
            
            if(e.getActionCommand().equals("0")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("0");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("1")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("1");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("2")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("2");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("3")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("3");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("4")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("4");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("5")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("5");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("6")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("6");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("7")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("7");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("8")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("8");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("9")) {
               if(userNum.length() < LEVEL) {
                  userNum.append("9");
                  fieldView.setText(userNum.toString());
               }
            }
            
            if(e.getActionCommand().equals("��"))
                  fieldView.setText(userNum.reverse().delete(0, 1).reverse().toString());
            
            if(e.getActionCommand().equals("Rand")) {

                userNum.append((int)(Math.random() * 9 + 1));
                 for (int i = 0; i < LEVEL - 1; i++)
                    userNum.append((int)(Math.random() * 10));
              
                 while(overlap(userNum.toString())) {
                    userNum.append((int)(Math.random() * 9 + 1));
                    for (int i = 0; i < LEVEL - 1; i++) {
                       userNum.append((int)(Math.random() * 10));
                    }
                 }
               
               fieldView.setText(userNum.toString());
            }
            
         }
        
         };
         
   //reset �޼ҵ�
   public void reset() {
       userNum.delete(0, userNum.length());
       comNum.delete(0, comNum.length());
       textArea.delete(0, textArea.length());
       textAreaRow = 0;
       fieldView.setText("");
       areaView.setText("");
       LabNum.setText("0");
   }
         
       //��ǻ�� �� ���� �޼���
         public void comNumCreation() {
            comNum.append((int)(Math.random() * 9 + 1));
            for (int i = 0; i < LEVEL - 1; i++)
               comNum.append((int)(Math.random() * 10));
         
            while(overlap(comNum.toString())) {
               comNum.append((int)(Math.random() * 9 + 1));
               for (int i = 0; i < LEVEL - 1; i++) {
                  comNum.append((int)(Math.random() * 10));
               }
            }
         }
         //��ǻ�� �� ���� ��, �ߺ� ���� �ִ��� Ȯ���ϴ� �޼���
         public boolean overlap(String str) {
            boolean over = false;
            for (int i = 0; i < LEVEL - 1; i++) {
               for (int j = i+1; j < LEVEL; j++) {
                  if (str.charAt(i) == str.charAt(j))
                     over = true;                
                  }
            }
         return over;
         }
        //��ǻ�Ϳ� ����� �� Ȯ�� �޼���
         public void Versus() {
        	 //userNum�� �ߺ��� ���ڰ� ������ ������� �ʴ´�
        	if(overlap(userNum.toString())) {
        		
        	}
        	else {
        	int strike=0;
            int ball=0;
            
            for(int i=0;i<LEVEL;i++) {
               if(comNum.charAt(i)==userNum.charAt(i)) {
                  strike++;
               }
            }
            for(int i=0;i<LEVEL;i++) {
               for(int j=0;j<LEVEL;j++) {
                  if(comNum.charAt(i)==userNum.charAt(j)) {
                     ball++;
                  }
               }
            }
            textAreaRow++;
            
            textArea.append(textAreaRow +". " + strike +"Strike! " + (ball-strike) +"ball.--"+fieldView.getText()+"\n");
            areaView.setText(textArea.toString());
        	
            
         if(strike==LEVEL) {
               switch(LEVEL) {
               case EASY:
                  score=10-textAreaRow;
                  easyNum++;
                  break;
               case NORMAL:
                  score=20-textAreaRow;
                  normalNum++;
                  break;
               case HARD:
                  score=30-textAreaRow;
                  hardNum++;
                  break;
               case HELL:
                  score=40-textAreaRow;
                  hellNum++;
                  break;
               }
               JOptionPane.showMessageDialog(this, strike+"strike!\nGame over. You Win.\n"+score+"points.","Success"
                     ,JOptionPane.INFORMATION_MESSAGE);
               reset();
               comNumCreation();
  
            }
         AScore+=score;
         score=0;
         }
       
         
}
         //Key�� �Է¹ޱ�
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyChar()=='0') {
				if(userNum.length()<LEVEL) {
					userNum.append("0");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='1') {
				if(userNum.length()<LEVEL) {
					userNum.append("1");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='2') {
				if(userNum.length()<LEVEL) {
					userNum.append("2");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='3') {
				if(userNum.length()<LEVEL) {
					userNum.append("3");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='4') {
				if(userNum.length()<LEVEL) {
					userNum.append("4");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='5') {
				if(userNum.length()<LEVEL) {
					userNum.append("5");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='6') {
				if(userNum.length()<LEVEL) {
					userNum.append("6");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='7') {
				if(userNum.length()<LEVEL) { 
					userNum.append("7");
					fieldView.setText(userNum.toString());
					}
			}
			if(e.getKeyChar()=='8') {
				if(userNum.length()<LEVEL) {
				userNum.append("8");
				fieldView.setText(userNum.toString());
				}
			}
			if(e.getKeyChar()=='9') {
				if(userNum.length()<LEVEL) {
					userNum.append("9");
					fieldView.setText(userNum.toString());
					}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
				fieldView.setText(userNum.reverse().delete(0, 1).reverse().toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(fieldView.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(panelProgress, "The number is not exists", "Warning", 
		                     JOptionPane.WARNING_MESSAGE);
				}
				else if(userNum.length()!=LEVEL) {
					 JOptionPane.showMessageDialog(panelProgress, "Entered is not a"+LEVEL+"digit number", "Warning", 
		                     JOptionPane.WARNING_MESSAGE);
				}
				else if(overlap(fieldView.getText())) {
					 JOptionPane.showMessageDialog(panelProgress, "The same number eexists", "Warning", 
		                     JOptionPane.WARNING_MESSAGE);
				}
				else {
					Versus();
					userNum.delete(0, userNum.length());
					fieldView.setText(userNum.toString());
				}
				
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}