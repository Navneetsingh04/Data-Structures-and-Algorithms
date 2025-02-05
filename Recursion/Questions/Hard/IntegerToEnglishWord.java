/*
L.C: 273. Integer to English Words

Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 
Constraints:

0 <= num <= 231 - 1

*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
public class IntegerToEnglishWord {
        List<Map.Entry<Integer,String>> mp = Arrays.asList(
        new SimpleEntry<>(1000000000, "Billion"),
        new SimpleEntry<>(1000000, "Million"),
        new SimpleEntry<>(1000, "Thousand"),
        new SimpleEntry<>(100, "Hundred"),
        new SimpleEntry<>(90, "Ninety"),
        new SimpleEntry<>(80, "Eighty"),
        new SimpleEntry<>(70, "Seventy"),
        new SimpleEntry<>(60, "Sixty"),
        new SimpleEntry<>(50, "Fifty"),
        new SimpleEntry<>(40, "Forty"),
        new SimpleEntry<>(30, "Thirty"),
        new SimpleEntry<>(20, "Twenty"),
        new SimpleEntry<>(10, "Ten"),
        new SimpleEntry<>(9, "Nine"),
        new SimpleEntry<>(8, "Eight"),
        new SimpleEntry<>(7, "Seven"),
        new SimpleEntry<>(6, "Six"),
        new SimpleEntry<>(5, "Five"),
        new SimpleEntry<>(4, "Four"),
        new SimpleEntry<>(3, "Three"),
        new SimpleEntry<>(2, "Two"),
        new SimpleEntry<>(1, "One")
        );
        public String numberToWords(int num){
            if(num == 0){
                return "Zero";
            }
            for(Map.Entry<Integer,String> it:mp){
                if(num>=it.getKey()){
                    String a = "";
                    if(num>=100){
                        a = numberToWords(num/it.getKey())+" ";
                    }
                    String b = it.getValue();
                    String c = "";
                    if(num%it.getKey() != 0){
                        c = " "+numberToWords(num%it.getKey());
                    }
                    return a+b+c;
                }
            }
            return "";
        }
        public static void main(String args[]){
            IntegerToEnglishWord ite = new IntegerToEnglishWord();
            int num = 123456;
            System.out.println(ite.numberToWords(num));
        }
}