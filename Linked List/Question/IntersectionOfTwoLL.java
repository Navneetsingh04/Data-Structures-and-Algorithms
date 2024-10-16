/*
L.C: 160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
 */
class Node{
    Node next;
    int data;
    Node(Node next,int data){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class IntersectionOfTwoLL {
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
    public static Node getIntersection(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1 == temp2){
                return temp1;
            }
            if(temp1 == null){
                temp1 = head2;
            }
            if(temp2 == null){
                temp2 = head1;
            }
        }
        return temp1;
    }
    public static void main(String args[]){
        int arr[] = new int[]{3,1};
        int arr2[] = new int[]{1,2,4,5};

        Node head1 = convertToLL(arr);
        Node head2 = convertToLL(arr2);
       
        Node intersectNode = new Node(4);
        intersectNode.next = new Node(6);
        intersectNode.next.next = new Node(2);

        Node temp = head1;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = intersectNode;

        temp = head2;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = intersectNode;
        System.out.println("List 1: ");
        printLL(head1);
        System.out.println("List 2: ");
        printLL(head2);

        Node intersectingNode = getIntersection(head1, head2);
        if(intersectingNode != null){
            System.out.println("Intersecting Node: "+intersectingNode.data);
        }
        else{
            System.out.println("No intersection");
        }
    }
}