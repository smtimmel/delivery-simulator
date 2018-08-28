package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.OrderFactory;

/**
 * Tests OrderFactory methods.
 * @author Scott Timmel
 */
public class OrderFactoryTest {

  /**
   * Test method for OrderFactory getPurchases method.
   */
  @Test
  public void testGetPurchases() {
    assertTrue(OrderFactory.getFactory().getPurchases().isEmpty());
  }

}
