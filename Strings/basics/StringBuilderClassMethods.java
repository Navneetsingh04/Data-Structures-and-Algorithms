public class StringBuilderClassMethods {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello");
        System.out.println("Capacity of the StringBuilder str: "+str.capacity());
        System.out.println("Appending string: "+str.append(" World"));
        System.out.println("Appending intger: "+str.append(4));
        System.out.println("Appending float: "+str.append(4.5f));
        System.out.println("Appending double: "+str.append(4.23));
        System.out.println("Appending boolean: "+str.append(true));
        System.out.println("Appending character: "+str.append('N'));
        System.out.println("Appending long: "+str.append(4L));
        System.out.println("Char at 0 index: "+str.charAt(0));
        System.out.println("delete char at index 11: "+str.deleteCharAt(11));
        System.out.println("delete charcater in a substring: "+str.delete(11, str.length()));
        System.out.println("codepoint at index 6: "+str.codePointAt(6));
        System.out.println("indexOf string llo: "+str.indexOf("llo"));
        System.out.println("inserting the String at position 11: "+str.insert(11, "world"));
        System.out.println("lastIndex of world is: "+str.lastIndexOf("world"));
        System.out.println("replacing the world from 11 index to the last index with India: "+str.replace(11, str.length(), "India"));
        System.out.println("Subsequence "+str.subSequence(0, 5));
        System.out.println("substring from starting: "+str.substring(0));
        System.out.println("Reversing the String: "+str.reverse());
        System.out.println("toString "+str.toString());
        // str.trimToSize();
        
    }
}
