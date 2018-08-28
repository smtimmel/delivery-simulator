package delivery_simulator;

import java.util.HashSet;

/**
 * Factory for creating Order objects.
 * @author Scott Timmel
 */
public class OrderFactory extends MessageReceiverFactory {

  private static OrderFactory orderFac = new OrderFactory();
  private String[] birthdayItems = {"Flowers", "Chocolates"};
  private HashSet<Product> purchases = new HashSet<>();

  private OrderFactory() {
    ratio = 5;
  }

  /**
   * Creates new Order object.
   */
  public Simulated createSimulated() {
    prepSimulated(); //Establishes id, distances and condition for object
    Shop[] shops = CentralSystem.getCentralSystem().getShops();
    int shopNum = rand.nextInt(shops.length);
    Shop seller = shops[shopNum];
    if (condition) { //Condition is if client has birthday, if true add birthday items to purchase
      for (String item : birthdayItems) {
        purchases.add((Product)seller.performTask(item));
      }
    }
    int orderSize = rand.nextInt(5) + 1;
    while (purchases.size() < orderSize) { //Random number of unique products added to purchase
      purchases.add((Product)seller.performTask("Any"));
    }
    Order current = new Order(id, distances, condition, shopNum, purchases);
    purchases = new HashSet<>();
    return current;
  }

  /**
   * Gets list of purchases for current object.
   * @return purchases
   */
  public HashSet<Product> getPurchases() {
    return purchases;
  }

  /**
   * Provides OrderFactory instance for use within program.
   * @return single OrderFactory instance
   */
  public static OrderFactory getFactory() {
    return orderFac;
  }

}
