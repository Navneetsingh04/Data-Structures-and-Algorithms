/*
L.C: 86. Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 
Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/
public class PartitionList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node createLL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
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
    public static Node partition(Node head,int x){
        Node before = new Node(0);
        Node after = new Node(0);
        Node beforeCurr = before;
        Node afterCurr = after;

        while(head != null){
            if(head.data < x){
                beforeCurr.next = head;
                beforeCurr = beforeCurr.next;
            }
            else{
                afterCurr.next = head;
                afterCurr = afterCurr.next;
            }
            head = head.next;
        }
        afterCurr.next = null;
        beforeCurr.next = after.next;
        return before.next;
    }
    public static void main(String[] args) {
        int arr[] = {1,4,3,2,5,2};
        int x = 3;
        Node head = createLL(arr);
        System.out.print("Linked list before Partition: ");
        printLL(head);
        partition(head, x);
        System.out.print("Linked list after Partition: ");
        printLL(head);

    }
}
