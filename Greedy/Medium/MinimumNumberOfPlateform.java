/*
You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.

Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.

Note :
1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.

2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".

3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 50000
0 <= AT[i] <= DT[i] <= 2359

Where 'AT[i]' and 'DT[i]' are the elements of the arrival and the departure arrays respectively.

Time limit: 1 sec
Sample Input 1:
2
6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
4
100 200 300 400
200 300 400 500 
*/

import java.util.Arrays;

public class MinimumNumberOfPlateform {
    public static int minPlateform(int at[],int dt[],int n){
        Arrays.sort(at);
        Arrays.sort(dt);
        int i = 0,j = 0;
        int count = 0,maxCount = 0;
        while(i< n){
            if(at[i] <= dt[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int At[] = {900,945,955,1100,1500,1800};
        int DT[] = {920,1200,1130,1150,1900,2000};
        int n = At.length;
        System.out.println(minPlateform(At, DT, n));
    }
}
