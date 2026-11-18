package marko.math;

import marko.model.Stock;

public class StatsCalc {

   public static double meanReturn(double[] returns) {
        double sum = 0;
        for (double x : returns) {
            sum += x;
        }
        return (sum / returns.length);
   } 

   public static double varianceReturns(double[] returns) {
        double meanReturn = meanReturn(returns);
        double var = 0;

        for (int i=0; i<returns.length; ++i) {
            var += (meanReturn - returns[i]) * (meanReturn - returns[i]);
        }

        return var;
   }

   public static double covarianceReturns(Stock a, Stock b) {
        double[] aRet = a.getHistoricalReturns();
        double[] bRet = b.getHistoricalReturns();

        if (aRet.length != bRet.length) throw new IllegalArgumentException("Stocks dont have equal number of returns.");

        double meanA = meanReturn(aRet);
        double meanB = meanReturn(bRet);
    
        double cov = 0;
        
        int size = aRet.length;
        for (int i=0; i<size; ++i) {
            cov += (meanA - aRet[i]) * (meanB - bRet[i]);
        }

        return cov;
   }

}
