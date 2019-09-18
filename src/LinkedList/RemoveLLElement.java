package LinkedList;

/*
将head链表中值为val的node删除
 */
public class RemoveLLElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next!=null){
            if(pre.next.val==val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
