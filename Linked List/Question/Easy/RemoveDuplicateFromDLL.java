/*
Remove duplicates from a sorted doubly linked list

Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Example 1:

Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.

Example 2:
Input:
n = 7
1<->2<->2<->3<->3<->4<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of nodes with values 2,3 and 4 are 
retained, rest repeating nodes are deleted.
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
public class RemoveDuplicateFromDLL {
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

    public static Node removeDuplicate(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null){
                nextNode.prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,1,1,2,3,3,4};
        Node head = convertToLL(arr);
        System.out.print("DLL before removal of Duplicates: ");
        printLL(head);
        head = removeDuplicate(head);
        System.out.print("DLL After removal of Duplicates: ");
        printLL(head);
    }
}
