package delivery_simulator;

import java.util.HashSet;

/**
 * Represents desired products, customer info and location.
 * @author Scott Timmel
 */
public class Order extends MessageReceiver {

  private HashSet<Product> purchases;
  private boolean hasBirthday;
  private int shopNum;

  /**
   * Constructor of Order objects.
   * @param id Order id
   * @param distances to each shop
   * @param hasBirthday check if order placer has birthday
   * @param shopNum number of shop ordered from
   * @param purchases Products contained in Order
   */
  public Order(int id, int[] distances, boolean hasBirthday, 
      int shopNum, HashSet<Product> purchases) {
    super(id, distances);
    this.hasBirthday = hasBirthday;
    this.purchases = purchases;
    this.shopNum = shopNum;
  }

  /**
   * Attempts request a driver for order, removes order from notification list if request accepted.
   * @param tick current simulation time
   */
  public void update(int tick) {
    Vehicle available;
    do {
      available = CentralSystem.getCentralSystem().getShops()[shopNum].nextVehicle();
      //check if vehicle available and appropriate for request
      if (available != null && available.performTask(this) != null) {
        for (Shop shop : CentralSystem.getCentralSystem().getShops()) {
          shop.removeVehicle(available); //Selected Vehicle can no longer take requests
        }
        CentralSystem.getCentralSystem().prepRemoval(this);
        if (hasBirthday) {
          System.out.println("Happy Birthday customer!");
        }
        System.out.println();
        break;
      } else if (available == null) {
        //Order request not yet taken
        CentralSystem.getCentralSystem().getShops()[shopNum].resetRanking();
      }
    } while (available != null);
  }

  /**
   * Checks how far vehicle has traveled, allows vehicle to take orders again if order complete.
   * @param task vehicle carrying order
   */
  public <T> Simulated performTask(T task) {
    Vehicle driver = (Vehicle)task;
    System.out.print("Distance traveled to Shop ID " + shopNum + ": ");
    if (driver.getTraveled() < driver.getDistance(shopNum)) { //for when vehicle yet to reach shop
      System.out.println(driver.getTraveled());
      System.out.println("Distance remaining until Shop ID " + shopNum
          + " reached: " + (driver.getDistance(shopNum) - driver.getTraveled()));
      System.out.println("Distance from Shop ID " + shopNum
          + " to order location: " + distances[shopNum]);
      return this;
    } else {
      System.out.println(driver.getDistance(shopNum));
      System.out.println("Shop ID " + shopNum + " reached");
      System.out.println("Distance traveled to order location: "
          + (driver.getTraveled() - driver.getDistance(shopNum)));
      //for when vehicle yet to reach order location
      if ((driver.getTraveled() - driver.getDistance(shopNum)) < distances[shopNum]) {
        System.out.println("Distance until order location reached: "
            + (distances[shopNum] - (driver.getTraveled() - driver.getDistance(shopNum))));
        return this;
      } else { //for when vehicle reaches order destination
        System.out.println("Order location reached, order delivered");
        driver.reset(distances);
        CentralSystem.getCentralSystem().completeOrder(); //order registered as complete
        return null;
      }
    }
  }

  /**
   * Prints products of order.
   */
  public void printProducts() {
    StringBuilder printable = new StringBuilder("Products in order: ");
    for (Product purchase : purchases) {
      printable.append(purchase.getName() + ", ");
    }
    printable.delete(printable.length() - 2, printable.length() - 1);
    System.out.println(printable);
  }

  /**
   * Gets Order id.
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * Gets set of purchases.
   * @return purchases
   */
  public HashSet<Product> getPurchases() {
    return purchases;
  }

  /**
   * Gets distance of order location to shop where purchase made.
   * @return specific distance
   */
  public int getDistance() {
    return distances[shopNum];
  }

}
