package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Vehicle;
import delivery_simulator.VehicleFactory;

/**
 * Tests VehicleFactory methods.
 * @author Scott Timmel
 */
public class VehicleFactoryTest {

  /**
   * Test method for VehicleFactory createSimulated method.
   */
  @Test
  public void testCreateSimulated() {
    assertTrue(VehicleFactory.getFactory().createSimulated() instanceof Vehicle);
  }

}
