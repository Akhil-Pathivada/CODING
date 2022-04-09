/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/fractional-knapsack-problem/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N) -> for sorting
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
        
        private static class Itemvalue {
                Double cost;
                double weight, value;
                
                // item value function
                public Itemvalue(int weight, int value) {
                        this.weight = weight;
                        this.value = value;
                        cost = new Double((double)value / (double)weight);
                }
        }
        
        private static double getMaxProfit(int[] weights, int[] values, int capacity, int n) {
        
                Itemvalue[] itemvalues = new Itemvalue[n];
                
                for(int i = 0; i < n; ++i) {
                        itemvalues[i] = new Itemvalue(weights[i], values[i]);
                }
                // sorting items by value
                Arrays.sort(itemvalues, new Comparator<Itemvalue>() {
                        @Override
                        public int compare(Itemvalue o1, Itemvalue o2) {
                                return o2.cost.compareTo(o1.cost);
                        }
                });
                double maxProfit = 0d;
                for(Itemvalue item : itemvalues) {
                        
                        int currentWeight = (int)item.weight;
                        int currentValue = (int)item.value;
                        // this weight can be picked while
                        if(capacity - currentWeight >= 0) {
                                maxProfit += currentValue;
                                capacity -= currentWeight;
                        }
                        else { // item cant be picked whole
                                double fraction = (double)capacity / (double)currentWeight;
                                maxProfit += (currentValue * fraction);
                                capacity = (int)(capacity - (currentWeight * fraction));
                                break;
                        }
                }
                return maxProfit;
        }
        
        public static void main(String[] args) {
                
                int[] weights = { 10, 40, 20, 30 };
                int[] valueues = { 60, 40, 100, 120 };
                int capacity = 50;
                
                double maxProfit = getMaxProfit(weights, valueues, capacity, weights.length);
                System.out.println("Maximum valueue we can obtain = " + maxProfit);
        }
}
