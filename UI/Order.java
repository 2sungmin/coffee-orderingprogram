package UI;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Member.MemberDTO;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import Order.*;
public class Order extends JFrame {

   private JPanel contentPane;
   private JTable table;
   private DefaultTableModel dtm;
   int row,col;
   
   ArrayList<OrderDTO> olist = new ArrayList<OrderDTO>(); 
   OrderDAO dao = new OrderDAO();
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Order frame = new Order();
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
   public Order() {
      Object[] columnNames = {"주문번호", "메뉴", "가격"};
      Object[][] rowData = new Object[0][3];
      
      dtm = new DefaultTableModel(rowData, columnNames) {
         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };
      olist = dao.getOrderList();
      for (int i = 0; i < olist.size(); i++) {
         OrderDTO dto = new OrderDTO();
         dto = olist.get(i);
         dtm.addRow(new Object[] {dto.getId(), dto.getDate(), dto.getTotal()});
      }

      setBounds(100, 100, 577, 436);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(22, 41, 521, 317);
      contentPane.add(scrollPane);
      setLocationRelativeTo(null);

      setVisible(true);
      table = new JTable(dtm);
      
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 2) {
               row = table.getSelectedRow();
               col = table.getSelectedColumn();
               OrderDetail d = new OrderDetail(Integer.parseInt(table.getValueAt(row, 0).toString()));
            }
         }
      });
      scrollPane.setViewportView(table);
      
      setVisible(true);
   }
}