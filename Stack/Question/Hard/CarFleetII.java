/*
L.C: 1776. Car Fleet II

There are n cars traveling at different speeds in the same direction along a one-lane road. You are given an array cars of length n, where cars[i] = [positioni, speedi] represents:

positioni is the distance between the ith car and the beginning of the road in meters. It is guaranteed that positioni < positioni+1.
speedi is the initial speed of the ith car in meters per second.
For simplicity, cars can be considered as points moving along the number line. Two cars collide when they occupy the same position. Once a car collides with another car, they unite and form a single car fleet. The cars in the formed fleet will have the same position and the same speed, which is the initial speed of the slowest car in the fleet.

Return an array answer, where answer[i] is the time, in seconds, at which the ith car collides with the next car, or -1 if the car does not collide with the next car. Answers within 10-5 of the actual answers are accepted.

Example 1:

Input: cars = [[1,2],[2,1],[4,3],[7,2]]
Output: [1.00000,-1.00000,3.00000,-1.00000]
Explanation: After exactly one second, the first car will collide with the second car, and form a car fleet with speed 1 m/s. After exactly 3 seconds, the third car will collide with the fourth car, and form a car fleet with speed 2 m/s.
Example 2:

Input: cars = [[3,4],[5,4],[6,3],[9,1]]
Output: [2.00000,1.00000,1.50000,-1.00000]
 
Constraints:

1 <= cars.length <= 105
1 <= positioni, speedi <= 106
positioni < positioni+1
*/

import java.util.Stack;

public class CarFleetII {
    public static double[] getCollisionTimes(int[][] cars){
        int n = cars.length;
        double[] ans = new double[n];
        Stack<Integer> st = new Stack<>();

        // Initialize all the collision time to -1;
        for(int i = 0;i<n;i++){
            ans[i] = -1;
        }
        for(int i = n-1;i>=0;i--){
            int pos = cars[i][0];
            int speed = cars[i][1];

            // processing the stack to find the collision time
            while(!st.isEmpty()){
                int topIndex = st.peek();
                int topPos = cars[topIndex][0];
                int topSpeed = cars[topIndex][1];

                // if the current car spedd is less then or equal to top car's speed,so it will never catch up so we remove the top car from the stack

                if(speed <= topSpeed){
                    st.pop();
                    continue;
                }
                // Calculate the collision time with the top car in the stack
                double collisionTime = (double)(topPos-pos)/(speed-topSpeed);

                // If the collision time is less than the collision time of the top car
                // with any car in front of it or if the top car has no collision time
                // we update the collision time.

                if(collisionTime < ans[topIndex] || ans[topIndex] == -1){
                    ans[i] = collisionTime;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        // int cars[][] = {{1,2},{2,1},{4,3},{7,2}};
        int cars[][] = {{3,4},{5,4},{6,3},{9,1}};
        double ans[] = getCollisionTimes(cars);
        System.out.print("Time for car fleet: ");
        for(double value : ans){
            System.out.print(value+", ");
        }
    }
}
