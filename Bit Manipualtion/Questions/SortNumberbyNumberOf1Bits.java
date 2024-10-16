/*
L.C: 1356. Sort Integers by The Number of 1 Bits

You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.

Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 104 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortNumberbyNumberOf1Bits {
    public static int[] sortByBits(int arr[]){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i: arr){
            list.add(i);
        }
        Collections.sort(list,(a,b) -> {
            int t1 = Integer.bitCount(a);
            int t2 = Integer.bitCount(b);
            if(t1 == t2){
                return a-b;
            }
            else{
                return t1-t2;
            }
        });
        for(int i = 0;i<n;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8};
        int ans[] = sortByBits(arr);
    
        System.out.println("Array after BitCount sorting: "+Arrays.toString(ans));
    }
}