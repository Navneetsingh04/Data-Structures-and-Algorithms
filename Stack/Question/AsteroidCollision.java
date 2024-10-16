/*
L.C: 735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0 
*/

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int asteroid[]){
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroid){
            boolean destroy = false;
            if(ast>0){
                st.push(ast);
            }
            else{
                // -ve
                if(st.isEmpty() || st.peek()<0){
                    st.push(ast);
                }
                else{
                    // collision
                    while(!st.isEmpty() && st.peek()>0){
                        if(Math.abs(ast) == st.peek()){
                            destroy = true;
                            st.pop();
                            break;
                        }
                        else if(Math.abs(ast) > st.peek()){
                            st.pop();
                        }
                        else{
                            destroy = true;
                            break;
                        }
                    }
                    if(!destroy){
                        st.push(ast);
                    }
                }
            }
        }
        int ans[] = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
    public static void main(String args[]){
        // int arr[] = {-1,3,2,-3};
        // int arr[] = {10,2,-5};
        // int arr[] = {8,-8};
        int arr[] = {5,10,-5};
        int ans[] = asteroidCollision(arr);
        System.out.print("[");
        for(int i = 0;i<ans.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("]");
    }
}
