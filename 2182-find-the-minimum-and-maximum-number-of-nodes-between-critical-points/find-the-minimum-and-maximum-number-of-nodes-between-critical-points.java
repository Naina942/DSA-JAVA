/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        int pos = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {
                if (first == -1) {
                    first = pos;
                } else {
                    min = Math.min(min, pos - last);
                }
                last = pos;
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if (first == last) {
            return new int[]{-1, -1};
        }
        return new int[]{min, last - first};
    }
}