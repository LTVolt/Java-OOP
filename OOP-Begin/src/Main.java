import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    static ArrayList<Groceries> chosenGroceries = new ArrayList<>();

    static int typeChoice;
    static int groceryToAdd;
    static double cartTotal = 0;

    static Fruit[] availableFruit = new Fruit[]{
            new Fruit("Apple", 0.49, 'A'),
            new Fruit("Banana", 0.79, 'A'),
            new Fruit("Pear", 0.33, 'A'),
            new Fruit("Kiwi", 1, 'B'),
            new Fruit("Watermelon", 2.49, 'B'),
            new Fruit("Orange", 0.6, 'A')
    };

    static Veggies[] availableVeggies = new Veggies[]{
            new Veggies("Lettuce", 0.77, 'A'),
            new Veggies("Celery", 1.23,'B'),
            new Veggies("Turnip", 1.88, 'B'),
            new Veggies("Carrot", 1.33, 'A'),
            new Veggies("Tomato", 0.99, 'A')
    };

    static Meat[] availableMeat = new Meat[]{
            new Meat("Pork Loin", 3.77, 'D'),
            new Meat("Chicken Tender", 4.5,'B'),
            new Meat("Mixed Minced Meat", 2.5, 'D'),
            new Meat("Rabbit", 12.5, 'A'),
            new Meat("Lamb (1kg)", 21, 'C')
    };

    static Fish[] availableFish = new Fish[]{
            new Fish("Trout", 6.44, 'C'),
            new Fish("Perch", 3.5, 'E'),
            new Fish("Salmon", 9.82, 'B'),
            new Fish("Cod", 14.33, 'C'),
    };

    static Snacks[] availableSnacks = new Snacks[]{
            new Snacks("Ruffles", 1.99, 'E'),
            new Snacks("Milka Bar", 2.99, 'D'),
            new Snacks("Reese's", 1.99, 'E'),
            new Snacks("Doritos", 1.49, 'E'),
            new Snacks("Choco Cookies", 0.99, 'F')
    };

    public static void main(String[] args) {

        appInit();
    }

    static void appInit() {

        int choice;
        try {

            System.out.println("*************************************");
            System.out.println("******** ENHANCED ACTIVITIES ********");
            System.out.println("*************************************");
            System.out.println();
            System.out.println("1. Enhanced Shopping Cart");
            System.out.println("2. Quit");
            System.out.print("Choose want you want to do by typing the corresponding number: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> enhancedShoppingCart();
                case 2 -> System.out.println("Exiting... See you next time!");
                default -> {
                    System.out.println("Your answer was invalid. Please try again...");
                    appInit();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("INPUT ERROR: You did not input a number!");
            System.out.println("Must restart program.");

        } finally {scanner.close();}
    }

    static void enhancedShoppingCart() {

        System.out.println("*********** SHOPPING CART ***********");

        typeChoice = getTypeChoice();

        try {
            switch (typeChoice) {
                case 1 -> {
                    for (int i = 0; i < availableFruit.length; i++) {
                        availableFruit[i].showInfo(i);
                        }
                    System.out.print("Which fruit would you like to add: ");
                    groceryToAdd = scanner.nextInt();
                    scanner.nextLine();

                    addFruitToCart(groceryToAdd - 1);
                }
                case 2 -> {
                    for (int i = 0; i < availableVeggies.length; i++) {
                        availableVeggies[i].showInfo(i);
                    }
                    System.out.print("Which veggie would you like to add: ");
                    groceryToAdd = scanner.nextInt();
                    scanner.nextLine();

                    addVeggieToCart(groceryToAdd - 1);
                }
                case 3 -> {
                    for (int i = 0; i < availableMeat.length; i++) {
                        availableMeat[i].showInfo(i);
                    }
                    System.out.print("Which meat would you like to add: ");
                    groceryToAdd = scanner.nextInt();
                    scanner.nextLine();

                    addMeatToCart(groceryToAdd - 1);
                }
                case 4 -> {
                    for (int i = 0; i < availableFish.length; i++) {
                        availableFish[i].showInfo(i);
                    }
                    System.out.print("Which meat would you like to add: ");
                    groceryToAdd = scanner.nextInt();
                    scanner.nextLine();

                    addFishToCart(groceryToAdd - 1);
                }
                case 5 -> {
                    for (int i = 0; i < availableSnacks.length; i++) {
                        availableSnacks[i].showInfo(i);
                    }
                    System.out.print("Which meat would you like to add: ");
                    groceryToAdd = scanner.nextInt();
                    scanner.nextLine();

                    addSnacksToCart(groceryToAdd - 1);
                }
                case 6 -> checkCart();
                case 7 -> appInit();
                default -> {
                    System.out.println("Your answer was invalid. Please try again...");
                    enhancedShoppingCart();
                }
            }
        } catch (Exception e) {
            System.out.println("INPUT ERROR: You did not input a number!");
            System.out.println("Must restart program.");
        } finally {scanner.close();}


    }

    private static void checkCart() {
        System.out.println("Checking cart...");
        if (chosenGroceries.isEmpty()) {
            System.out.println("Your cart is empty\n");
            enhancedShoppingCart();
        } else {
            for (Groceries groceries : chosenGroceries) {
                groceries.displayInCart();
            }
            System.out.printf("Total owed: $%.2f\n", cartTotal);
            enhancedShoppingCart();
        }
    }

    private static void addFruitToCart(int index) {
        System.out.print("How many would you like to add: ");

        int nextQuantity = scanner.nextInt();
        scanner.nextLine();

        cartTotal = cartTotal + nextQuantity * availableFruit[index].price;
        availableFruit[index].quantityInCart += nextQuantity;
        chosenGroceries.add(availableFruit[index]);

        System.out.printf("Added %d %s(s) to the cart.\n", nextQuantity, availableFruit[index].name);

        enhancedShoppingCart();
    }

    private static void addVeggieToCart(int index) {
        System.out.print("How many would you like to add: ");

        int nextQuantity = scanner.nextInt();
        scanner.nextLine();

        cartTotal = cartTotal + nextQuantity * availableVeggies[index].price;
        availableVeggies[index].quantityInCart += nextQuantity;
        chosenGroceries.add(availableVeggies[index]);

        System.out.printf("Added %d %s(s) to the cart.\n", nextQuantity, availableVeggies[index].name);

        enhancedShoppingCart();
    }

    private static void addMeatToCart(int index) {
        System.out.print("How many would you like to add: ");

        int nextQuantity = scanner.nextInt();
        scanner.nextLine();

        cartTotal = cartTotal + nextQuantity * availableMeat[index].price;
        availableMeat[index].quantityInCart += nextQuantity;
        chosenGroceries.add(availableMeat[index]);

        System.out.printf("Added %d %s(s) to the cart.\n", nextQuantity, availableMeat[index].name);

        enhancedShoppingCart();
    }

    private static void addFishToCart(int index) {
        System.out.print("How many would you like to add: ");

        int nextQuantity = scanner.nextInt();
        scanner.nextLine();

        cartTotal = cartTotal + nextQuantity * availableFish[index].price;
        availableFish[index].quantityInCart += nextQuantity;
        chosenGroceries.add(availableFish[index]);

        System.out.printf("Added %d %s(s) to the cart.\n", nextQuantity, availableFish[index].name);

        enhancedShoppingCart();
    }

    private static void addSnacksToCart(int index) {
        System.out.print("How many would you like to add: ");

        int nextQuantity = scanner.nextInt();
        scanner.nextLine();

        cartTotal = cartTotal + nextQuantity * availableSnacks[index].price;
        availableSnacks[index].quantityInCart += nextQuantity;
        chosenGroceries.add(availableSnacks[index]);

        System.out.printf("Added %d %s(s) to the cart.\n", nextQuantity, availableSnacks[index].name);

        enhancedShoppingCart();
    }

    private static int getTypeChoice() {

        int typeChoice;

        System.out.println("1. Fruit");
        System.out.println("2. Veggies");
        System.out.println("3. Meat");
        System.out.println("4. Fish");
        System.out.println("5. Snacks");
        System.out.println("6. Check cart");
        System.out.println("7. Back");
        System.out.print("Choose what you would like to do: ");
        typeChoice = scanner.nextInt();
        scanner.nextLine();
        return typeChoice;
    }
}
