package LinkedList.Sort;

import LinkedList.ListNode;

public class QuickSort {

    public static ListNode sortList(ListNode head){
        if(head==null||head.next==null){return head;}
        ListNode pivot = head;
        ListNode left = new ListNode(0), leftHead = left;
        ListNode right = new ListNode(0), rightHead = right;
        ListNode mid = new ListNode(0), midHead = mid;
        ListNode runner = head;
        while (runner!=null){
            if(runner.val<pivot.val){
                left.next = runner;
                left = left.next;
            }else if(runner.val>pivot.val){
                right.next = runner;
                right = right.next;
            }else{
                mid.next = runner;
                mid = mid.next;
            }
            runner = runner.next;
        }
        left.next = null;
        right.next = null;
        mid.next = null;
        leftHead = sortList(leftHead.next);
        rightHead = sortList(rightHead.next);
        head = connect(leftHead, midHead.next, rightHead);

        return head;
    }

    public static ListNode connect(ListNode left, ListNode mid, ListNode right){
        ListNode LeftTail = getTail(left);
        ListNode midTail = getTail(mid);
        midTail.next = right;
        if(LeftTail != null) {
            LeftTail.next = mid;
            return left;
        } else {
            return mid;
        }
    }

    public static ListNode getTail(ListNode head){
        if(head == null) return head;
        while(head.next != null) head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{4,2,1,3});
        head = sortList(head);
        System.out.println(head);
    }
}
