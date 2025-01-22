/*
Delete all occurrences of a given key in a doubly linked list

You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.

Example2:

Input: 
9<->1<->3<->4<->5<->1<->8<->4
9
Output: 
1<->3<->4<->5<->1<->8<->4
Explanation: 
All Occurences of 9 have been deleted.
 */
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
public class DeleteAllOccurencesOfDLL{
    public static Node push(Node head,int data){
        Node newNode = new Node(data);
        newNode.next = head;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }
    public static Node deleteAllOccurence(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } 
                else {
                    Node nextNode = temp.next;
                    Node prevNode = temp.prev;
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                }
                // Move temp to the next node
                temp = temp.next;
            } 
            else {
                temp = temp.next;
            }
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
    public static void main(String args[]){
        Node head = null;
        head = push(head, 10);
        head = push(head, 4);
        head = push(head, 10);
        head = push(head, 6);
        head = push(head, 10);
        System.out.print("Original DLL: ");
        printLL(head);
        int key = 10;
        head = deleteAllOccurence(head, key);
        System.out.print("DLL after deletion of "+key+":");
        printLL(head);
    }
}
