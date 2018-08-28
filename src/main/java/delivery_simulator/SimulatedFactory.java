package delivery_simulator;

/**
 * Interface for factories which generate Simulated objects.
 * @author Scott Timmel
 */
public interface SimulatedFactory {

  /**
   * Creates Simulated object.
   * @return Simulated
   */
  public Simulated createSimulated();

}