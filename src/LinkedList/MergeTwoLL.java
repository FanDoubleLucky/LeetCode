package LinkedList;

/*
合并两个有序链表
 */
public class MergeTwoLL {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        l3.next = l1==null?l2:l1;
        return head.next;
    }
}
