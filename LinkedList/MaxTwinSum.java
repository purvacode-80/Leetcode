// 2130. Maximum Twin Sum of a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MaxTwinSum {

    public static int pairSum(ListNode head) {
        // Create two pointers to find the middle of the linked list
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        int maxVal = 0;

        // Find the middle point at slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null; 
        ListNode nextNode = null;
        // Until slow reaches the end of the list 
        // Divide the list into two halves and reverse the 2nd half
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // Check twin sum and return the max sum
        while (prev != null) {
            maxVal = Math.max(maxVal, (head.val + prev.val));
            head = head.next;   // Move to next element of 1st list
            prev = prev.next;   // Move to next element of 2nd list
        }
        
        return maxVal;
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
        int[] arr1 = {5,4,2,1};
        ListNode head1 = createList(arr1);
        int maxVal_1 = pairSum(head1);
        System.out.println("Max Twin Sum Value : " + maxVal_1);

        // Test Case - 2 
        int[] arr2 = {4,2,2,3};
        ListNode head2 = createList(arr2);
        int maxVal_2 = pairSum(head2);
        System.out.println("Max Twin Sum Value : " + maxVal_2);

        // Test Case - 3
        int[] arr3 = {1,100000};
        ListNode head3 = createList(arr3);
        int maxVal_3 = pairSum(head3);
        System.out.println("Max Twin Sum Value : " + maxVal_3);
    }
}
