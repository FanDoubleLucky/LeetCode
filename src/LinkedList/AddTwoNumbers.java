package LinkedList;

import java.util.concurrent.ConcurrentHashMap;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res;
        if(l1==null||l2==null){
            res = l1!=null?l1:l2;
            return res;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while(p!=null||q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry+x+y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null){p = p.next;}
            if(q!=null){q = q.next;}
        }
        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
