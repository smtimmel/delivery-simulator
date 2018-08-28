package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Product;

/**
 * Tests Product methods.
 * @author Scott Timmel
 */
public class ProductTest {

  Product prod = new Product("name", "type");

  /**
   * Test method for Product getName method.
   */
  @Test
  public void testGetName() {
    assertEquals(prod.getName(), "name");
  }

  /**
   * Test method for Product performTask method.
   */
  @Test
  public void testPerformTask() {
    assertEquals(prod.performTask("type"), prod);
  }

}
