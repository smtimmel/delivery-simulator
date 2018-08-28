package delivery_simulator;

import java.util.HashSet;

/**
 * Class represents vehicles in system and has methods to map their driving status.
 * @author Scott Timmel
 */
public class Vehicle extends MessageReceiver {

  private int distTravel = 0;
  private boolean needReset = true;
  private boolean hasFreezer;
  private Order active = null;

  /**
   * Constructor for Vehicle object.
   * @param id of Vehicle
   * @param hasFreezer checks if Vehicle has freezer
   * @param distances of Vehicle to shops
   */
  public Vehicle(int id, boolean hasFreezer, int[] distances) {
    super(id, distances);
    this.id = id;
    this.hasFreezer = hasFreezer;
  }

  /**
   * Updates Vehicles progress in current order delivery or if vehicle is awaiting an order.
   * @param tick current time
   */
  public void update(int tick) {
    System.out.print("Vehicle ID: " + id);
    if (hasFreezer) {
      System.out.println(" - Refrigerated");
    } else {
      System.out.println(" - Not Refrigerated");
    }
    if (active != null) {
      distTravel++;
      System.out.println("Current Order ID: " + active.getId());
      active.printProducts();
      active = (Order)active.performTask(this); //Checks travel distance or if order is complete
    } else {
      System.out.println("Waiting for order");
    }
    if (needReset) { //Vehicle newly available, allowed to receive requests
      for (Shop location : CentralSystem.getCentralSystem().getShops()) {
        location.addVehicle(this);
      }
      needReset = false;
    }
    System.out.println();
  }

  /**
   * Gets distance to a specific shop.
   * @param shopId specific shop
   * @return distance to shop
   */
  public int getDistance(int shopId) {
    return distances[shopId];
  }

  /**
   * Gets distance traveled by vehicle for active order.
   * @return distance traveled
   */
  public int getTraveled() {
    return distTravel;
  }

  /**
   * Sets distances to all shops to provided distances, traveled distance reset.
   * @param distances from shops
   */
  public void reset(int[] distances) {
    distTravel = 0;
    this.distances = distances;
    needReset = true; //Update needed in Shop objects
  }

  /**
   * Ensures Vehicle is allowed to pick up order.
   * @param task Order checked 
   * @return this Vehicle is pickup allowed, null otherwise
   */
  public <T> Simulated performTask(T task) {
    HashSet<Product> productCheck = ((Order)task).getPurchases();
    //Checks if food purchase can not be transported by this Vehicle
    if (productCheck.stream().anyMatch(p -> p instanceof FoodProduct
        && !checkFood((FoodProduct)p, (Order)task))) {
      return null;
    }
    System.out.println("Order ID " + ((Order)task).getId()
        + " has been picked up by Vehicle ID " + id);
    active = (Order)task; //Sets Order as active Order
    return this;
  }

  /**
   * Checks is food product can be transported by Vehicle.
   * @param food specific food product
   * @param check Order containing purchase
   * @return true if food can be transported, false otherwise
   */
  private boolean checkFood(FoodProduct food, Order check) {
    //checks if food cold, and for far distance or high traffic event
    if (food.isCold() && !hasFreezer && ((check.getDistance() > 2)
        || TrafficTimer.getTrafficTimer().performTask("high") != null)) { 
      return false;
    } else {
      return true;
    }
  }

}
