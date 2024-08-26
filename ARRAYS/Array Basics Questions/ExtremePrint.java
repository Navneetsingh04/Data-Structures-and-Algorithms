// Extreme print in the given Array
/*
    Array Before ExtremePrint: 
    45 545 11 52 5 89 63 25 42 15 32 
    Array after ExtremePrint: 
    45 32 545 15 11 42 52 25 5 63 89
 */

public class ExtremePrint {
    public static void main(String args[]){
        int arr[] = new int[]{45,545,11,52,5,89,63,25,42,15,32};
        System.out.println("Array Before ExtremePrint: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int l = 0;
        int h = arr.length-1;
        System.out.println("Array after ExtremePrint: ");
        while(l<=h){
            if(l==h){
                System.out.print(arr[l]);
            }
            else{
                System.out.print(arr[l]+" ");
                System.out.print(arr[h]+" ");
            }
            l++;
            h--;
        }
    }
}
