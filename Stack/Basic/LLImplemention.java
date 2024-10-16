public class LLImplemention {
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node top;
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data+" pushed into stack");
    }
    public int pop(){
        if(top == null){
            System.out.println("Stack UnderFlow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    public int peek(){
        if(top == null){
            System.out.println("Stack is Empty");
            return -1;
        }
        return  top.data;
    }
    public boolean Empty(){
        return top == null;
    }
    public void print(){
        if(top == null){
            System.out.println("Stack is Empty");
        }
        Node temp = top;
        System.out.print("Element of stack is: ");
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LLImplemention stack = new LLImplemention();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        stack.print();
        System.out.println("Is stack empty? " + stack.Empty());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        stack.print();
    }
}
