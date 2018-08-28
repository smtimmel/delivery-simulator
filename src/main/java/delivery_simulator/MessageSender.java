package delivery_simulator;

/**
 * Interface for uppdate which sends out notifications.
 * @author Scott Timmel
 */
public interface MessageSender {

  /**
   * Adds MessageReceiver to notification list.
   * @param addition specific MessageReceiver
   */
  public void registerReceiver(MessageReceiver addition);
  
  /**
   * Removes MessageReceiver from notification list.
   * @param removal specific MessageReceiver
   */
  public void removeReceiver(MessageReceiver removal);
  
  /**
   * Notifies all MessageReceivers in list.
   */
  public void notifyReceivers();

}
