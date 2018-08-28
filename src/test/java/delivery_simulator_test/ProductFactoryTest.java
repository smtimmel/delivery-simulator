package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Product;
import delivery_simulator.ProductFactory;

/**
 * Tests ProductFactory methods.
 * @author smtse
 */
public class ProductFactoryTest {

  /**
   * Test method for ProductFactory createSimulated method.
   */
  @Test
  public void testCreateSimulated() {
    assertTrue(ProductFactory.getFactory().createSimulated() instanceof Product);
  }

}
