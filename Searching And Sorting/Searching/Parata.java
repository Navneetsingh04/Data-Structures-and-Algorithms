/*
IEEE is having its AGM next week and the president wants to serve cheese prata after the meeting. The subcommittee members are asked to go to food connection and get P (P<=1000) pratas packed for the function. The stall has L cooks (L<=50) and each cook has a rank R (1<=R<=8). A cook with a rank R can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes, 1 more prata in 3R minutes and so on (he can only cook a complete prata) (For example if a cook is ranked 2, he will cook one prata in 2 minutes one more prata in the next 4 mins an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he does not have enough time for the 4th prata). The webmaster wants to know the minimum time to get the order done. Please write a program to help him out.

Input
The first line tells the number of test cases. Each test case consist of 2 lines. In the first line of the test case we have P the number of prata ordered. In the next line the first integer denotes the number of cooks L and L integers follow in the same line each denoting the rank of a cook.

Output
Print an integer which tells the number of minutes needed to get the order done.

Example
Input:
3
testcase 1
10
4 
1 2 3 4
testcase 2
8
1 
1
testcase 3
8
8 
1 1 1 1 1 1 1 1

Output:
12
36
1
 */
import java.util.Scanner;
public class Parata {
    static boolean isPossible(int rank[],int parata,int mid){
        int currParata = 0;
        for(int i = 0;i<rank.length;i++){
            int r = rank[i];
            int j= 1;
            int timeTaken = 0;
            while(true){
                if(timeTaken+j*r <= mid){
                    currParata++;
                    timeTaken += j*r;
                    j++;
                }
                else{
                    break;
                }
            }   
        }
        return currParata>=parata;
    }
    public static int totalTime(int rank[],int parata){
        int s = 0;
        // find maxRank and then multiply with maxRank((parata+(parata+1))/2)
        int max = rank[0];
        for(int i = 0;i<rank.length;i++){
            if(rank[i]>max){
                max = rank[i];
            }
        }
        int end = max*((parata*(parata+1))/2);
        int ans = 0;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(isPossible(rank,parata,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        // System.out.print("Enter the no of test Cases: ");
        // int testcase = s.nextInt();
        System.out.print("Enter number of parata: ");
        int parata = s.nextInt();
        System.out.print("Enter number of cooks: ");
        int cook = s.nextInt();
        int rank[] = new int[cook];
        for(int i = 0;i<cook;i++){
            System.out.print("Enter the rank of "+(i+1)+" cook: ");
            rank[i] = s.nextInt();
        }
        System.out.println("Minimum time to make parat is: "+totalTime(rank, parata));
        s.close();
    }
}