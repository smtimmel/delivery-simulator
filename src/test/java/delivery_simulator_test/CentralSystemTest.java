package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.CentralSystem;

/**
 * Tests CentralSystem methods.
 * @author Scott Timmel
 */
public class CentralSystemTest {

  /**
   * Test method for CentralSystem, getShops method.
   */
  @Test
  public void testGetShops() {
    assertEquals(CentralSystem.getCentralSystem().getShops().length, 5);
  }

  /**
   * Test method for {@link delivery_simulator_test.CentralSystem#getNumVehicles()}.
   */
  @Test
  public void testGetNumVehicles() {
    assertEquals(CentralSystem.getCentralSystem().getNumVehicles(), 10);
  }

}
