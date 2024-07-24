import java.util.Stack;
public class StackBasic {
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();

        // insertion

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        // remove
        stack.pop();

        System.out.println(stack.size());

        if(stack.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }

        System.out.println(stack.peek());
    }
}
