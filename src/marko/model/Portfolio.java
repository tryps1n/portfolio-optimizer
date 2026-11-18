package marko.model;

import marko.math.StatsCalc;

import java.util.List;
import java.util.ArrayList;

public class Portfolio {
    private List<Stock> stocks;
    private double cashBalance;

    public Portfolio() {
        this.stocks = new ArrayList<>();
        this.cashBalance = 0.0;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public double getTotalPortfolioValue() {
        double total = 0;
        for (Stock s : stocks) {
            total += s.getCurrentPrice();
        }
        return total + cashBalance;
    } 

    public double[] getCurrentWeights() {
        double totalValue = getTotalPortfolioValue();
        double[] currentWeights = new double[stocks.size()];
        
        for (int i=0; i<stocks.size(); ++i) {
            currentWeights[i] = stocks.get(i).getCurrentPrice() / totalValue;
        }
        
        return currentWeights;
    }

    public double[] getPortfolioExpectedReturnVec() {
        double[] portfolioReturnVec = new double[stocks.size()];

        for (int i=0; i<stocks.size(); ++i) {
            Stock stock = stocks.get(i);
            double stockMeanReturn = StatsCalc.meanReturn(stock.getHistoricalReturns());
            portfolioReturnVec[i] = stockMeanReturn;
        } 

        return portfolioReturnVec;
    }

}
