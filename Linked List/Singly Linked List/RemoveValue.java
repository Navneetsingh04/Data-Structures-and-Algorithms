class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class RemoveValue{
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
    public static Node deleteK(Node head,int value){
        if(head == null){
            return null;
        }
        if(head.data == value){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == value){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
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
    public static void main(String args[]){
        int arr[] = new int[]{10,20,30,40,50,60};
        Node head = convertArr2LL(arr);
        System.out.print("Linked list Before Deletion: ");
        print(head);
        head = deleteK(head, 40);
        System.out.print("\nLinked list After Deletion: ");
        print(head);
    }
}