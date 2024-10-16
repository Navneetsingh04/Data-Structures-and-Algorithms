
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisor {
    public static void printDivisor(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i*i <= num;i++){
            if(num%i == 0){
               list.add(i);
                if((num/i) != i){
                    list.add(num/i);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main(String[] args) {
        int num = 36;
        printDivisor(num);
    }
}
