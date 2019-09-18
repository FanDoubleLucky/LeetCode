package LinkedList;

/*
删除链表中重复的元素，1-1-1-2-2-3-4-4-5  -> 1-2-3-4-5
 */
public class RemoveDuplicateNode {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){return null;}
        ListNode p = head;
        while(p.next!=null){
            if(p.val==p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}
