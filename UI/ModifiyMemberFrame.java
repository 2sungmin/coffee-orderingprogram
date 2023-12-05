package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Member.MemberDAO;
import Member.MemberDTO;

public class ModifiyMemberFrame extends JFrame {
   private JPanel contentPane;
   private JLabel lblJoin;
   private JButton joinCompleteBtn;
   private JTextField tfName;
   private JTextField tfGen;
   private JTextField tfPhone;
   private MemberDTO dto;
   private JTextField tfBirth;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ModifiyMemberFrame frame = new ModifiyMemberFrame(null);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public ModifiyMemberFrame(MemberDTO dto) {
      this.dto = dto;
      //setBounds(100, 100, 700, 500);
      setSize(500, 500);
      setLocationRelativeTo(null);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      setLocationRelativeTo(null);

      setVisible(true);
      
      lblJoin = new JLabel(Integer.toString(dto.getId())+"님");
      Font f1 = new Font("돋움", Font.BOLD, 20);
      lblJoin.setFont(f1); 
      lblJoin.setBounds(195, 38, 101, 20);
      contentPane.add(lblJoin);
      
      JLabel lblName = new JLabel("이름");
      lblName.setBounds(127, 118, 69, 20);
      contentPane.add(lblName);
      
      JLabel lblbirth = new JLabel("생년월일");
      lblbirth.setBounds(100, 181, 69, 20);
      contentPane.add(lblbirth);
      

      
      JLabel lblPhone = new JLabel("핸드폰 번호");
      lblPhone.setBounds(88, 236, 69, 20);
      contentPane.add(lblPhone);
      
      tfName = new JTextField(dto.getName());
      tfName.setColumns(10);
      tfName.setBounds(169, 111, 186, 35);
      contentPane.add(tfName);
      

      
      joinCompleteBtn = new JButton("수정");
      joinCompleteBtn.setBounds(195, 294, 139, 29);
      contentPane.add(joinCompleteBtn);
      joinCompleteBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            MemberDAO dao = new MemberDAO();
            dto.setName(tfName.getText());
            dto.setBirth(Integer.parseInt(tfBirth.getText()));
            dto.setPhone(tfPhone.getText());
            
            dao.UpdateMember(dto);
            
            JOptionPane.showMessageDialog(null, "회원수정이 완료되었습니다.");
            dispose();
         }
      });
      
      tfPhone = new JTextField(dto.getPhone());
      tfPhone.setColumns(10);
      tfPhone.setBounds(169, 229, 186, 35);
      contentPane.add(tfPhone);
      
      tfBirth = new JTextField(Integer.toString(dto.getBirth()));
      tfBirth.setColumns(10);
      tfBirth.setBounds(169, 174, 186, 35);
      contentPane.add(tfBirth);
      
      setVisible(true);
   }
}