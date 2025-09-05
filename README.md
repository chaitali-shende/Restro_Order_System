# 🍴 RestroOrderSystem  

A Java project that simulates a restaurant order delivery system using **Inter Thread Communication (ITC)**.  
This project models how **waiters place orders**, **chefs prepare them**, and **customers pay bills**, all handled with **synchronized threads and communication between them**.  

---

## 📌 Key Concepts Used  

### 🔄 Inter Thread Communication (ITC)  
- **`wait()`** → Chefs wait if there are no orders.  
- **`notifyAll()`** → Waiters notify chefs when a new order is placed.  
- **Shared Resource** → `Restaurant` acts as the common resource accessed by both Waiters and Chefs.  
- **Producer-Consumer Problem** →  
  - **Waiter = Producer** (produces orders)  
  - **Chef = Consumer** (consumes/prepares orders)  

### 🧵 Multithreading Concepts  
- Multiple `Waiter` threads → take orders from customers.  
- Multiple `Chef` threads → prepare different orders simultaneously.  
- Proper **synchronization** (`synchronized` keyword) to avoid race conditions.  

### 💡 Object-Oriented Programming (OOP)  
- **Encapsulation** → Data (like `order`, `bill`) is private with public methods.  
- **Abstraction** → Separate classes for `Restaurant`, `Waiter`, `Chef`, `Customer`, `Order`.  
- **Inheritance** → `Waiter` and `Chef` extend `Thread`.  
- **Polymorphism** → `run()` method overridden in Waiter and Chef.  

### 🛠️ Java Core Concepts  
- **Collections Framework** → `Queue` (`LinkedList`) for order management.  
- **HashMap** → To track customer bills.  
- **Exception Handling** → `InterruptedException` handled in threads.  
- **ANSI Escape Codes** → To add colors in console output.  

---

## 📂 Project Structure  

- `Restaurant` → Shared resource (handles orders, billing, ITC).  
- `Order` → Represents a single order (dish + linked customer).  
- `Waiter` → Places customer orders into the restaurant system.  
- `Chef` → Prepares orders and notifies when ready.  
- `Customer` → Stores name, bill details, and payment functionality.  
- `RestroOrderSystem` → Main class (ELC) to run the simulation.  

---

## 📌 Features  

✅ Display  **Menu Card** at the start.  
✅ Multiple **Waiters** take orders from customers simultaneously.  
✅ Multiple **Chefs** prepare dishes in parallel.  
✅ Each **Customer** can order multiple dishes.  
✅ Bills are maintained **per customer**.  
✅ Generate a **Receipt** with:  
- Items ordered & their prices  
- Total bill amount  
- Payment status  
- Thank-you message with restaurant branding  
✅ **Thread synchronization** ensures smooth communication between waiters, chefs, and customers.  
✅ Attractive **console colors (ANSI codes)** for better visualization.

---

## 🖥️ Sample Output  

Welcome to KFC Restaurant!!!
=================================

Menu Card of KFC Restaurant:
---------------------------------
Fried Chicken - Rs.250
Burger - Rs.150
Pizza - Rs.300
French Fries - Rs.120
Momo - Rs.200
Sandwich - Rs.180
Manchurian - Rs.180

---------------------------------

Waiter-1: Placed order for Fried Chicken (Customer: Customer-1)
Chef-1: Preparing Fried Chicken
Chef-1: Fried Chicken is ready!
Waiter: Serving Fried Chicken to Customer-1
Added Rs.250 to Customer-1's bill

Receipt for Customer-1:
Total Amount: Rs.250
Payment Successful.
Thank you Customer-1!! Visit Again at KFC Restaurant!!!

