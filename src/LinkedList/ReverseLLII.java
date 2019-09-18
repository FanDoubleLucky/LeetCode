package LinkedList;

/*
将链表的第m个到第n个node反转，思路先for循环走到m处，然后for循环到n执行常规链表反转，在for循环前记录下previous node，以便后继的连接
 */
public class ReverseLLII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m==n){return head;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        ListNode breakNode = pre;
        ListNode cur = pre.next;
        ListNode tail = cur;
        pre = null;
        for (int i = 0; i <=n - m; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        breakNode.next = pre;
        tail.next = cur;
        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{1,2,3,4,5,6,7});
        head = reverseBetween(head, 2, 4);
        System.out.println(head);
    }
}
