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
public class ReverseDLL {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = null;
        Node current = head;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        return temp.prev;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        Node head = convertToLL(arr);
        System.out.print("Linked List before Reversal: ");
        printLL(head);
        head = reverseDLL(head);
        System.out.print("Linked List After Reversal: ");
        printLL(head);
    }
}
