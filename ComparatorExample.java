import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,5,7,8,9,5,6);
        System.out.println(list);
        // Comparator<Integer> com = new Comparator<Integer>(){
        //     public int compare(Integer a,Integer b) {
        //         int t1 = Integer.bitCount(a);
        //         int t2 = Integer.bitCount(b);
        //         if(t1 == t2){
        //             return a-b;
        //         }
        //         else{
        //             return t1-t2;
        //         }
        //     }
        // };
        // Collections.sort(list,com);
        List<String> name = new ArrayList<>();
        Collections.addAll(name, "Rohan","sohan","Ram","virat","shikher","rohit","Dhoni");
        Collections.sort(name,(a,b) -> {
            int n = a.length();
            int m = b.length();
            return n-m;
        });
        System.out.println(name);
        Collections.sort(list,(a,b) -> {
            int t1 = Integer.bitCount(a);
            int t2 = Integer.bitCount(b);
            if(t1 == t2){
                return a-b;
            }
            else{
                return t1-t2;
            }
        });
        System.out.println(list);
    }
}
