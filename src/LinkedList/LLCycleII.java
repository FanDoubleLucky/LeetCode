package LinkedList;

public class LLCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null){return null;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy.next, fast = dummy.next.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cycle = dummy;
        while(cycle!=slow){
            cycle = cycle.next;
            slow = slow.next;
        }
        return cycle;
    }
}
