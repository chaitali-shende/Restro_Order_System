package restro_order_flow_project;

//BLC Class: Waiter
public class Waiter extends Thread 
{
 private Restaurant restaurant;
 private String[] customerOrders;
 private Customer customer;

 // Constructor
 public Waiter(Restaurant restaurant, String[] customerOrders, String waiterName, Customer customer) {
     super(waiterName);
     this.restaurant = restaurant;
     this.customerOrders = customerOrders;
     this.customer = customer;
 }

 @Override
 public void run() {
     for (String order : customerOrders) {
         restaurant.placeOrder(order, customer);
         try {
             Thread.sleep(500); // Small delay between orders
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

