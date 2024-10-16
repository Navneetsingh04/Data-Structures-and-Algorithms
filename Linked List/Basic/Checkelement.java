public class Checkelement {
    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean checkifpresent(Node head,int element){
        Node temp = head;
        while(temp != null){
            if(temp.data == element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String args[]){
        int arr[] = new int[]{12,4,5,7,8};
        Node head = new Node(arr[0]);
        boolean ans = checkifpresent(head, 15);
        if(ans){
            System.out.println("Element is present in the linked list");
        }
        else{
            System.out.println("Element is not present in the linked list");
        }
    }
}