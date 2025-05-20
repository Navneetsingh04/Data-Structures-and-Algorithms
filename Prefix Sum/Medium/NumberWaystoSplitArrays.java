public class NumberWaystoSplitArrays {
    public static int waysToSplitArray(int[] nums) {
    long sum = 0;
    for(int i =0;i<nums.length;i++){
        sum += nums[i];
    }
    long leftsum = 0;
    int count = 0;
    for(int i = 0;i<nums.length-1;i++){
        leftsum += nums[i];
        long rightsum = sum-leftsum;
        if(leftsum>=rightsum){
            count++;
        } 
    }
    return count;
    }
    public static void main(String[] args) {
       int nums[] = {10,4,1,3,15};
        System.out.println(waysToSplitArray(nums));
    }
}
