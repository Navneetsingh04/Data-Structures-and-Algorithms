public class SubSequence {
    public static void subSequence(String str,String output,int index){
        if(index >= str.length()){
            System.out.println("-> "+output);
            return;
        }
        char ch = str.charAt(index);
        // exclude
        subSequence(str, output, index+1);
        // include
        subSequence(str, output+ch, index+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        String outpuString = "";
        subSequence(str,outpuString, 0);
    }
}
