package UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Sales.SalesDAO;
import Sales.SalesDTO;

public class Sales extends JFrame {

   private JPanel contentPane;
   private JTable table;
   private DefaultTableModel dtm;
   ArrayList<SalesDTO> list = new ArrayList<SalesDTO>();
   SalesDAO dao = new SalesDAO();
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               
               Sales frame = new Sales();
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
   public Sales() {
      Object[] columnNames = {"주문 날찌", "매출 금액"};
      Object[][] rowData = new Object[0][2];
      
      dtm = new DefaultTableModel(rowData, columnNames) {
         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };
      
      list = dao.getSalesList();
      for (int i = 0; i < list.size(); i++) {
         SalesDTO dto = new SalesDTO();
         dto = list.get(i);
         dtm.addRow(new Object[] {dto.getDate(), dto.getTotal()});
      }
   
      setBounds(100, 100, 448, 477);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(26, 60, 379, 350);
      contentPane.add(scrollPane);
      
      table = new JTable(dtm);
      table.setBounds(29, 40, 374, 365);
      scrollPane.setViewportView(table);
      
      JLabel lblNewLabel = new JLabel("매출관리");
      lblNewLabel.setBounds(189, 10, 89, 25);
      contentPane.add(lblNewLabel);
      
      setVisible(true);
      setLocationRelativeTo(null);

      setVisible(true);
   }
}
