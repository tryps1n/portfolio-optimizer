package marko.model;

public class Stock extends Asset {
    private double beta;
    private double currentPrice;
    int quantity;

    public Stock(String ticker, double[] historicalPrices, double beta,
                 double currentPrice, int quantity) {
        super(ticker, historicalPrices);
        this.beta = beta;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
    }

    public double getBeta() {
        return beta;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean updatePrice(double newPrice) {
        if (newPrice < 0) return false;
        this.currentPrice = newPrice;
        return true;
    }

    public boolean updateQuantity(int newQuantity) {
        if (newQuantity < 0) return false;
        this.quantity = newQuantity;
        return true;
    }
}
