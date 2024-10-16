import java.util.ArrayList;
public class ReturnDigit {
    public static void returndigit(int num,int temp,ArrayList<Integer> list){
        if(num == 0){
            return;
        }
        temp = num%10;
        returndigit(num/10, temp,list);
        list.add(temp);
        
    }
    public static void main(String[] args) {
        int num = 4215;
        int temp = num;
        ArrayList<Integer> list = new ArrayList<>();
        returndigit(num, temp,list);
        System.out.print("Digit of number is : ");
        for(int n : list){
            System.out.print(n+" ");
        }
    }
}
