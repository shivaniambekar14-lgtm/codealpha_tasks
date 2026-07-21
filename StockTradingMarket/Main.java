import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("Shivani", 100000);
        Portfolio market = new Portfolio();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   STOCK TRADING PLATFORM");
            System.out.println("==============================");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Save Portfolio");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    market.displayMarket();
                    break;

                case 2:

                    market.displayMarket();

                    System.out.print("Enter Stock Name: ");
                    String buyName = sc.next();

                    Stock buyStock = market.findStock(buyName);

                    if (buyStock == null) {
                        System.out.println("Stock not found.");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    double cost = buyStock.getPrice() * qty;

                    if (user.getBalance() >= cost) {

                        user.deductBalance(cost);
                        user.buyStock(buyStock.getName(), qty);

                        System.out.println("Stock Purchased Successfully!");

                    } else {

                        System.out.println("Insufficient Balance.");

                    }

                    break;

                case 3:

                    HashMap<String, Integer> portfolio = user.getPortfolio();

                    if (portfolio.isEmpty()) {

                        System.out.println("No stocks available to sell.");
                        break;

                    }

                    System.out.println("Your Portfolio:");

                    for (String stock : portfolio.keySet()) {

                        System.out.println(stock + " : " + portfolio.get(stock) + " shares");

                    }

                    System.out.print("Enter Stock Name: ");
                    String sellName = sc.next();

                    Stock sellStock = market.findStock(sellName);

                    if (sellStock == null) {

                        System.out.println("Stock not found.");
                        break;

                    }

                    if (!portfolio.containsKey(sellName)) {

                        System.out.println("You don't own this stock.");
                        break;

                    }

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    int owned = portfolio.get(sellName);

                    if (sellQty > owned) {

                        System.out.println("Not enough shares.");
                        break;

                    }

                    user.sellStock(sellName, sellQty);

                    user.addBalance(sellQty * sellStock.getPrice());

                    System.out.println("Stock Sold Successfully!");

                    break;

                case 4:

                    System.out.println("\n===== YOUR PORTFOLIO =====");

                    System.out.println("Balance : ₹" + user.getBalance());

                    if (user.getPortfolio().isEmpty()) {

                        System.out.println("No Stocks Purchased.");

                    } else {

                        for (String stock : user.getPortfolio().keySet()) {

                            System.out.println(stock + " : "
                                    + user.getPortfolio().get(stock)
                                    + " shares");

                        }

                    }

                    break;

                case 5:

                    FileManager.savePortfolio(user);

                    break;

                case 6:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}