public class Vehicle implements Comparable<Vehicle> {

   private String brand;
   private String model;
   private double price;

   public Vehicle(String brand, String model, double price) {
      this.brand = brand;
      this.model = model;
      this.price = price;
   }

   public String getBrand() {
      return brand;
   }

   public String getModel() {
      return model;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   @Override
   public int compareTo(Vehicle other) {
      if (this.price > other.price) return -1;
      if (this.price < other.price) return 1;
      return 0;
   }
}
