/*
L.C: 725. Split Linked List in Parts

Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].

Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 
Constraints:

The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50
*/
public class SplitLLinParts {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        // min no. of of nodes in each parts
        int minNodes = len/k;
        // extra Nodes 
        int extraNodes = len%k;

        ListNode ans[] = new ListNode[k];
        // Reset curr to the head of the LL
        curr = head;
        // dividing LL into K parts
        for(int i = 0;i<k;i++){
            ListNode pHead = curr;
            //  Determine the size of the current part
            // and Add an extra node to the first      extraNodes parts
            int currPartSize = minNodes+(i < extraNodes?1:0);

            // Traversing to the end of the current part
            for(int j = 0;j<currPartSize-1;j++){
                if(curr != null){
                    curr = curr.next;
                }
            }
           // Detaching the current part from the remainder of LL
            if(curr != null){
                ListNode nextPartHead = curr.next;
                curr.next = null;
                curr = nextPartHead;
            }
            ans[i] = pHead;
        }
        return ans;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next  = new ListNode(6);
        head.next.next.next.next.next.next  = new ListNode(7);

        int k = 3;

        ListNode[] ans = splitListToParts(head, k);
        for(ListNode l : ans) {
            if(l == null){
                System.out.print("null");
            }
            else{
                while(l != null){
                    System.out.print(l.val+"->");
                    l = l.next;
                }
            }
            System.out.println();
        }
    }
}
