public class Motorbike extends Vehicle {

   private int displacement;

   public Motorbike(String brand, String model, double price, int displacement) {
      super(brand, model, price);
      this.displacement = displacement;
   }

   public int getDisplacement() {
      return displacement;
   }
}
