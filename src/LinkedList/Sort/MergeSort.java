package LinkedList.Sort;

import LinkedList.ListNode;

public class MergeSort {

    public static ListNode sortList(ListNode head){
        if(head==null||head.next==null){return head;}

        // step 1 将链表平分成前后两段
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        head = merge(left, right);

        return head;
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                runner.next = left;
                left = left.next;
            }else {
                runner.next = right;
                right = right.next;
            }
            runner = runner.next;
        }
        runner.next = left!=null?left:right;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{});
        head = sortList(head);
    }
}
