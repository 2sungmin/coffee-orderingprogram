package Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Order.OrderDTO;
import Order.OrderdetailDTO;
import DB.DBConnection;

public class SalesDAO {
   Connection conn = DBConnection.getConnection();
   public ArrayList<SalesDTO> getSalesList(){
      String SQL = "select * from tbl_sales";
      SalesDTO dto = null;
      ArrayList<SalesDTO> list = new ArrayList<SalesDTO>(); 
      try {
         Statement stmt = conn.createStatement();

         ResultSet rs = stmt.executeQuery(SQL);
         
         while(rs.next()) {
            dto = new SalesDTO(rs.getString(1), rs.getInt(2));
            list.add(dto);
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return list;   
   }
}