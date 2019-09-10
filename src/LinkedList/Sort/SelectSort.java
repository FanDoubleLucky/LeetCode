package LinkedList.Sort;

import LinkedList.ListNode;

public class SelectSort {

    public static ListNode selectSortList(ListNode start){
        if(start==null||start.next==null){return start;}
        ListNode dummy = new ListNode(-1);
        dummy.next = start;
        ListNode tail = start;
        while(tail!=null){
            ListNode travel = tail;
            ListNode minNode = tail;
            while(travel!=null){
                if (travel.val<minNode.val){
                    minNode = travel;
                }
                travel = travel.next;
            }
            int temp = tail.val;
            tail.val = minNode.val;
            minNode.val = temp;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{11,2,3,0,-1,87,0});
        System.out.println(selectSortList(head).toString());
    }
}
