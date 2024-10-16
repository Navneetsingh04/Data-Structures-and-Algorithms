class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteTail {
    public static Node convertArr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;  
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        Node head = convertArr2LL(arr);
        System.out.print("Linked list Before deletion: ");
        print(head);
        head = removeTail(head);
        System.out.print("\nLinked list After deletion: ");
        print(head);
    }
}