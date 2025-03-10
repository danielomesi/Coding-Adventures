package hackerank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNetProfit {

    private static final Map<String,Long> product2Price = new HashMap<String,Long>();
    private static final Map<String,Integer> product2Quantity = new HashMap<>();
    private static long balance = 0;
   // private static final Map<String,List<Deal>> product2BuyDeals = new HashMap<>();
   // private static final Map<String,List<Deal>> product2SellDeals = new HashMap<>();

    public static void main(String[] args) {
        List<String> events = List.of(
                "BUY headphones 20",
                "BUY laptop 50",
                "CHANGE headphones 6",
                "QUERY",
                "SELL laptop 10",
                "CHANGE laptop -2",
                "QUERY"
        );

        List<Long> result = getNetProfit(events);
        for (Long price : result) {
            System.out.println(price);
        }
    }



    public static List<Long> getNetProfit(List<String> events) {
        List<Long> result = new ArrayList<Long>();
        for (String event : events) {
            String[] parts = event.split(" ");
            String cmd = parts[0];
            int currentQuantity;
            long unitPrice;

            if (cmd.equalsIgnoreCase("query")) {
                result.add(balance);
            }
            else {
                String productName = parts[1];
                if (!product2Price.containsKey(productName)) {
                    product2Price.put(productName, 0L);
                    product2Quantity.put(productName, 0);
                    //product2BuyDeals.put(productName, new ArrayList<>());
                    //product2SellDeals.put(productName, new ArrayList<>());
                }
                switch (cmd) {
                    case "BUY":
                        int quantityToBuy = Integer.parseInt(parts[2]);
                        unitPrice = product2Price.get(productName);
                        balance -= unitPrice * quantityToBuy;
                        currentQuantity = product2Quantity.get(productName);
                        product2Quantity.put(productName, currentQuantity + quantityToBuy);
                        //product2BuyDeals.get(productName).add(new Deal(productName,unitPrice,quantityToBuy));
                        break;
                    case "SELL":
                        if (product2Quantity.containsKey(productName)) {
                            currentQuantity = product2Quantity.get(productName);
                            unitPrice = product2Price.get(productName);
                            int quantityToSell = Integer.parseInt(parts[2]);
                            if (quantityToSell <= currentQuantity) {
                                balance += unitPrice * quantityToSell;
                                product2Quantity.put(productName, currentQuantity - quantityToSell);
                                //product2SellDeals.get(productName).add(new Deal(productName,unitPrice,quantityToSell));
                            }
                        }
                        break;
                    case "CHANGE":
                        if (product2Price.containsKey(productName)) {
                            long oldPrice = product2Price.get(productName);
                            long newPrice =  + (long)Integer.parseInt(parts[2]);
                            long difference = newPrice - oldPrice;
                            product2Price.put(productName, newPrice);
                            balance += difference * product2Quantity.get(productName);
                        }
                        break;
                }
            }

        }
            return result;
    }
}
