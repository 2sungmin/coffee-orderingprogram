package UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Member.*;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class Member extends JFrame {
   private JPanel contentPane;
   private JTable table;
   private DefaultTableModel dtm;
   private JScrollPane scrollPane ;
   private JButton btnNewButton;
   int row,col;
   
   MemberDAO dao = new MemberDAO();
   
   ArrayList<MemberDTO> mlist = new ArrayList<MemberDTO>(); 
   private JButton btnNewButton_1;
   private JButton btnNewButton_2;
   private JButton btnNewButton_3;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {   
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Member frame = new Member();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   /**
    * Create the frame.
    */
   public Member() {
      Object[] columnNames = {"아이디", "이름", "생년월일", " 전화번호", "포인트"};
      Object[][] rowData = new Object[0][5];
      
      setBounds(100, 100, 450, 300);
      setSize(700, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      setLocationRelativeTo(null);

      setVisible(true);

      dtm = new DefaultTableModel(rowData, columnNames) {
         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };
      mlist = dao.getMemberList();
      for (int i = 0; i < mlist.size(); i++) {
         MemberDTO dto = new MemberDTO();
         dto = mlist.get(i);
         dtm.addRow(new Object[] {dto.getId(), dto.getName(), dto.getBirth(), dto.getPhone(), dto.getPoint()});
      }

      table = new JTable(dtm);
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 1) {
               row = table.getSelectedRow();
               col = table.getSelectedColumn();
               System.out.println(table.getValueAt(row, 0));
   
            }
         }
      });
      
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(50, 47, 586, 211);
      contentPane.add(scrollPane);
      
      JButton btnNewButton = new JButton("회원 등록");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 InsertMemberFrame I = new InsertMemberFrame();
         }
      });
      btnNewButton.setBounds(249, 280, 121, 47);
      contentPane.add(btnNewButton);
      
      btnNewButton_1 = new JButton("회원 수정");
      btnNewButton_1.setBounds(382, 280, 121, 47);
      contentPane.add(btnNewButton_1);
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String test = table.getValueAt(row, 1).toString();
            
            MemberDTO dto1 = new MemberDTO();
            
            dto1.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
            dto1.setName(table.getValueAt(row, 1).toString());
            dto1.setBirth(Integer.parseInt(table.getValueAt(row, 2).toString()));
            dto1.setPhone(table.getValueAt(row, 3).toString());
            
            ModifiyMemberFrame m = new ModifiyMemberFrame(dto1);

         }
      });
      btnNewButton_2 = new JButton("회원 삭제");
      btnNewButton_2.setBounds(515, 280, 121, 47);
      contentPane.add(btnNewButton_2);
      
      
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dao.DeleteMember(table.getValueAt(row, 0).toString()); //DB 테이블 데이터삭제
            dtm.removeRow(row); //JTABLE에 행 삭제
         }
      });
      
      btnNewButton_3 = new JButton("Reset");
      btnNewButton_3.setBounds(12, 10, 95, 23);
      contentPane.add(btnNewButton_3);
      btnNewButton_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dtm.setNumRows(0);
            mlist.clear();
            mlist = dao.getMemberList();   
            System.out.println(mlist.size());
            for (int i = 0; i < mlist.size(); i++) {
               MemberDTO dto = new MemberDTO();
               dto = mlist.get(i);
               dtm.addRow(new Object[] {dto.getId(), dto.getName(), dto.getBirth(), dto.getPhone()});
            }
         }
      });
      
      setVisible(true);
   }
}