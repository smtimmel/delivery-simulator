package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.Product;
import delivery_simulator.Shop;

/**
 * Tests Shop methods.
 * @author Scott Timmel
 */
public class ShopTest {

  Product prod1 = new Product("name1", "type1");
  Product prod2 = new Product("name2", "type2");
  Product[] prods = {prod1, prod2};
  Shop store = new Shop(prods);

  /**
   * Test method for Shop performTask method.
   */
  @Test
  public void testPerformTask() {
    assertEquals(store.performTask("type1"), prod1);
  }

  /**
   * Test method for Shop nextVehicle method.
   */
  @Test
  public void testNextVehicle() {
    assertEquals(store.nextVehicle(), null);
  }

}
