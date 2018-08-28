# Application Summary

Delivery System Simulator provides users with a simulation of a mock delivery system in which orders are placed to specific stores in the system and the nearest available driver is selected to deliver the products to the customers.  Several drivers have refrigerated vehicles and can thus called upon when products needed to be kept cool are being delivered.  The application provides the results for the entire simulation until all randomly generated orders have been fulfilled.  The application can be run by running the run.sh file.

# Application Details

- Since both warm and cold food can be purchased in the same order, if a vehicle with a freezer was utilized for delivery the warm food could be kept up front out of the cold
- In the event of a customer birthday, if the customer already had either flowers or chocolate in their order those would count toward the birthday present
- High Traffic events can start within the first 10 ticks and can last a maximum of 10 ticks
- Each driver has one vehicle
- There are 10 drivers, 5 shops, 1 high traffic event and 20 orders which all come in at the first tick.
- Each shop can hold up to five unique product, the shop must carry all product types
- The product types are warm food, cold food, flowers and chocolates
- Each vehicle is a fixed distance from each shop, which is updated when the vehicle reaches an order location
- Vehicles are assigned to orders if they are currently closest to the store and can appropriately transport all purchase items
- For each time tick, a vehicle moves one mile (unit) of distance
- An order can consist of one to five unique products
- Vehicle status is printed at every tick
- When orders are picked up or completed a message is printed to the user