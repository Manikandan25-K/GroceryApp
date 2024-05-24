package longcoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private int userID;
    private String name;
    String email;
    String password;
    private String role;
    private long phnNo;
    private long aadharNo;

    public User(int userID, String name, String email, String password, String role, long phnNo, long aadharNo) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phnNo = phnNo;
        this.aadharNo = aadharNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", phnNo=" + phnNo +
                ", aadharNo=" + aadharNo +
                '}';
    }
}

class GroceryItem {
    private int groceryId;
    private String groceryName;
    private int groceryQuantity;
    private String groceryBrand;

    public GroceryItem(int groceryId, String groceryName, int groceryQuantity, String groceryBrand) {
        this.groceryId = groceryId;
        this.groceryName = groceryName;
        this.groceryQuantity = groceryQuantity;
        this.groceryBrand = groceryBrand;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "groceryId=" + groceryId +
                ", groceryName='" + groceryName + '\'' +
                ", groceryQuantity=" + groceryQuantity +
                ", groceryBrand='" + groceryBrand + '\'' +
                '}';
    }
}

class CartId {
    private int quantityAdded;
    private int price;

    public CartId(int quantityAdded, int price) {
        this.quantityAdded = quantityAdded;
        this.price = price;
    }
}

class Payment {
    private int paymentId;
    private String type; // Assuming type is a string like "Credit Card", "Debit Card", etc.
    private int cvv;
    private int month;
    private int year;

    public Payment(int paymentId, String type, int cvv, int month, int year) {
        this.paymentId = paymentId;
        this.type = type;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
    }
}

public class GroceryApp {
    private static List<User> users = new ArrayList<>();
    private static List<GroceryItem> groceryItems = new ArrayList<>();

    static {
        users.add(new User(1, "mani", "immani@gmail.com", "0mani123", "admin", 2423463, 643638263));
        users.add(new User(2, "john", "john@gmail.com", "john123", "customer", 2345678, 123456789));
        users.add(new User(3, "jane", "jane@gmail.com", "jane123", "customer", 3456789, 987654321));
    }

    public static void addGroceryItem(int groceryId, String groceryName, int groceryQuantity, String groceryBrand) {
        GroceryItem item = new GroceryItem(groceryId, groceryName, groceryQuantity, groceryBrand);
        groceryItems.add(item);
    }

    public static void displayGroceryItems() {
        if (groceryItems.isEmpty()) {
            System.out.println("No grocery items available.");
        } else {
            for (GroceryItem item : groceryItems) {
                System.out.println(item);
            }
        }
    }

    public static void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.println("-------List of Menus--- please select one");
            System.out.println("1. Enter the user details");
            System.out.println("2. Add Grocery Items");
            System.out.println("3. Display Grocery Items");
            System.out.println("4. Display Users");
            System.out.println("5. Cart ID");
            System.out.println("6. Payment method");
            System.out.println("7. Exiting");

            int option = s1.nextInt();
            s1.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter your email:");
                    String mail = s1.nextLine();
                    System.out.println("Enter your password:");
                    String password1 = s1.nextLine();

                    boolean loginSuccess = false;
                    for (User user : users) {
                        if (user.getEmail().equals(mail) && user.getPassword().equals(password1)) {
                            System.out.println("Login successful. Welcome " + user.getName() + "!");
                            loginSuccess = true;
                            break;
                        }
                    }
                    if (!loginSuccess) {
                        System.out.println("Login failed. Incorrect email or password.");
                    }
                    break;
                case 2:
                    System.out.println("Enter Grocery ID:");
                    int groceryId = s1.nextInt();
                    s1.nextLine(); // Consume newline
                    System.out.println("Enter Grocery Name:");
                    String groceryName = s1.nextLine();
                    System.out.println("Enter Grocery Quantity:");
                    int groceryQuantity = s1.nextInt();
                    s1.nextLine(); // Consume newline
                    System.out.println("Enter Grocery Brand:");
                    String groceryBrand = s1.nextLine();
                    addGroceryItem(groceryId, groceryName, groceryQuantity, groceryBrand);
                    System.out.println("Grocery item added successfully.");
                    break;
                case 3:
                    System.out.println("Displaying Grocery Items:");
                    displayGroceryItems();
                    break;
                case 4:
                    System.out.println("Displaying Users:");
                    displayUsers();
                    break;
                case 5:
                    // Handle Cart ID
                    System.out.println("Cart ID selected");
                    break;
                case 6:
                    // Handle Payment method
                    System.out.println("Payment method selected");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    s1.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
