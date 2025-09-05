package restro_order_flow_project;

//BLC Class: Chef
public class Chef extends Thread 
{
 private Restaurant restaurant;

 // Constructor
 public Chef(Restaurant restaurant, String chefName) {
     super(chefName);
     this.restaurant = restaurant;
 }

 @Override
 public void run() {
	 while (true) {
         Order order = restaurant.takeOrder();
         if (order == null) break; // stop chef when all orders are done
         try {
             System.out.println("\u001B[36m"+getName() + ": Preparing " + order.getItemName());
             Thread.sleep(2000); // Simulate cooking time
             System.out.println("\u001B[36m"+getName() + ": " + order.getItemName() + " is ready!");
             System.out.println("\u001B[34m"+"Waiter: Serving " + order.getItemName()+" to "+ order.getCustomer().getName());
             restaurant.completeOrder(order); // process payment
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

