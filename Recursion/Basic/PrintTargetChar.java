public class PrintTargetChar {
    public static int character(String str,char target,int index){
        if(index >= str.length()){
            return -1;
        }
        if(str.charAt(index) == target){
            return index;
        }
        return character(str, target, index+1); 
    }
    public static void main(String[] args) {
        String str = "Navneet";
        char target = 't';
        int ans = character(str, target, 0);
        System.out.println("Index of "+target+" is found at "+ans);
    }
}
