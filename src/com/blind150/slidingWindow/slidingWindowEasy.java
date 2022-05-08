package com.blind150.slidingWindow;

public class slidingWindowEasy {
    public static void main(String[] args) {
        //1 Best time to buy stocks
        int[] stocksIp = {7,1,5,3,6,4};
        System.out.println("The Best profit obtained is " + bttStocks(stocksIp));
    }

    private static int bttStocks(int[] stocksIp) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;
        for(int i=0; i< stocksIp.length; i++){
            if(min > stocksIp[i]){
                min = stocksIp[i];
            }
            profit =  stocksIp[i] - min;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
