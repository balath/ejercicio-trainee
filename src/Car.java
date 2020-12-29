public class Car extends Vehicle{

   private int doors;

   public Car(String brand, String model, double price, int doors) {
      super(brand, model, price);
      this.doors = doors;
   }

   public int getDoors() {
      return doors;
   }
}
