/*
61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class RotateLL {
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
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node findNthNode(Node temp,int k){
        int cnt = 1;
        while(temp != null){
            if(cnt == k){
                return temp;
            }
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    public static Node rotateRight(Node head, int k) {
        if(head == null || k == 0){
            return head;
        }
        Node tail = head;
        int  len = 1;
        while(tail.next != null){
            tail = tail.next;
            len += 1;
        }
        if(k%len == 0){
            return head;
        }
        k = k%len;
        tail.next = head;
        Node newLastNode = findNthNode(head,len-k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        int k = 3;
        Node head = convertToLL(arr);
        System.out.print("Linked List before rotation: ");
        printLL(head);
        head = rotateRight(head, k);
        System.out.print("Linked List After rotation: ");
        printLL(head);
    }
}
