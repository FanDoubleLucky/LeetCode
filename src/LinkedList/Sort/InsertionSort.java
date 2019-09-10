package LinkedList.Sort;

import LinkedList.ListNode;

public class InsertionSort {

    public static ListNode insertionSortList(ListNode head){
        if(head == null||head.next == null){ return head;}
        ListNode dummy = new ListNode(-1);
        ListNode start = head;
        while(head!=null){

            ListNode travel = dummy.next;
            ListNode pre = dummy;
            while(travel!=null&&travel.val<=head.val){
                pre = travel;
                travel = travel.next;
            }
            ListNode temp = head;
            head = head.next;
            pre.next = temp;
            temp.next = travel;
            System.out.println(dummy);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = ListNode.Load(new int[]{4,2,1,3});
        System.out.println(insertionSortList(head));
    }
}
