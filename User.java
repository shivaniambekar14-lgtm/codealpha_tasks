import java.util.HashMap;

public class User {

    private String name;
    private double balance;
    private HashMap<String, Integer> portfolio;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void buyStock(String stockName, int quantity) {
        portfolio.put(stockName,
                portfolio.getOrDefault(stockName, 0) + quantity);
    }

    public void sellStock(String stockName, int quantity) {

        if (portfolio.containsKey(stockName)) {

            int currentQty = portfolio.get(stockName);

            if (currentQty <= quantity) {
                portfolio.remove(stockName);
            } else {
                portfolio.put(stockName, currentQty - quantity);
            }
        }
    }
}