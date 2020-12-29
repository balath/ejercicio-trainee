import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class VehicleTextualInfoBuilder {

   private static VehicleTextualInfoBuilder vehicleInfoBuilder;
   DecimalFormat decimalFormat;

   private VehicleTextualInfoBuilder(){
      DecimalFormatSymbols separators = new DecimalFormatSymbols();
      separators.setDecimalSeparator(',');
      separators.setGroupingSeparator('.');
      decimalFormat = new DecimalFormat("$###,###.00",separators);
   };

   public static VehicleTextualInfoBuilder getInstance(){
      if (vehicleInfoBuilder == null) vehicleInfoBuilder = new VehicleTextualInfoBuilder();
      return vehicleInfoBuilder;
   }

   public String allFeaturesToString(Vehicle vehicle){
      StringBuilder output = new StringBuilder()
              .append("Marca: ").append(vehicle.getBrand())
              .append(" // Modelo: ").append(vehicle.getModel())
              .append(" // ");

      if (vehicle instanceof Car) {
         output.append("Puertas: ").append(((Car) vehicle).getDoors());
      } else if (vehicle instanceof Motorbike) {
         output.append("Cilindrada: ").append(((Motorbike) vehicle).getDisplacement()).append("cc");
      }

      output.append(" // Precio: ").append(decimalFormat.format(vehicle.getPrice()));

      return output.toString();
   }

   public String brandAndModelToString(Vehicle vehicle){
      return new StringBuilder()
              .append(vehicle.getBrand())
              .append(" ")
              .append(vehicle.getModel())
              .toString();
   }

   public String brandModelAndPriceToString(Vehicle vehicle){
      return new StringBuilder()
              .append(brandAndModelToString(vehicle))
              .append(" ")
              .append(decimalFormat.format(vehicle.getPrice()))
              .toString();
   }


}
