public class NStackinArray {
    int arr[];
    int top[];
    int next[];
    int n;  //no. of Stack
    int size;  //sizee of main array
    int freeSport;  //free space in main Array

    public NStackinArray(int n,int size){
        this.n = n;
        this.size = size;
        freeSport = 0;
        arr = new int[size];
        top = new int[n];
        next = new int[size];

        for(int i = 0;i<n;i++){
            top[i] = -1;
        }

        for(int i = 0;i<size;i++){
            next[i] = i+1;
        }
        next[size-1] = -1;
    }
    // push x into mth Stack
    public boolean push(int x,int m){
        if(freeSport == -1){
            return false;
        }
        // 1.find index
        int index = freeSport;

        // 2.update freesport
        freeSport = next[index];

        // 3.insert
        arr[index] = x;
        // 4.update next
        next[index] = top[m-1];
        // 5.update top 
        top[m-1] = index;
        return true;
    }
    // pop from m stack
    public int pop(int m){
        if(top[m-1] == -1){
            return -1;  //stack underFlow
        }
        int index = top[m-1];
        top[m-1] = next[index];
        int popedElement = arr[index];
        next[index] = freeSport;
        freeSport = index;
        return popedElement;
    }
    public static void main(String[] args) {
        NStackinArray obj = new NStackinArray(3,6);
        System.out.println(obj.push(10, 1));
        System.out.println(obj.push(10, 1));
        System.out.println(obj.push(10, 1));
        System.out.println(obj.push(14, 2));
        System.out.println(obj.push(15, 3));
        System.out.println(obj.pop(1));
        System.out.println(obj.pop(2));

    }
}
