import java.util.Scanner;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtBeginning {
    Node head;
    public void insertAtBeginning(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void lengthOfLL(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        InsertAtBeginning linkedList = new InsertAtBeginning();
        System.out.print("Enter the number you want to insert in the linked list: ");
        int n = s.nextInt();
        int element;
        for(int i = 0;i<n;i++){
            System.out.print("Insert "+i+" element: ");
            element = s.nextInt();
            linkedList.insertAtBeginning(element);
        }
        linkedList.printList();
        System.out.print("length odf the linked list is: ");
        linkedList.lengthOfLL();
        s.close();
    } 
}