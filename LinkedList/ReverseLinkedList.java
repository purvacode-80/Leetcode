// 206. Reverse Linked List
// Using Recursion

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive case: reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Make the next node point to the current head
        head.next.next = head;
        head.next = null; // Set the next of current head to null

        return newHead; // Return the new head of the reversed list
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
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createList(arr);
        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverseList(head);
        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
