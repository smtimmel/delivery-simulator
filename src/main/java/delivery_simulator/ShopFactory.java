package delivery_simulator;

import java.util.HashSet;

/**
 * Factory which creates Shop objects.
 * @author Scott Timmel
 */
public class ShopFactory implements SimulatedFactory {

  private static ShopFactory shopFac = new ShopFactory();
  private int numProducts = 5;

  private ShopFactory() { }

  /**
   * Creates Shop objects.
   * @return shop object
   */
  public Simulated createSimulated() {
    Product[] inStock = new Product[numProducts];
    HashSet<String> names = new HashSet<>();
    for (int i = 0; i < numProducts; i++) {
      Product addition;
      do {
        addition = (Product)ProductFactory.getFactory().createSimulated();
      } while (names.contains(addition.getName())); //Ensures unique Product sold
      inStock[i] = addition; //Product added to stock
      names.add(addition.getName());
    }
    return new Shop(inStock);
  }

  /**
   * Provides ShopFactory object for use throughout program.
   * @return ShopFactory instance
   */
  public static ShopFactory getFactory() {
    return shopFac;
  }

}
