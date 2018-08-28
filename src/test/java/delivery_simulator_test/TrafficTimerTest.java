package delivery_simulator_test;

import static org.junit.Assert.*;

import org.junit.Test;

import delivery_simulator.TrafficTimer;

/**
 * Tests TrafficTimer methods.
 * @author Scott Timmel
 */
public class TrafficTimerTest {

  /**
   * Test method for Traffic Timer performTask method.
   */
  @Test
  public void testPerformTask() {
    assertEquals(TrafficTimer.getTrafficTimer().performTask("high"), null);
  }

}
