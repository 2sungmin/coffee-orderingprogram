package Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DB.DBConnection;

public class MemberDAO {
   Connection conn = DBConnection.getConnection();
   
   public ArrayList<MemberDTO> getMemberList(){
      String SQL = "select * from tbl_member";
      MemberDTO dto = null;
      ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
      try {
         Statement stmt = conn.createStatement();

         ResultSet rs = stmt.executeQuery(SQL);
         
         while(rs.next()) {
            dto = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
            list.add(dto);
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   public void UpdateMember(MemberDTO dto) {
      String SQL = "UPDATE tbl_member SET name = ?, birth = ?, phone = ? where id = ?";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, dto.getName());
         pstmt.setInt(2, dto.getBirth());
         pstmt.setString(3, dto.getPhone());
         pstmt.setInt(4, dto.getId());
         
         pstmt.executeUpdate();
         
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public void DeleteMember(String id) {
      String SQL = "delete from tbl_member where id = ?";
   
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, id);
         
         pstmt.executeUpdate();
         
         
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public int RegistrationMember(MemberDTO dto) {
      String SQL = "insert into tbl_member (name, birth, phone) values (?, ?, ?)";
      
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, dto.getName());
         pstmt.setInt(2, dto.getBirth());
         pstmt.setString(3, dto.getPhone());
         
         int rs = pstmt.executeUpdate();
         if(rs != 0) {
            return 1;
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return 0;
   }
   public void pointInsert(int point, String phone) {
      String SQL = "UPDATE tbl_member SET point = point + ? where phone = ? or id = ?";
      
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1, point);
         pstmt.setString(2, phone);
         pstmt.setInt(3, Integer.parseInt(phone));

         pstmt.executeUpdate();
         
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   public int phoneCheck(String phone) {
      
      String SQL = "select * from tbl_member where phone = ?";
      
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);

         pstmt.setString(1, phone);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.next()) {
            System.out.println("회원정보있음");
            return 1;
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return 0;
   }

}