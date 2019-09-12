package LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;

        while(p1!=null){
            s1.push(p1.val);
            p1 = p1.next;
        }
        while(p2!=null){
            s2.push(p2.val);
            p2 = p2.next;
        }

        ListNode dummy = new ListNode(-1);

        int carry = 0;
        while(!s1.isEmpty()||!s2.isEmpty()){
            int n1 = s1.isEmpty()?0:s1.pop();
            int n2 = s2.isEmpty()?0:s2.pop();
            ListNode bit = new ListNode((n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
            bit.next = dummy.next;
            dummy.next = bit;
        }
        if(carry==1){
            ListNode bit = new ListNode(1);
            bit.next = dummy.next;
            dummy.next = bit;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.Load(new int[]{7,2,4,3});
        ListNode b = ListNode.Load(new int[]{5,6,4});
        System.out.println(addTwoNumbers(a,b).toString());
    }
}
