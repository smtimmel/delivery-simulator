package delivery_simulator_test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import delivery_simulator.Order;
import delivery_simulator.Product;

/**
 * Tests Order methods.
 * @author Scott Timmel
 */
public class OrderTest {

  private int[] dist = {1, 2, 3};
  HashSet<Product> prod = new HashSet<>();
  Order ord = new Order(1, dist, true, 1, prod);

  /**
   * Test method for Order getId method.
   */
  @Test
  public void testGetId() {
    assertEquals(ord.getId(), 1);
  }

  /**
   * Test method for Order getPurchases method.
   */
  @Test
  public void testGetPurchases() {
    assertEquals(ord.getPurchases(), prod);
  }

  /**
   * Test method for Order getDistance method.
   */
  @Test
  public void testGetDistance() {
    assertEquals(ord.getDistance(), 2);
  }

}
