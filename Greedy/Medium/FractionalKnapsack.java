/*
You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.
Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.

Note:
You are allowed to break the items.
Example:
If 'N = 4' and 'W = 10'. The weights and values of items are weights = [6, 1, 5, 3] and values = [3, 6, 1, 4]. 
Then the best way to fill the knapsack is to choose items with weight 6, 1 and  3. The total value of knapsack = 3 + 6 + 4 = 13.00   

Sample Input 1:
1
6 200
50 40 90 120 10 200 
40 50 25 100 30 45
Sample output 1:
204.00
Explanation of Sample output 1:
The most optimal way to fill the knapsack is to choose full items with weight 10 and value 30, weight 40 and value 50, weight 120 and value 100. Then take weight 30 from the item with weight 50 and value 40.
The total value =  30 + 50 + 100 + (30/50)*(40) = 204.00

Constraints:
1 <= T <= 100
1 <= N <= 5000
1 <= W <= 10^5
1 <= weights[i] <= 10^5
1 <= values[i] <= 10^5 
*/

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class ItemValue{
        int value,weight;
        ItemValue(int val,int wt){
            this.weight = wt;
            this.value = val;
        }
    }
    static class ItemCompartor implements Comparator<ItemValue>{
        public int compare(ItemValue a, ItemValue b){
            double r1 = (double)(a.value)/(double)(a.weight);
            double r2 = (double)(b.value)/(double)(b.weight);
            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        }
    }
    public static double getMaxValue(ItemValue arr[],int W){
        int n = arr.length;
        Arrays.sort(arr, new ItemCompartor());
        int currWeight = 0;
        double finalValue = 0.0;
        for(int i = 0;i<n;i++){
            if(currWeight + arr[i].weight <= W) {
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                int remain = W -currWeight;
                finalValue += ((double)arr[i].value/(double)arr[i].weight*(double)remain);
                break;
            }
        }
        return finalValue;
    }
    public static void main(String[] args) {
        ItemValue[]  arr = {new ItemValue(60,10),
        new ItemValue(100, 20),
        new ItemValue(120, 30)};
        int W = 50;
        System.out.println(getMaxValue(arr, W));

    }
}
