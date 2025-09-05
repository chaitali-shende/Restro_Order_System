package restro_order_flow_project;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// BLC Class: Restaurant
public class Restaurant 
{
    private String name;
    private final Queue<Order> orders = new LinkedList<>();

    private int totalOrders; // total number of orders expected
    private int completedOrders = 0; // track served orders
    
    // price list (Menu Card)
    private static final Map<String, Integer> priceList = new LinkedHashMap<>();
    static {
        priceList.put("Fried Chicken", 250);
        priceList.put("Burger", 150);
        priceList.put("Pizza", 300);
        priceList.put("French Fries", 120);
        priceList.put("Momo", 200);
        priceList.put("Sandwich", 180);
        priceList.put("Manchurian", 180);
    }
    
    // Constructor
    public Restaurant(String name, int totalOrders) {
        this.name = name;
        this.totalOrders = totalOrders;
    }
    
   // Show menu card
    public void displayMenu() {
        System.out.println("\u001B[30m"+"\nMenu Card of " + name + " Restaurant:");
        System.out.println("\u001B[30m"+"---------------------------------");
        for (Map.Entry<String, Integer> entry : priceList.entrySet()) {
            System.out.println("\u001B[33m"+entry.getKey() + " - Rs." + entry.getValue());
        }
        System.out.println("\u001B[33m"+"---------------------------------\n");
    }

    // Waiter places an order
    public synchronized void placeOrder(String orderName, Customer customer) {
    	orders.add(new Order(orderName, customer));
        System.out.println("\u001B[34m"+Thread.currentThread().getName() + ": Placed order for " + orderName+" (Customer: " + customer.getName() + ")");
        notifyAll(); // Notify chefs that a new order is available
    }

    // Chef takes an order to prepare
    public synchronized Order takeOrder() {
        while (orders.isEmpty() && completedOrders < totalOrders) {
            try {
                wait(); // Wait until there is an order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (completedOrders >= totalOrders && orders.isEmpty()) {
            return null; // no more orders to process
        }
        return orders.poll(); // Take next order
    }
    
    // After serving, update customer bill
    public synchronized void completeOrder(Order order) 
    {
        int amount = priceList.getOrDefault(order.getItemName(), 100);

        // Add to customer's bill
        order.getCustomer().addToBill(amount);

        System.out.println("\u001B[32m"+"Added Rs." + amount + " to " + order.getCustomer().getName() + "'s bill");
        
        // Check if this customer has any remaining orders
        boolean hasMoreOrders = orders.stream()
                                      .anyMatch(o -> o.getCustomer().equals(order.getCustomer()));

        if (!hasMoreOrders) {
            // No more orders left for this customer → let them pay
            order.getCustomer().payBill(name);
        }
    }

    public String getRestaurantName() {
        return name;
    }
}



