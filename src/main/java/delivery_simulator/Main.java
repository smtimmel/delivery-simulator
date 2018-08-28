package delivery_simulator;

/**
 * Calls the CentralSystem run method.
 * @author Scott Timmel
 */
public class Main {

  /**
   * Starts simulation.
   * @param args not used
   */
  public static void main(String[] args) {
    CentralSystem.getCentralSystem().runSimulation();
  }

}
