package LinkedList;

public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){return head;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode oldNext = pre.next;
            pre.next = pre.next.next;
            oldNext.next = pre.next.next;
            pre.next.next = oldNext;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
