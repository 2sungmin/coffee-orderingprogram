package Sales;

public class SalesDTO {
   private String Date;
   private int total;
   
   public SalesDTO() {
   }
   public SalesDTO(String Date, int total) {
      super();
      this.Date = Date;
      this.total = total;
   }
   public String getDate() {
      return Date;
   }
   public void setDate(String date) {
      Date = date;
   }
   public int getTotal() {
      return total;
   }
   public void setTotal(int total) {
      this.total = total;
   }
}