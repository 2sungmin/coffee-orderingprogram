package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Member.MemberDTO;
import Order.*;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OrderDetail extends JFrame {
   private DefaultTableModel dtm;
   private JPanel contentPane;
   private JLabel[] label = new JLabel[3];
   ArrayList<JButton> btn = new ArrayList<JButton>();
   ArrayList<OrderdetailDTO> list = new ArrayList<OrderdetailDTO>(); 
   OrderDAO dao = new OrderDAO();
   private JTable table;
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               OrderDetail frame = new OrderDetail(0);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    * @param object 
    */
   public OrderDetail(int id) {
      Object[] columnNames =  {"음료명", "사이즈", "가격", "HOT/ICE", "SHOT", "개수"};
      Object[][] rowData = new Object[0][7];
      
      
      dtm = new DefaultTableModel(rowData, columnNames) {
         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };
      list = dao.getOrderDetailList(id);
      for (int i = 0; i < list.size(); i++) {
         OrderdetailDTO dto = new OrderdetailDTO();
         String menu, size, h_i, shot, price, num;

         dto = list.get(i);
         menu = dao.menuIdSelect(dto.getM_id());
         size = sizeString(dto.getSize());
         h_i = h_iString(dto.getH_i());
         shot = shotString(dto.getShot());
         price = Integer.toString(dto.getPrice());
         num = Integer.toString(dto.getNum());

         dtm.addRow(new Object[] {menu, size, price, h_i, shot, num});
      }
      setBounds(100, 100, 566, 632);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(26, 60, 498, 379);
      contentPane.add(scrollPane);
      
      table = new JTable(dtm);
      scrollPane.setViewportView(table);

      
      lblNewLabel = new JLabel("\uC8FC\uBB38\uBC88\uD638");
      lblNewLabel.setBounds(50, 35, 52, 15);
      contentPane.add(lblNewLabel);
      
      lblNewLabel_1 = new JLabel(Integer.toString(id));
      lblNewLabel_1.setBounds(114, 35, 52, 15);
      contentPane.add(lblNewLabel_1);
      setVisible(true);
      setLocationRelativeTo(null);
      setVisible(true);
      
   }


   public String sizeString(int i) {
      String s ="";
      if(i == 1) {
         s = "short";
      }else if(i == 2){
         s = "tall";
      }else if(i == 3) {
         s = "grande";
      }
      return s;
   }
   
   public String h_iString(int i) {
      String s = "";
      if(i == 1) {
         s = "HOT";
      }else if(i == 2){
         s = "ICE";
      }
      return s;
   }
   
   public String shotString(int i) {
      String s = "";
      if(i == 1) {
         s = "YES";
      }else if(i == 2){
         s = "NO";
      }
      return s;
   }
}