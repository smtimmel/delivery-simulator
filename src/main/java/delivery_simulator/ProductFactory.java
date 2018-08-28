package delivery_simulator;

import java.util.HashMap;
import java.util.Random;

/**
 * Factory for creating Product objects.
 * @author Scott Timmel
 */
public class ProductFactory implements SimulatedFactory {

  private static ProductFactory prodFac = new ProductFactory();
  private String[] keys = {"WarmFood", "ColdFood", "Flowers", "Chocolates"};
  private HashMap<String, String[]> categories = new HashMap<>();
  private Random rand = new Random();
  private int prodIdx;

  private ProductFactory() {
    String[][] values = {{"Burger", "Pizza", "Steak", "Pasta"}, 
      {"TVDinner", "IceCream", "Cake", "FrozenVegetables"},
      {"Roses", "Violets", "Daisy", "Lilly"},
      {"HeartBox", "Herseys", "Lindt", "Godiva"}};
    for (int i = 0;i < keys.length;i++) {
      categories.put(keys[i], values[i]);
    }
  }

  /**
   * Creates Product object.
   * @return new Product
   */
  public Simulated createSimulated() {
    prodIdx++; //Cycle through product types so all are in each store
    if (prodIdx == keys.length) {
      prodIdx = 0;
    }
    if (keys[prodIdx].equals("WarmFood") || keys[prodIdx].equals("ColdFood")) {
      //Food product type selected
      return new FoodProduct(categories.get(keys[prodIdx])[rand.nextInt(4)], keys[prodIdx]);
    } else {
      return new Product(categories.get(keys[prodIdx])[rand.nextInt(4)], keys[prodIdx]);
    }
  }

  /**
   * Provides ProductFactory instance for use throughout program.
   * @return ProductFactory instance
   */
  public static ProductFactory getFactory() {
    return prodFac;
  }

}
