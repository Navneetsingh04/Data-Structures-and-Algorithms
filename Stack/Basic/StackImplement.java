public class StackImplement {
    int arr[];
    int size;
    int top;
    StackImplement(int size){
        arr = new int[size];
        this.size = size;
        this.top = -1;
    }
    public void push(int data){
        if(top == size-1){
            System.out.println("Stack Overflow");
        }
        else{
            top++;
            arr[top] = data;
        }
    }
    public void pop(){
        if(top == -1){
            System.out.println("Stack underFlow");
        }
        else{
            top--;
        }
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int getTop(){
        if(top == -1){
            System.out.println("Stack empty");
            return -1;
        }
        else{
            return arr[top];
        }
    }
    public int getSize(){
        return top+1;
    }
    public void print(){
        System.out.print("\nTop: "+top);
        System.out.print("\nTop Element: "+getTop());
        System.out.print("\nStack: ");
        for(int i = 0;i<getSize();i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        StackImplement st = new StackImplement(8);
        st.push(1);
        st.print();
        st.push(2);
        st.print();
        st.push(3);
        st.print();
        st.push(4);
        st.print();

        st.pop();
        st.pop();
        st.pop();
        st.print();
        System.out.println("Size of Stack is: "+st.getSize());
    }
}
