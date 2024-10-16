// package ARRAY;
public class CreateArray{
    public static void main(String args[]){
        int arr[] = new int[10];
        float arr1[] = new float[12];
        long arr2[] = new long[40];
        char arr3[] = new char[15];
        String arr4[] = new String[20];

        int ar[] = new int[]{1,2,3,4,5,6};
        System.out.println(arr.length);
        System.out.println(arr1.length);
        System.out.println(arr2.length);
        System.out.println(arr3.length);
        System.out.println(arr4.length);
        // Accesing each element of ar array
        System.out.print("Itrating the Array: ");
        // for(int i = 0;i<ar.length;i++){
        // System.out.print(ar[i]+" ");
        // }

        // For Each loop
        for(int i :ar){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("elemnt at 4th index: "+ar[4]);

    }
}