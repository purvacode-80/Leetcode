// 328. Odd Even Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEven {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Initialize odd and even pointer and evenHead
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        //Iterate till even list ends
        while (even != null && even.next != null) {
            // Append next odd node to prev odd node and update the current odd node
            odd.next = even.next;
            odd = odd.next;

            // Do same for even node
            even.next = odd.next;
            even = even.next;
        }

        //Append the last odd node with the first even head
        odd.next = evenHead;

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
        // Test Case - 1
        int[] arr1 = {1,2,3,4,5};

        ListNode head1 = createList(arr1);

        System.out.println("Original List :");
        printList(head1);

        head1 = oddEvenList(head1);

        System.out.println("Output : ");
        printList(head1);           // Output: [1,3,5,2,4]

        // Test Case - 2
        int[] arr2 = {2,1,3,5,6,4,7};

        ListNode head2 = createList(arr2);

        System.out.println("Original List :");
        printList(head2);

        head2 = oddEvenList(head2);

        System.out.println("Output : ");
        printList(head2);       // Output: [2,3,6,7,1,5,4]
    }
}
