package marko.model;

public abstract class Asset {
    private String ticker;
    private double[] historicalReturns;

    public Asset (String ticker, double[] historicalReturns) {
        this.ticker = ticker;
        this.historicalReturns = historicalReturns;
    }

    public String getTicker() {
        return ticker;
    }

    public double[] getHistoricalReturns() {
        return historicalReturns;
    }
}
