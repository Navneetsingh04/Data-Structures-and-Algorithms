/*
L.c: 2391. Minimum Amount of Time to Collect Garbage

You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.

You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.

There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.

Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.

Return the minimum number of minutes needed to pick up all the garbage.

Example 1:

Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
Output: 21
Explanation:
The paper garbage truck:
1. Travels from house 0 to house 1
2. Collects the paper garbage at house 1
3. Travels from house 1 to house 2
4. Collects the paper garbage at house 2
Altogether, it takes 8 minutes to pick up all the paper garbage.
The glass garbage truck:
1. Collects the glass garbage at house 0
2. Travels from house 0 to house 1
3. Travels from house 1 to house 2
4. Collects the glass garbage at house 2
5. Travels from house 2 to house 3
6. Collects the glass garbage at house 3
Altogether, it takes 13 minutes to pick up all the glass garbage.
Since there is no metal garbage, we do not need to consider the metal garbage truck.
Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.
*/
public class GarbageColllection {
    public static int garbageColllection(String[] garbage,int[] travel){
        // pick time 
        int pickP = 0;
        int pickM = 0;
        int pickG = 0;
        // travel time
        int travelP = 0;
        int travelM = 0;
        int travelG = 0;

        // last index where each truck can go
        int lastP = 0;
        int lastM = 0;
        int lastG = 0;

        // claculate the pic time and travel time

        for(int i=0;i<garbage.length;i++){
            String curr = garbage[i];
            for(int j = 0;j<curr.length();j++){
                char ch = curr.charAt(j);
                if(ch == 'P'){
                    pickP++;
                    lastP = i;
                }
                else if(ch == 'G'){
                    pickG++;
                    lastG = i;
                }
                else{
                    pickM++;
                    lastM = i;
                }
            }
        }
        // total time for collecting paper
        for(int i = 0;i<lastP;i++){
            travelP += travel[i];
        }
        // total time for collecting Glass
        for(int i = 0;i<lastG;i++){
            travelG += travel[i];
        }
        // total time for collecting Metal
        for(int i = 0;i<lastM;i++){
            travelM += travel[i];
        }

        int ans = (pickP+travelP)+(pickM+travelM)+(pickG+travelG);
        return ans;
    }
    public static void main(String args[]){
        String garbage[] = new String[]{"G","P","GP","GG"};
        int[] travel = new int[]{2,4,3};
        int result = garbageColllection(garbage, travel);
        System.out.println("The minimum number of minutes needed to pick up all the garbag: "+result);
    }
}
