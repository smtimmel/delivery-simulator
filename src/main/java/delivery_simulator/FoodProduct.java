package delivery_simulator;

/**
 * Holds data for food product which can be purchased.
 * @author Scott Timmel
 */
public class FoodProduct extends Product {

  public FoodProduct(String name, String type) {
    super(name, type);
  }

  /**
   * Checks if the food is cold.
   * @return true if food is cold, false otherwise
   */
  public boolean isCold() {
    if (performTask("ColdFood") != null) {
      return true;
    } else {
      return false;
    }
  }

}
