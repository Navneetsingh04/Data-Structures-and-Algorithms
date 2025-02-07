/*
L.C: 1669. Merge In Between Linked Lists

You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
The blue edges and nodes in the following figure indicate the result:

Build the result list and return its head.
Example 1:
Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

Example 2:
Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.
 
Constraints:
3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104 
*/
public class MergInBetweenLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
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
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node mergInBetween(Node list1,Node list2,int a,int b){
        // Find the node just before the ath node
        Node prevA = list1;
        for(int i = 1;i<a;i++){
            prevA = prevA.next;
        }
        // Find the node just after the bth node
        Node nextB = prevA;
        for(int i = a;i<=b;i++){
            nextB = nextB.next;
        }
        // Connect prevA to the head of list2
        prevA.next = list2;
        Node tailList2 = list2;
        while(tailList2.next != null){
            tailList2 = tailList2.next;
        }
        // Connect the tail of list2 to nextB
        tailList2.next = nextB;
        return list1;
    }
    public static void main(String[] args) {
        int arr1[] = {0,1,2,3,4,5,6};
        int arr2[] = {1000,1001,1002,1003,1004};
        int a = 2;
        int b = 5;
        Node list1 = convertToLL(arr1);
        Node list2 = convertToLL(arr2);

        Node finalList = mergInBetween(list1, list2, a, b);
        printLL(finalList);
    }
}
