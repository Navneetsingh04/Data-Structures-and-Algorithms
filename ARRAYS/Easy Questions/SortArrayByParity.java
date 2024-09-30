
import java.util.Arrays;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l<=h){
            if(((nums[l]&1) == 1) && ((nums[h]&1) == 0)){
                int temp = nums[l];
                nums[l] = nums[h];
                nums[h] = temp;
                l++;
                h--;
            }
            else if(((nums[l]&1) == 1) && ((nums[h]&1) == 1)){
                h--;
            }
            else{
                l++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int ans[] = sortArrayByParity(nums);
        System.out.println(Arrays.toString(ans));

    }
}
