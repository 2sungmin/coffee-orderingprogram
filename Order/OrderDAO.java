package Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConnection;
import Member.MemberDTO;

public class OrderDAO {
   Connection conn = DBConnection.getConnection();
   public ArrayList<OrderDTO> getOrderList(){
      String SQL = "select * from tbl_Order";
      OrderDTO dto = null;
      ArrayList<OrderDTO> list = new ArrayList<OrderDTO>(); 
      try {
         Statement stmt = conn.createStatement();

         ResultSet rs = stmt.executeQuery(SQL);
         
         while(rs.next()) {
            dto = new OrderDTO(rs.getInt(1), rs.getString(2), rs.getInt(3) 
                  );
            list.add(dto);
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return list;   
   }
   public ArrayList<OrderdetailDTO> getOrderDetailList(int o_id){
      String SQL = "select * from tbl_detail_order where o_id = ?";
      OrderdetailDTO dto = null;
      ArrayList<OrderdetailDTO> list = new ArrayList<OrderdetailDTO>(); 
      try {
         
         PreparedStatement pstmt = conn.prepareStatement(SQL);

         pstmt.setInt(1, o_id);

         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            dto = new OrderdetailDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
            list.add(dto);
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return list;   
   }
   
   public void InsertOrder (int total) {
      String SQL = "INSERT INTO tbl_order (date, total) VALUES (NOW(), ?);";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1, total);
         
         pstmt.executeUpdate();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   public void InsertOrderDetail(OrderdetailDTO ddto) {
      String SQL = "insert into tbl_detail_order (o_id, m_id, size, h_i, shot, num, price) values (?,?,?,?,?,?,?)";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         
         pstmt.setInt(1, ddto.getO_id());
         pstmt.setInt(2, ddto.getM_id());
         pstmt.setInt(3, ddto.getSize());
         pstmt.setInt(4, ddto.getH_i());
         pstmt.setInt(5, ddto.getShot());
         pstmt.setInt(6, ddto.getNum());
         pstmt.setInt(7, ddto.getPrice());

         pstmt.executeUpdate();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public int RecentlyOrder() {// 최근 주문 id 확인
      String SQL = "select MAX(id) from tbl_order";
      
      try {
         Statement stmt = conn.createStatement();

         ResultSet rs = stmt.executeQuery(SQL);
         
         if(rs.next()) {
            System.out.println(rs.getInt(1) + "RecentlyOrder");
            return rs.getInt(1);
         }

         
      } catch(Exception e) {
         e.printStackTrace();
      }
      return 0;
   }
   
   public int menuIdSelect(String name) { // 메뉴 아이디 확인
      String SQL = "select id from tbl_menu where name = ?";
      
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);

         pstmt.setString(1, name);
         
         ResultSet rs = pstmt.executeQuery();

         if(rs.next()) {
            System.out.println(rs.getInt(1) + "menuIdSelect");
            return rs.getInt(1);
         }

      } catch(Exception e) {
         e.printStackTrace();
      }
      return 0;
   }
   
   public String menuIdSelect(int id) { // 메뉴 아이디 확인
      String SQL = "select name from tbl_menu where id = ?";
      
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);

         pstmt.setInt(1, id);
         
         ResultSet rs = pstmt.executeQuery();

         if(rs.next()) {

            return rs.getString(1);
         }

      } catch(Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
}

  