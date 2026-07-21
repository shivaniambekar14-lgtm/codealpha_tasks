import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Stock> marketStocks;

    public Portfolio() {

        marketStocks = new ArrayList<>();

        marketStocks.add(new Stock("TCS", 3500));
        marketStocks.add(new Stock("Infosys", 1500));
        marketStocks.add(new Stock("Reliance", 2800));
        marketStocks.add(new Stock("Wipro", 450));
    }

    // Display all available stocks
    public void displayMarket() {

        System.out.println("\n===== MARKET DATA =====");

        for (int i = 0; i < marketStocks.size(); i++) {

            Stock s = marketStocks.get(i);

            System.out.println((i + 1) + ". "
                    + s.getName()
                    + " - ₹"
                    + s.getPrice());
        }
    }

    // Find stock by name
    public Stock findStock(String name) {

        for (Stock s : marketStocks) {

            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }

        return null;
    }
}
