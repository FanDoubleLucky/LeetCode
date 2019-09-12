package LinkedList;

public class ReorderList {

    public static void reorderList(ListNode head) {
        if(head==null||head.next==null){return;}
        ListNode fast = head, slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        } // 先用快慢指针找到链表的中点

        ListNode after = slow.next; // after是后半部分的头节点
        slow.next = null;
        ListNode travel = after;
        ListNode pre = null;
        while(travel!=null){
            ListNode temp = travel.next;
            travel.next = pre;
            pre = travel;
            travel = temp;
        }
        ListNode before = head;
        after = pre; // 链表反转，将后半部分反转

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(before!=null||after!=null){
            dummy.next = before;
            before = before.next;
            dummy = dummy.next;
            dummy.next = after;
            dummy = dummy.next;
            if(after!=null){ after = after.next; }

        }
        System.out.println(res.next);
    }

    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{1,2,3,4,5,6,7});
        reorderList(head);
    }
}
