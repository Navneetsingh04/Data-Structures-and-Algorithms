class Node{
    Node next;
    Node prev;
    int data;
    Node(int data,Node next,Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DeleteHead {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node deletehead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        Node head = convertToLL(arr);
        System.out.print("Linked List before Head Deletion: ");
        printLL(head);
        head = deletehead(head);
        System.out.print("Linked List After Head Deletion: ");
        printLL(head);
    }
}
