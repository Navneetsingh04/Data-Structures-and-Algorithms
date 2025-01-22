/*
Problem statement
Given a linked list of 'N' nodes, where each node has an integer value that can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and the return the head of the sorted list.

Example:
Given linked list is 1 -> 0 -> 2 -> 1 -> 2. 
The sorted list for the given linked list will be 0 -> 1 -> 1 -> 2 -> 2.
 */
class Node{
    Node next;
    int data;
    
    Node(int data,Node next){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class Sort0s1s2sInLL {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i =1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
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
    public static Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else if(temp.data == 2){
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null)?(oneHead.next):(twoHead.next);
        one.next = twoHead.next;
        two.next = null;

        Node newnode = zeroHead.next;
        return newnode;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,0,0,1,2,0,1,0,2};
        Node head = convertToLL(arr);
        System.out.print("Linked List Before Sorting : ");
        printLL(head);
        head = sort(head);
        System.out.print("Linked List After Sorting : ");
        printLL(head);
    }
}