/*
Allocate minimum number of pages

You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}

Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105

*/

// Time Complexity: O(NlogN)
// Space Complexity: O(1)

public class BookAllocation {
   static boolean isPossibleSol(int arr[],int book,int student,int sol){
        int pageSum = 0;
        int count = 1;
        for(int i = 0;i<book;i++){
            if(arr[i]>sol){
                 return false;
            }
            else if(pageSum+arr[i]>sol){
                count++;
                pageSum = arr[i];
                if(count>student){
                    return false;
                }
            }
            else{
                pageSum += arr[i];
            }
        }
        return true;
    }
public static int bookAllocation(int arr[],int book,int student){
    if(student>book){
        return -1;
    }
    int start = 0;
    int sum = 0;
    int ans  = -1;
    for(int i: arr){
        sum += i;
    }
    int end = sum;
    while(start<=end){
    int mid = start+(end-start)/2;
        if(isPossibleSol(arr,book,student,mid)){
            ans = mid;
            end = mid-1;
        }
        else{
            start = mid+1;
        }
    }
    return ans;
}
public static void main(String[] args) {
    int book = 4;
    int arr[] = new int[]{12,34,67,90};
    int student = 2;
    int result = bookAllocation(arr, book, student);
    System.out.println(result);
    }
}