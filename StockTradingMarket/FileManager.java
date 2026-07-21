import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    public static void savePortfolio(User user) {

        try {
            FileWriter writer = new FileWriter("portfolio.txt");

            writer.write("User: " + user.getName() + "\n");
            writer.write("Balance: ₹" + user.getBalance() + "\n");
            writer.write("-------------------------\n");
            writer.write("Portfolio:\n");

            HashMap<String, Integer> portfolio = user.getPortfolio();

            if (portfolio.isEmpty()) {
                writer.write("No stocks purchased.\n");
            } else {
                for (String stock : portfolio.keySet()) {
                    writer.write(stock + " : " + portfolio.get(stock) + " shares\n");
                }
            }

            writer.close();
            System.out.println("Portfolio saved successfully to portfolio.txt");

        } catch (IOException e) {
            System.out.println("Error saving portfolio.");
        }
    }
}
