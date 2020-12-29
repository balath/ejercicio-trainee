import java.util.*;

public class Exercise {

   private static ArrayList<Vehicle> vehiclesList = new ArrayList<>();

   public static void loadVehicleList() {
      vehiclesList.add(new Car("Peugeot", "206", 200000, 4));
      vehiclesList.add(new Motorbike("Honda", "Titan", 60000, 125));
      vehiclesList.add(new Car("Peugeot", "208", 250000, 5));
      vehiclesList.add(new Motorbike("Yamaha", "YBR", 80500.50, 160));
   }

   private static void printSeparator() {
      System.out.println("=============================");
   }

   public static void printSolution() {
      System.out.println();
      VehicleTextualInfoBuilder vehicleInfoBuilder = VehicleTextualInfoBuilder.getInstance();
      vehiclesList.forEach(vehicle -> System.out.println(vehicleInfoBuilder.allFeaturesToString(vehicle)));
      printSeparator();
      Vehicle moreExpensive = vehiclesList
              .stream()
              .reduce((vehicle1, vehicle2) -> vehicle1.getPrice() > vehicle2.getPrice()? vehicle1 : vehicle2)
              .get();
      Vehicle cheaper = vehiclesList
              .stream()
              .reduce((vehicle1, vehicle2) -> vehicle1.getPrice() < vehicle2.getPrice()? vehicle1 : vehicle2)
              .get();
      Vehicle vehicleWithY = vehiclesList
              .stream()
              .filter(vehicle -> vehicle.getModel().contains("Y"))
              .findFirst()
              .get();
      System.out.format("Vehículo más caro: %s\n", vehicleInfoBuilder.brandAndModelToString(moreExpensive));
      System.out.format("Vehículo más barato: %s\n", vehicleInfoBuilder.brandAndModelToString(cheaper));
      System.out.format("Vehículo que contiene en el modelo la letra 'Y': %s\n",
              vehicleInfoBuilder.brandModelAndPriceToString(vehicleWithY));
      printSeparator();
      vehiclesList.sort(Vehicle::compareTo);
      System.out.println("Vehículos ordenados por precio de mayor a menor:");
      vehiclesList.forEach(vehicle -> System.out.println(vehicleInfoBuilder.brandAndModelToString(vehicle)));
   }

}
