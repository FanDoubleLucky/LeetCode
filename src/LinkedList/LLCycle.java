package LinkedList;

public class LLCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){return false;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy.next, fast = dummy.next.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
