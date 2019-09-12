package LinkedList;

import java.util.List;

public class RemoveNFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
        ListNode fast = head;
        while(k>0){
            fast = fast.next;
            k--;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head, pre = dummy;
        while(fast!=null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{1});
        head = removeNthFromEnd(head,1);
        System.out.println(head.toString());
    }
}
