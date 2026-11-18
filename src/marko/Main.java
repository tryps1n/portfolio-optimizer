package marko;

import marko.model.Stock;
import marko.model.Portfolio;
import marko.math.StatsCalc;

public class Main {
    public static void main(String[] args) {
        double[] returns  = {0.05, -0.02, 0.03};

        Stock APPLE = new Stock("APPL", returns, 0.02, 89, 50);
        double mean = StatsCalc.meanReturn(APPLE.getHistoricalReturns());

        System.out.println("Stock mean return: " + mean);
    }
}
