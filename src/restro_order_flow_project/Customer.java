package restro_order_flow_project;

import java.util.*;

//BLC Class: Customer
public class Customer 
{
 private String name;
 private int totalBill = 0;

 public Customer(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }

 // Add order cost to bill
 public void addToBill(int amount) {
     totalBill += amount;
 }

 // Pay bill and print receipt
 public void payBill(String restaurantName) 
 {
     System.out.println("\u001B[35m"+"\nReceipt for " + name + ":");
     System.out.println("\u001B[35m"+"Total Amount: Rs." + totalBill);
     System.out.println("\u001B[35m"+"Payment Successful.");
     System.out.println("\u001B[35m"+"Thank you " + name + "!! Visit Again at " + restaurantName + " Restaurant!!!\n");
 }
}

