import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aug_16_MaxDistanceInArray {
    public static int maxDistance(List<List<Integer>> arrays) {
        int mini = arrays.get(0).get(0);
        int maxi = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for(int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currMax - mini));
            maxDistance = Math.max(maxDistance, Math.abs(currMin - maxi));

            mini = Math.min(mini, currMin);
            maxi = Math.max(maxi, currMax);
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3)));
        arrays.add(new ArrayList<>(Arrays.asList(4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3)));
        int distance = maxDistance(arrays);
        System.out.println("Maximum Distance: " + distance); 
    }
}
