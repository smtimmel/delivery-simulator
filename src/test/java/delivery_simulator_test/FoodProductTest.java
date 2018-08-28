package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.FoodProduct;

/**
 * Tests FoodProduct methods.
 * @author Scott Timmel
 */
public class FoodProductTest {

  /**
   * Test method for FoodProduct, isCold method.
   */
  @Test
  public void testIsCold() {
    FoodProduct food = new FoodProduct("name", "ColdFood");
    assertTrue(food.isCold());
  }

}
