package Order;

public class OrderdetailDTO {
   private int o_id;
   private int m_id;
   private int size;
   private int h_i;
   private int shot;
   private int num;
   private int price;
   
   
   
   public OrderdetailDTO () {
      
   }
   public OrderdetailDTO(int o_id, int m_id, int size, int h_i, int shot, int num, int price) {
      super();
      this.o_id = o_id;
      this.m_id = m_id;
      this.size = size;
      this.h_i = h_i;
      this.shot = shot;
      this.num = num;
      this.price = price;
   }
   public int getO_id() {
      return o_id;
   }
   public void setO_id(int o_id) {
      this.o_id = o_id;
   }
   public int getM_id() {
      return m_id;
   }
   public void setM_id(int m_id) {
      this.m_id = m_id;
   }
   public int getSize() {
      return size;
   }
   public void setSize(int size) {
      this.size = size;
   }
   public int getH_i() {
      return h_i;
   }
   public void setH_i(int h_i) {
      this.h_i = h_i;
   }
   public int getShot() {
      return shot;
   }
   public void setShot(int shot) {
      this.shot = shot;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   
   
}