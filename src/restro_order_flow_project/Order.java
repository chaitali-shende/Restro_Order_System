package restro_order_flow_project;

public class Order 
{
	    private String itemName;
	    private Customer customer;

	    public Order(String itemName, Customer customer) {
	        this.itemName = itemName;
	        this.customer = customer;
	    }

	    public String getItemName() {
	        return itemName;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }
}
