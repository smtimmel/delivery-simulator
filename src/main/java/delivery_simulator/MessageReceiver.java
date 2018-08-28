package delivery_simulator;

/**
 * Objects which can be sent notifications and updated.
 * @author Scott Timmel
 */
public abstract class MessageReceiver implements Simulated {

  protected int[] distances;
  protected int id;

  public MessageReceiver(int id, int[] distances) {
    this.id = id;
    this.distances = distances;
  }

  /**
   * Performs update when notified.
   * @param tick current time
   */
  public abstract void update(int tick);
}

