package restro_order_flow_project;

//ELC Class: RestroOrderSystem
public class RestroOrderSystem 
{
 public static void main(String[] args) {
	// Count total number of orders for stopping condition
     int totalOrders = 6; // 3 waiters × 2 orders each
     
     Restaurant restaurant = new Restaurant("KFC",totalOrders);

     System.out.println("\u001B[35m"+"Welcome to " + restaurant.getRestaurantName() + " Restaurant!!!");
     System.out.println("\u001B[35m"+"=================================");
     
     // Show menu card once at start
     restaurant.displayMenu();
     
     // Customers
     Customer customer1 = new Customer("Customer-1");
     Customer customer2 = new Customer("Customer-2");
     Customer customer3 = new Customer("Customer-3");

     // Multiple Waiters with different orders
     Waiter waiter1 = new Waiter(restaurant, new String[]{"Fried Chicken", "Burger"}, "Waiter-1",customer1);
     Waiter waiter2 = new Waiter(restaurant, new String[]{"Pizza", "French Fries"}, "Waiter-2",customer2);
     Waiter waiter3 = new Waiter(restaurant, new String[]{"Sandwich"}, "Waiter-3",customer3);

     // Multiple Chefs working
     Chef chef1 = new Chef(restaurant, "Chef-1");
     Chef chef2 = new Chef(restaurant, "Chef-2");

     // Start all threads
     waiter1.start();
     waiter2.start();
     waiter3.start();
     chef1.start();
     chef2.start();
 }
}

