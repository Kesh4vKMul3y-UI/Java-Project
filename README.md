# Online Food Delivery System

A console-based Delivery System built using Core Java and Object-Oriented Programming (OOP) concepts.

---

## Developer Information

* **Name :** Keshav K Muley
* **ERP ID :** RU-25-10665
* **Course :** Object Oriented Programming With Java (RU-100-01-00012)
* **University :** Rungta International Skills University, Bhilai, CG
* **Session :** 2025–26

---

## Features

* Restaurant Management: Allows multiple restaurants to list food items with specific prices.
* Menu Browsing : Interactive console interface to view available dishes.
* Order Creation: Select multiple items and specify quantities.
* Subtotal : Calculation of (Item Price X Quantity).
* GST Logic : Automatic application of 5% Tax on the subtotal.
* Detailed Receipt: Generates a complete order summary with itemized costs.

---

## Requirements

* Java JDK 8 or above
* Any IDE or text editor (VS Code, Eclipse, IntelliJ IDEA, etc.)

---

## Project Structure

```
Delivery.java
│
├── class FoodItem
│   ├── String itemName
│   ├── double price
│   └── getPrice(), getItemName()   → Accessor methods.
│
├── class Restaurant
│   ├── String name
│   ├── FoodItem[] menu             → Fixed-size array for menu storage.
│   └── displayMenu()               → Displays available items and prices.
│
└── class Order [cite: 30]
    ├── FoodItem[] itemsOrdered     → Storage for selected items.
    ├── int[] quantities            → Storage for item counts.
    ├── addItem(item, qty)          → Logic to add selection to order.
    └── displayOrderSummary()       → Final billing and summary logic.
```

---

## Sample Output

```
==========================================
    ONLINE FOOD DELIVERY SYSTEM
==========================================

--- Menu for Star Kitchen ---
1. Burger - Rs. 100.0
2. Pizza - Rs. 300.0
3. Pasta - Rs. 150.0

Enter item number to add to order (or 0 to finish): 2
Enter quantity: 2
Pizza added to order.

--- Final Order Summary ---
Pizza x 2 = Rs. 600.0
---------------------------
Subtotal: Rs. 600.0
Delivery Charge: Rs. 0.0
Tax (5% GST): Rs. 30.0
Total Amount: Rs. 630.0
---------------------------
```

---

## Limitations

* Arrays Only : Uses fixed-size arrays instead of ArrayLists as per project constraints.
* Memory-Based : Data is not stored permanently; it resets after program exit.
* Console Interface : Interaction is limited to text-based commands via Scanner.
---

## Future Enhancements

* Persistence : File handling to save order history.
* Distance Tracking : Calculate delivery fees based on user distance.
* Discount System : Integration of promo codes and coupons.
* Multi-Restaurant Selection : Support for picking items from different kitchens.
---

## References

* Herbert Schildt, *Java: The Complete Reference*, 11th Edition, McGraw-Hill, 2018
* Oracle Java Documentation: https://docs.oracle.com

---
