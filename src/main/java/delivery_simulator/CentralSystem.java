package delivery_simulator;

import java.util.LinkedList;

/**
 * Class runs simulation and notifies vehicles and order requests to be updated at each tick.
 * @author Scott Timmel
 */
public class CentralSystem implements MessageSender {

  private static CentralSystem central = new CentralSystem();
  private int numShops = 5;
  private int numVehicles = 10;
  private int numOrders = 20;
  private int tick = 0;
  private Shop[] shops = new Shop[numShops];
  private LinkedList<MessageReceiver> toBeRemoved = new LinkedList<>();
  private LinkedList<MessageReceiver> receivers = new LinkedList<>();

  private CentralSystem() { }
  
  /**
   * Retrieves single instance of CentralSystem to be used by other program component.
   * @return CentralSystem component to be used.
   */
  public static CentralSystem getCentralSystem() {
    return central;
  }

  /**
   * Runs the full simulation.
   */
  public void runSimulation() {
    setup();
    while (numOrders > 0) {
      notifyReceivers();
      for (MessageReceiver removal : toBeRemoved) {
        removeReceiver(removal); //Order requests taken by drivers taken off notification list
      }
      tick++;
    }
    System.out.println("All orders have been delivered!");
  }

  /**
   * Uses factories to build Shop, Vehicle and Order objects.
   * MessageReceivers set to be notified.
   */
  private void setup() {
    for (int i = 0;i < shops.length;i++) {
      shops[i] = (Shop)ShopFactory.getFactory().createSimulated();
      shops[i].setId(i);
    }
    registerReceiver(TrafficTimer.getTrafficTimer());
    generateReceivers(numVehicles, VehicleFactory.getFactory());
    generateReceivers(numOrders, OrderFactory.getFactory());
  }

  /**
   * Registered specified number of specific MessageReceiver subclass to be notified.
   * @param num of MessageReceivers created.
   * @param factory used to create MessageReceiver objects.
   */
  private void generateReceivers(int num, SimulatedFactory factory) {
    for (int i = 0;i < num;i++) {
      registerReceiver((MessageReceiver)factory.createSimulated());
    }
  }

  /**
   * Registers MessageReceiver to be notified.
   * @param addition specific MessageReceiver
   */
  public void registerReceiver(MessageReceiver addition) {
    receivers.add(addition);
  }

  /**
   * Stops MessageReceiver from being notified.
   * @param removal specific MessageReceiver
   */
  public void removeReceiver(MessageReceiver removal) {
    receivers.remove(removal);
  }

  /**
   * Notifies all MessageReceivers on list.
   */
  public void notifyReceivers() {
    for (MessageReceiver receiver : receivers) {
      receiver.update(tick);
    }
  }

  /**
   * Prepares MessageReceiver to be removed after notifications complete.
   * @param removal specific MessageReceiver
   */
  public void prepRemoval(MessageReceiver removal) {
    toBeRemoved.add(removal);
  }

  /**
   * Indicated order has been completed.
   */
  public void completeOrder() {
    numOrders--;
  }

  /**
   * Gets shop list.
   * @return shops
   */
  public Shop[] getShops() {
    return shops;
  }

  /**
   * Gets number of vehicles.
   * @return numVehicle
   */
  public int getNumVehicles() {
    return numVehicles;
  }

}
