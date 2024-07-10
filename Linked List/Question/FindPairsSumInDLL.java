/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value x, without using any extra space? 

Example:  

Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
    x = 7
Output: (6, 1), (5,2)
 */
import java.util.ArrayList;
import java.util.List;
class Node{
    Node prev;
    Node next;
    int data;

    Node(int data,Node next,Node prev){
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}
class Pair {
    int first;
    int second;
  
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
}  
public class FindPairsSumInDLL {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
        }
        System.out.println();
    }
    // public static List<Pair> pairSum(Node head,int sum){
    //     List<Pair> list = new ArrayList<>();
    //     Node temp1 = head;
    //     while(temp1 != null){
    //         Node temp2 = temp1.next;
    //         while(temp2 != null && (temp1.data+temp2.data)<= sum){
    //             if(temp1.data+temp2.data == sum){
    //                 list.add(new Pair(temp1.data,temp2.data));
    //             }
    //             temp2 = temp2.next;
    //         }
    //         temp1 = temp1.next;
    //     }
    //     return list;
    // }
    public static Node findtail(Node head){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
    public static List<Pair> pairSum(Node head,int sum){
        List<Pair> list = new ArrayList<>();
        if(head == null){
            return null;
        }
        Node left = head;
        Node right = findtail(head);
        while(left.data < right.data){
            if(left.data+right.data == sum){
                list.add(new Pair(left.data,right.data));
                left = left.next;
                right = right.prev;
            }
            else if(left.data+right.data < sum){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }
        return list;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,9};
        int sum = 5;
        Node head = convertToLL(arr);
        List<Pair> pairs = pairSum(head, sum);
        System.out.print("pair with the sum "+sum+" : ");
        for(Pair pair:pairs){
            System.out.print("("+pair.first+","+pair.second+")");
        }
    }
}