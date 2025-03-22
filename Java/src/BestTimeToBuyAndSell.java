public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int maxProfit = 0, currentProfit;
        int minVal = prices[0];

        for (int i=1;i<prices.length;i++) {
            currentProfit = prices[i] - minVal;
            if (currentProfit > maxProfit) maxProfit = currentProfit;
            if (prices[i] < minVal) minVal = prices[i];
        }

        return maxProfit;
    }


}
