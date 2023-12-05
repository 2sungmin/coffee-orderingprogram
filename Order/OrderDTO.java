package Order;

public class OrderDTO {
   private int id;
   private String date;
   private int total;
   
   public OrderDTO() {
      
   }
   public OrderDTO(int id,String date, int total) {
      super();
      this.id = id;
      this.date = date;
      this.total = total;

   }
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getDate() {
      return date;
   }
   public void setDate(String date) {
      this.date = date;
   }
   public int getTotal() {
      return total;
   }
   public void setTotal(int total) {
      this.total = total;
   }
   
   
}