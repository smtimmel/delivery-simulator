package delivery_simulator;

import java.util.Arrays;
import java.util.Random;

/**
 * Abstract class for factory which produces MessageReceiver objects.
 * @author Scott Timmel
 */
public abstract class MessageReceiverFactory implements SimulatedFactory {

  protected Random rand = new Random();
  protected int[] distances = new int[CentralSystem.getCentralSystem().getShops().length];
  protected int id = -1;
  protected int ratio;
  protected boolean condition;

  /**
   * Prepares for the MessageReceiver object to be created.
   */
  protected void prepSimulated() {
    id++;
    distances = Arrays.stream(distances).map(d -> rand.nextInt(5) + 1).toArray();
    if (id % ratio > 0) { //Sets special condition for MessageReceiver object using ratio
      condition = false;
    } else {
      condition = true;
    }
  }

}
