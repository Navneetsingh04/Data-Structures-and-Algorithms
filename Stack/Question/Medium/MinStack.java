/*
L.C: 155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

import java.util.ArrayList;
public class MinStack {
    class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    ArrayList<Pair> st;
    public MinStack(){
        st = new ArrayList<>();
    }
    public void push(int data){
        if(st.isEmpty()){
            st.add(new Pair(data, data));
        }
        else{
            int min = st.get(st.size()-1).second;
            st.add(new Pair(data,Math.min(min,data)));
        }
    }
    public void pop(){
        if(!st.isEmpty()){
            st.remove(st.size()-1);
        }
    }
    public int top(){
        if(!st.isEmpty()){
            Pair rightMostPair = st.get(st.size()-1);
            return rightMostPair.first;

        }
        return -1;
    }
    public int getMin(){
        if(!st.isEmpty()){
            Pair rightMostPair = st.get(st.size()-1);
            return rightMostPair.second;

        }
        return -1;
    }
    public static void main(String args[]){
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.getMin(); 
        minStack.pop();
        System.out.println(minStack.top());
        minStack.top();   
        System.out.println(minStack.getMin());
    }
}
