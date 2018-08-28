package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Shop;
import delivery_simulator.ShopFactory;

/**
 * Tests ShopFactory methods.
 * @author Scott Timmel
 */
public class ShopFactoryTest {

  /**
   * Test method for ShopFactory createSimulated method.
   */
  @Test
  public void testCreateSimulated() {
    assertTrue(ShopFactory.getFactory().createSimulated() instanceof Shop);
  }

}
