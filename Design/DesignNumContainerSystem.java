import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignNumContainerSystem {
    Map<Integer,Integer> idxToNum;
    Map<Integer,PriorityQueue<Integer>> numToIdx;
    public DesignNumContainerSystem() {
        idxToNum = new HashMap<>();
        numToIdx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        idxToNum.put(index, number); 
        numToIdx.putIfAbsent(number, new PriorityQueue<>());
        numToIdx.get(number).offer(index);
    }
    public int find(int number) {
        if (!numToIdx.containsKey(number)) {
            return -1;
        }
        PriorityQueue<Integer> pq = numToIdx.get(number);
        while (!pq.isEmpty()) { 
            int idx = pq.peek();
            if (idxToNum.get(idx) == number) {
                return idx;
            }
            pq.poll(); 
        }
        return -1;
    }
    public static void main(String[] args) {
        DesignNumContainerSystem system = new DesignNumContainerSystem();
        
        system.change(1, 10);
        system.change(2, 10);
        system.change(3, 20);
        System.out.println(system.find(10));
        System.out.println(system.find(20)); 
        system.change(1, 20);
        System.out.println(system.find(10)); 
        System.out.println(system.find(20)); 
    }
}
