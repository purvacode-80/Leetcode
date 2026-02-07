// 2095. Delete the Middle Node of a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Delete_Middle_Node {

    public static ListNode deleteMiddle(ListNode head) {
        // If linked list is empty or contain only one node return null
        // If there is a single node, then it will be deleted and the linked list will be empty
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        // Fast is at 2x speed
        // Slow will be at middle node when the fast will reach the last element
        // When n = even, fast will be null at last
        // When n = odd, fast will be at the last element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the node which slow.next is pointing
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        
        // Make the 1st element as head of the linked list - head = a[0]
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for(int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Function to print list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " --> ");
            curr = curr.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {

        int[] arr = {1,3,4,7,1,2,6};

        ListNode head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("After deleting middle:");
        printList(head);
    }
}