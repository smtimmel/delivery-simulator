package delivery_simulator;

/**
 * Factory which creates Vehicle objects.
 * @author Scott Timmel
 */
public class VehicleFactory extends MessageReceiverFactory {

  private static VehicleFactory vehFac = new VehicleFactory();

  private VehicleFactory() {
    ratio = 4;
  }

  /**
   * creates Vehicle object.
   */
  public Simulated createSimulated() {
    prepSimulated();
    return new Vehicle(id, condition, distances);
  }

  /**
   * Provides VehicleFactory instance for use in program.
   * @return VehicleFactory instance
   */
  public static VehicleFactory getFactory() {
    return vehFac;
  }
}
