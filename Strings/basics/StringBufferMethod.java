public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Navneet");
        System.out.println("Appending at the ened of str: "+str.append(" Singh"));
        System.out.println("character at 4th index: "+str.charAt(4));
        System.out.println("Deleting charcter at 4th index: "+str.deleteCharAt(4));
        System.out.println("substring after 4th index: "+str.substring(4));
        System.out.println(str.insert(0, "Hello "));
    }
}
