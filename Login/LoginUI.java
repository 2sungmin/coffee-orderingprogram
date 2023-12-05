package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UI.MainUI;

public class LoginUI extends JFrame {

   private JPanel contentPane;
   private JTextField tfUsername;
   private JButton loginBtn;
   private JPasswordField tfPassword;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               LoginUI frame = new LoginUI();
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   public LoginUI() {
     Image img = new ImageIcon("C:\\Users\\SAMSUNG\\eclipse-workspace\\CafeProgramManager\\Image\\Login.png").getImage();
     img = img.getScaledInstance(2000, 900, Image.SCALE_DEFAULT);
     ImageIcon icon = new ImageIcon(img);
     //setBounds(100, 100, 700, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1400, 900);
      setLocationRelativeTo(null);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      tfUsername = new JTextField();
      tfUsername.setFont(new Font("굴림", Font.BOLD, 16));
      tfUsername.setBounds(485, 404, 350, 25);
      tfUsername.setBorder(null);
      contentPane.add(tfUsername);
      tfUsername.setColumns(10);
      
      loginBtn = new JButton("로그인");
      loginBtn.setBackground(Color.ORANGE);
      loginBtn.setBounds(764, 520, 177, 38);
      // 배경을 투명하게 설정
     // 테두리를 그리지 않도록 설정
      contentPane.add(loginBtn);
      loginBtn.addActionListener(event -> {
         
        String id = "8team";
        String pa = "1234";

        if(id.equals(tfUsername.getText())&&pa.equals(new String(tfPassword.getPassword()))) {
           JOptionPane.showMessageDialog(null, "로그인이 완료되었습니다.");
         MainUI m  = new MainUI();
           dispose();
        }
          
      });
      

      JLabel lblNewLabel = new JLabel(icon);
      lblNewLabel.setBounds(0, 0, 1394, 900);
      contentPane.add(lblNewLabel);
      
      tfPassword = new JPasswordField();
      tfPassword.setFont(new Font("굴림", Font.BOLD, 16));
      tfPassword.setBounds(485, 475, 399, 25);
      tfPassword.setBorder(null);
      contentPane.add(tfPassword);
      
      setVisible(true);
      
      //로그인 액션
      
   }
}