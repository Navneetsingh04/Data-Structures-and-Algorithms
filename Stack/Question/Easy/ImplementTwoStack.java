public class ImplementTwoStack {
    int arr[];
    int size;
    int top1;
    int top2;

    ImplementTwoStack(int size){
        arr = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }
    public void push1(int data){
        if(top2 - top1 == 1){
            System.out.println("Overflow");
        }
        else{
            top1++;
            arr[top1] = data;
        }
    }
    public void push2(int data){
        if(top2 - top1 == 1){
            System.out.println("Overflow");
        }
        else{
            top2--;
            arr[top2] = data;
        }
    }
    public void pop1(){
        if(top1 == -1){
            System.out.println("UderFlow");
        }
        else{
            arr[top1] = 0;
            top1--;
        }
    }
    public void pop2(){
        if(top2 == size){
            System.out.println("UnderFlow");
        }
        else{
            arr[top2] = 0;
            top2++;
        }
    }
    public void print(){
        System.out.println("Top1 "+top1);
        System.out.println("Top2 "+top2);
        for(int i =0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        ImplementTwoStack stack = new ImplementTwoStack(6);
        stack.print();
        stack.push1(10);
        stack.print();
        stack.push1(20);
        stack.print();
        stack.push2(100);
        stack.print();
        stack.push2(300);
        stack.print();
        stack.push2(400);
        stack.print();
        stack.push2(500);
        stack.print();
        stack.push1(50);
        stack.print();
        stack.pop1();
        stack.pop1();
        stack.print();
        stack.pop1();
        stack.print();


    }
}
