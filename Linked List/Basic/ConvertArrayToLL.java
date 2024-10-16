public class ConvertArrayToLL {
    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{12,4,5,7,8};
        Node head = convertToLL(arr);
        System.out.println("First element is "+head.data);
    }
}