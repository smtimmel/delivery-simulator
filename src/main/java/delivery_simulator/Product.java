package delivery_simulator;

/**
 * Class specifies a product which can be purchased.
 * @author Scott Timmel
 */
public class Product implements Simulated {

  private String name;
  private String type;

  public Product(String name, String type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Gets product name.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Checks if product type matches given type.
   * @param task given product type
   * @return this product if types match, null otherwise
   */
  public <T> Simulated performTask(T task) {
    if (task.equals(type)) {
      return this;
    } else {
      return null;
    }
  }
}
