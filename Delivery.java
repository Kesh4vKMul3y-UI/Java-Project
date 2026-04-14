import java.util.Scanner;

// Step 1: Create FoodItem Class
class FoodItem {
    private String itemName;
    private double price;

    public FoodItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}

// Step 2: Create Restaurant Class
class Restaurant {
    private String name;
    private FoodItem[] menu;

    public Restaurant(String name, FoodItem[] menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void displayMenu() {
        System.out.println("\n--- Menu for " + name + " ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getItemName() + " - " + menu[i].getPrice());
        }
    }

    public FoodItem getMenuItem(int index) {
        if (index >= 0 && index < menu.length) {
            return menu[index];
        }
        return null;
    }
}

// Step 3 & 4: Create Order Class and Implement Billing Logic
class Order {
    private FoodItem[] itemsOrdered = new FoodItem[10]; // Constraints: Use arrays 
    private int[] quantities = new int[10];
    private int itemCount = 0;

    public void addItem(FoodItem item, int quantity) {
        if (itemCount < itemsOrdered.length) {
            itemsOrdered[itemCount] = item;
            quantities[itemCount] = quantity;
            itemCount++;
            System.out.println(item.getItemName() + " added to order.");
        } else {
            System.out.println("Order is full!");
        }
    }

    public void displayOrderSummary() {
        double subtotal = 0;
        System.out.println("\n--- Final Order Summary ---");
        
        for (int i = 0; i < itemCount; i++) {
            double cost = itemsOrdered[i].getPrice() * quantities[i];
            subtotal = cost + subtotal;
            System.out.println(itemsOrdered[i].getItemName() + " X " + quantities[i] + " = " + cost);
        }

        // Delivery Charge Logic: ₹50 or Free if subtotal > ₹500 
        double deliveryCharge = (subtotal > 500) ? 0 : 50;
        
        // Tax Calculation: 5% GST 
        double tax = subtotal * 0.05;
        double totalAmount = subtotal + deliveryCharge + tax;

        System.out.println("---------------------------");
        System.out.println("Subtotal : " + subtotal);
        System.out.println("Delivery Charge : " + deliveryCharge);
        System.out.println("Tax (5% GST) : " + tax);
        System.out.println("Total Amount : " + totalAmount);
        System.out.println("---------------------------");
    }
}

// Main Class to run the system
public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setting up a sample Restaurant and Menu
        FoodItem[] items = {
            new FoodItem("Burger", 100),
            new FoodItem("Pizza", 300),
            new FoodItem("Pasta", 150)
        };
        Restaurant myRestaurant = new Restaurant("Star Kitchen", items);

        Order myOrder = new Order();
        boolean ordering = true;

        System.out.println("Welcome to the Online Food Delivery System!");

        while (ordering) {
            myRestaurant.displayMenu();
            System.out.print("\nEnter item number to add to order (or 0 to finish) : ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
            } else {
                FoodItem selected = myRestaurant.getMenuItem(choice - 1);
                if (selected != null) {
                    System.out.print("Enter quantity : ");
                    int qty = scanner.nextInt();
                    myOrder.addItem(selected, qty);
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }

        // Step 5: Display final bill 
        myOrder.displayOrderSummary();
        scanner.close();
    }
}
