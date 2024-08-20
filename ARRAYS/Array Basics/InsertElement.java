public class InsertElement {
    public static void insertElement(int arr[], int n, int key, int position) {
        if(position < 1 || position > n) {
            System.out.println("Invalid Position");
            return;
        }
        for(int i = n-1;i >= position-1;i--) {
            arr[i+1] = arr[i];
        }
        arr[position - 1] = key;
    }
    public static void main(String[] args) {
        int arr[] = new int[11]; 
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1; 
        }
        int n = 10;
        int key = 18;
        int position = 12;
        insertElement(arr, n, key, position);
        System.out.print("Array After insertion: ");
        for (int i = 0; i <= n; i++) { 
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
