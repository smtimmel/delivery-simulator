package delivery_simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Represents store selling specific Products and having trackings of
 * distances from registered vehicles.
 * @author Scott Timmel
 */
public class Shop implements Simulated {

  private int id;
  private ArrayList<Product> inStock;
  private PriorityQueue<Vehicle> vehicleRankings = new PriorityQueue<>(CentralSystem
      .getCentralSystem().getNumVehicles(), (Comparator<Vehicle>)((v1,v2) -> {
        if (v1.getDistance(id) < v2.getDistance(id)) {
          return -1;
        }
        if (v1.getDistance(id) > v2.getDistance(id)) {
          return 1;
        }
        return 0;
      }));
  private HashSet<Vehicle> tempRemoved = new HashSet<>();

  public Shop(Product[] inStock) {
    this.inStock = new ArrayList<>(inStock.length);
    this.inStock.addAll(Arrays.asList(inStock));
  }

  /**
   * Gets unique or specific types of Product objects sold at store.
   * @param task Product type desired
   * @return desired Product
   */
  public <T> Simulated performTask(T task) {
    if (task.equals("Any")) {
      return inStock.stream().filter(p -> !OrderFactory.getFactory().getPurchases()
        .contains(p)).findAny().get();
    } else {
      return inStock.stream().filter(p -> p.performTask(task) != null).findAny().get();
    }
  }

  /**
   * Adds vehicle to available vehicle distance queue.
   * @param driver Vehicle to be added
   */
  public void addVehicle(Vehicle driver) {
    vehicleRankings.add(driver);
    System.out.println("New distance from Shop ID " + id + " is " + driver.getDistance(id));
  }

  /**
   * Gets next available vehicle closest to shop which has not already been checked.
   * @return next Vehicle
   */
  public Vehicle nextVehicle() {
    Vehicle next = vehicleRankings.poll();
    if (next != null) {
      tempRemoved.add(next); //Vehicle already checked and can be later added back to queue
    }
    return next;
  }

  /**
   * The selected Vehicle is removed from the queue, all other checked Vehicles added back.
   * @param unavailable Vehicle to be removed
   */
  public void removeVehicle(Vehicle unavailable) {
    if (tempRemoved.isEmpty()) {
      vehicleRankings.remove(unavailable);
    } else { //If there are Vehicles to be added back
      tempRemoved.remove(unavailable);
      resetRanking();
    }
  }

  /**
   * Adds all checked Vehicles back to queue after check complete.
   */
  public void resetRanking() {
    vehicleRankings.addAll(tempRemoved);
    tempRemoved.clear();
  }

  /**
   * Set Id of shop.
   * @param id of shop
   */
  public void setId(int id) {
    this.id = id;
  }
}
