public class LastOccurrenceOfChar {
    public static int lastOccurence(String str,char x,int index,int ans){
        if(index >= str.length()){
            return ans;
        }
        if(str.charAt(index) == x){
            ans = index;
        }
        return lastOccurence(str, x, index+1,ans);
    }
    public static void main(String[] args) {
        String str = "abcdedfdjjhjhfhgd";
        char x = 'j';
        int ans = lastOccurence(str, x, 0,-1);
        System.out.println("Last Occurence of "+x+" is "+ans);
    }
}
