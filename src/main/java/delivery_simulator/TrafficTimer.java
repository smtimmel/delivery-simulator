package delivery_simulator;

import java.util.Random;

/**
 * Manages timer and traffic events of simulation.
 * @author Scott Timmel
 */
public class TrafficTimer extends MessageReceiver {

  private static int numEvents = 1;
  private static int minStartTick = 1;
  private static int maxEventDuration = 10;
  private static TrafficTimer timer = new TrafficTimer();
  private static Random r;
  private boolean highTraffic = false;

  private TrafficTimer() {
    super(1, getStartEnd());
  }

  /**
   * Determines start and end times of high traffic events.
   * @return Array of start and end times
   */
  private static int[] getStartEnd() {
    int i = 0;
    r = new Random();
    int[] startEnd = new int[2 * numEvents]; //Each event has start and end time
    while (i < startEnd.length) {
      startEnd[i++] = minStartTick + r.nextInt(maxEventDuration);
      startEnd[i++] = startEnd[0] + r.nextInt(maxEventDuration) + 1;
      minStartTick = startEnd[i - 1] + 1; //additional events can occur after current event ends
    }
    return startEnd;
  }

  /**
   * Prints current time and checks if traffic event starts or ends.
   * @param tick current time
   */
  public void update(int tick) {
    System.out.println("Current Tick: " + tick);
    if (tick == distances[id - 1]) {
      System.out.println("Starting high traffic event");
      highTraffic = true;
    } else if (tick == distances[id]) {
      System.out.println("Ending high traffic event");
      highTraffic = false;
      //check if any more events, if so start checking for next events
      if (id != (2 * numEvents) - 1) {
        id += 2;
      }
    }
    System.out.println();
  }

  /**
   * Checks if specified traffic event is occurring.
   * @param task name of traffic event to be checked
   * @return if traffic event occurring, false otherwise
   */
  public <T> Simulated performTask(T task) {
    if (task.equals("high")) {
      if (highTraffic) {
        return this;
      } else {
        return null;
      }
    } else {
      return null;
    }
  }

  /**
   * Provides TrafficTimer instance to be used by program.
   * @return TrafficTimer instance
   */
  public static TrafficTimer getTrafficTimer() {
    return timer;
  }

}
