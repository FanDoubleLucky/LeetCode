package LinkedList;

/*
删除链表中的重复元素，与RemoveDuplicateNode不同，这个不是去重，而是将所有的重复node删除，1-2-2-3-3-4-4-5-6-7-7 -> 1-5-6
 */
public class RemoveDuplicateNodeII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){return head;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = pre.next;

        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){ // 自身和next重复，一直跳到不再与next重复
                cur = cur.next;
            }
            if(pre.next != cur){ // cur不再是之前的cur，说明出现重复
                pre.next = cur.next; // 删除cur
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }else{ // 没有出现重复，直接双指针后移
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
