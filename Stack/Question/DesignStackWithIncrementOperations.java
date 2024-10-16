public class DesignStackWithIncrementOperations {
    int size;
    int arr[];
    int top;
    public DesignStackWithIncrementOperations(int maxSize) {
        size = maxSize;
        arr = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top == size-1){
            return;
        }
        top++;
        arr[top] = x;
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        int result = arr[top];
        top--;
        return result;
        
    }
    
    public void increment(int k, int val) {
        if(top == -1){
            return;
        }
        int limit = Math.min(k,top+1);
        for(int i = 0; i<limit;i++){
            arr[i] += val;
        }
    }
    public static void main(String[] args) {
        DesignStackWithIncrementOperations stack = new DesignStackWithIncrementOperations(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        stack.increment(4, 100);
        System.out.println("Stack after incrementing bottom 4 elements by 100:");
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(stack.arr[i]+" ");
        }
    }
}
