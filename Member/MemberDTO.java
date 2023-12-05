package Member;

public class MemberDTO {
   private int id;
   private String name;
   private int birth;
   private String phone;
   private int point;
   
   public MemberDTO() {
      
   }
   public MemberDTO(int id, String name, int birth, String phone, int point) {
      super();
      this.id = id;
      this.name = name;
      this.birth = birth;
      this.phone = phone;
      this.point = point;
   }
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getBirth() {
      return birth;
   }
   public void setBirth(int birth) {
      this.birth = birth;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public int getPoint() {
      return point;
   }
   public void setPoint(int point) {
      this.point = point;
   }
   
}