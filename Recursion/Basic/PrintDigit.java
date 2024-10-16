public class PrintDigit {
    public static int digit(int arr[],int index,int temp){
        if(index >= arr.length){
            return temp;
        }
        temp = temp*10+arr[index];
        return digit(arr, index+1,temp);

    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,2,1,7};
        int num = digit(arr, 0, 0);
        System.out.println("Number is: "+num);
    }
}


