import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Router {
    int n;
    Map<String,int[]> packetStore;  // key -> packet {src, dest, timeStamp}
    Map<Integer,List<Integer>> destTime;  // destination -> timestamp list
    Map<Integer,Integer> startIdx;  // dest -> index of first valid timestamp
    Queue<String> queue;  // FIFO queue for packets

    public Router(int memoryLimit){
        n = memoryLimit;
        packetStore = new HashMap<>();
        destTime = new HashMap<>();
        startIdx = new HashMap<>();
        queue = new LinkedList<>();
    }

    private String makeKey(int src, int dest, int timeStamp){
        return src + "#" + dest + "#" + timeStamp;
    }
    
    public boolean addPacket(int source, int destination, int timestamp){
        String key = makeKey(source,destination,timestamp);
        if(packetStore.containsKey(key)) return false;   // duplicate
        if(packetStore.size() >= n){
            forwardPacket();     // remove oldest packet
        }

        packetStore.put(key, new int[]{source, destination, timestamp});
        queue.offer(key);

        destTime.putIfAbsent(destination, new ArrayList<>());
        destTime.get(destination).add(timestamp);

        startIdx.putIfAbsent(destination,0);

        return true;
    }
    
    public int[] forwardPacket(){
        if(packetStore.isEmpty()) return new int[0];

        String key = queue.poll();
        int[] packet = packetStore.get(key);
        packetStore.remove(key);

        int dest = packet[1];
        int idx = startIdx.get(dest);
        startIdx.put(dest, idx + 1);

        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime){
        if(!destTime.containsKey(destination)) return 0;

        List<Integer> list = destTime.get(destination);
        int idx = startIdx.get(destination);
        int left = lowerBound(list,startTime,idx);
        int right = upperBound(list,endTime,idx);

        return right - left;
    }

    private int lowerBound(List<Integer> list, int target, int startIdx){
        int low = startIdx, high = list.size();
        while(low < high){
            int mid = (low +high)/2;
            if(list.get(mid) >= target) high = mid;
            else low = mid+1;
        }
        return low;
    }

    private int upperBound(List<Integer> list, int target, int startIdx){
        int low = startIdx, high = list.size();
        while(low < high){
            int mid = (low + high)/2;
            if(list.get(mid) > target) high = mid;
            else low = mid+1;
        }
        return low;
    }
    public static void main(String[] args){
        Router router = new Router(3);
        System.out.println(router.addPacket(1,4,90));  
        System.out.println(router.addPacket(2,5,90)); 
        System.out.println(router.addPacket(1,4,90));  
        System.out.println(router.addPacket(3,5,95));  
        System.out.println(router.addPacket(4,5,105));  
        System.out.println(Arrays.toString(router.forwardPacket())); 
        System.out.println(router.addPacket(5,2,110));  
        System.out.println(router.getCount(5,100,110)); 
    }
}
