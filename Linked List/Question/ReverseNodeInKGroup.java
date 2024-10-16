/*
L.C: 25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 
Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
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
public class ReverseNodeInKGroup {
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
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
    public static Node getKthNode(Node temp,int k){
        k -= 1;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public static Node reverseLL(Node head){
        Node prev = null;
        Node next = null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node reverseKGroup(Node head,int k){
        Node temp = head;
        Node prevNode = null;
        while(temp != null){
            Node kthNode = getKthNode(temp,k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        Node head = convertToLL(arr);
        System.out.print("Linked list Before Reversal of KGroup: ");
        printLL(head);
        head = reverseKGroup(head, k);
        System.out.print("Linked list After Reversal of KGroup: ");
        printLL(head);
    }
}
