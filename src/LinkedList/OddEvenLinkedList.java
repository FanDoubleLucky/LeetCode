package LinkedList;

public class OddEvenLinkedList {
    public ListNode Solution(ListNode head){
        ListNode odd = head, even = head, pre = even;
        while(even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = pre;
        return head;
    }
}
