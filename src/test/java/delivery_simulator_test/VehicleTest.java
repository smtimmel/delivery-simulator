package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Vehicle;

/**
 * Tests Vehicle methods.
 * @author Scott Timmel
 */
public class VehicleTest {

  int[] distances = {0, 1, 2};
  Vehicle car = new Vehicle(1, true, distances);

  /**
   * Test method for Vehicle getDistance method.
   */
  @Test
  public void testGetDistance() {
    assertEquals(car.getDistance(1), 1);
  }

  /**
   * Test method for Vehicle getTraveled method.
   */
  @Test
  public void testGetTraveled() {
    assertEquals(car.getTraveled(), 0);
  }

  /**
   * Test method for Vehicle reset method.
   */
  @Test
  public void testReset() {
    int[] dist = {3, 4, 5};
    car.reset(dist);
    assertEquals(car.getDistance(1), 4);
  }

}
