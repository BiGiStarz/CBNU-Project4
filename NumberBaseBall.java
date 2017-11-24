import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

class NumberBaseBall extends JFrame {
   //�г� �κ�
	 JPanel panelView = new JPanel();
	 JPanel panelProgress = new JPanel();
	 JPanel panelButton = new JPanel();
	 JPanel panelInfo = new JPanel();
	 
	 //�ؽ�ƮField + �ؽ�ƮArea
	 JTextField fieldView = new JTextField(8);
	 JTextArea areaView = new JTextArea(10,20);

	//���� â, ��ũ��
	JScrollPane scroll = new JScrollPane(areaView);

   
	   	//��ư �߰��ϱ�
         JButton button0 = new JButton("0");
         JButton button1 = new JButton("1");
         JButton button2 = new JButton("2");
         JButton button3 = new JButton("3");
         JButton button4 = new JButton("4");
         JButton button5 = new JButton("5");
         JButton button6 = new JButton("6");
         JButton button7 = new JButton("7");
         JButton button8 = new JButton("8");
         JButton button9 = new JButton("9");
         JButton buttonBack = new JButton("��");
         JButton buttonRandom = new JButton("Rand");
         JButton buttonGo = new JButton("Go");
         JButton buttonReset = new JButton("Reset");
         
   public NumberBaseBall() {
      //���̾ƿ� ����
      panelButton.setLayout(new GridLayout(3, 4, 5, 5));
      panelView.setLayout(new GridLayout(1,1));
      panelProgress.setLayout(new GridLayout(1,1));
      panelInfo.setLayout(new GridLayout(1,1));

      setTitle("���ھ߱�����");

      //�ؽ�ƮEdit
      fieldView.setEditable(false);
      areaView.setEditable(false);
      
      //�гο� txt, ��ư �߰�
      panelView.add(fieldView);
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
      
      //�����ӿ� �г� �߰�
    
      //add(panelView, "North");
      add(panelProgress, "West");
      add(panelInfo, "East");
      add(panelButton, "South");

      
      //������ ����
      setBounds(500,500, 600,800);
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      
      //�޴� �κ�
      JMenuBar menubar =new JMenuBar();
      JMenu menu=new JMenu("���̵�");
      JMenu menuHelp =new JMenu("help");
      JMenuItem mItemEasy=new JMenuItem("Easy");
      JMenuItem mItemNormal=new JMenuItem("Nomal");
      JMenuItem mItemHard=new JMenuItem("Hard");
      JMenuItem mItemHell=new JMenuItem("Hell");
      menubar.add(menu);
      menubar.add(menuHelp);
      menu.add(mItemEasy);
      menu.add(mItemNormal);
      menu.add(mItemHard);
      menu.add(mItemHell);
      setJMenuBar(menubar);
      
   }
   
    public static void main(String[] args) {
         new NumberBaseBall();
      }
}