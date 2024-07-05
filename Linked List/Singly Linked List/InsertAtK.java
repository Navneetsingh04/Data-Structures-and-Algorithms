class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtK {
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
    public static Node insertK(Node head,int value,int k){
        if(head == null){
            if(k==1){
                return new Node(value);
            }
            else{
                System.out.println("Invalid position");
                return head;
            }
        }
        if(k == 1){
            Node newnode = new Node(value);
            newnode.next = head;
            head = newnode;
            return head;
        }
        int cnt = 1;
        Node temp = head;
        while(temp != null){
            if(cnt == k-1){
                Node newnode = new Node(value);
                newnode.next = temp.next;
                temp.next = newnode;
                return head;
            }
            cnt++;
            temp = temp.next;
        }
        System.out.println("postion out of bound");
        return head;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        int arr[] = new int[]{10,20,30,40,50};
        Node head = convertToLL(arr);
        head = insertK(head, 5,5);
        print(head);
    }
}
