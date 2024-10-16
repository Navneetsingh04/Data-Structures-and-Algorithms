
import java.util.Collections;
import java.util.PriorityQueue;

public class maximalScoreAfterKOperation {
    public static long maxElement(int nums[],int k){
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }
        while(k-- > 0){
            int maxElement = pq.poll();
            sum += maxElement;
            pq.add((int)(maxElement/3.0));
        }
        return sum;
    }
    public static void main(String[] args) {
        int nums[] = {10,10,10,10,10};
        int k = 5;
        System.out.println(maxElement(nums,k));
    }
}
