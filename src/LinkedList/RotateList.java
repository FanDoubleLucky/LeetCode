package LinkedList;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){return head;}
        int len = 0;
        ListNode travel = head;
        while(travel!=null){
            len++;
            travel=travel.next;
        }
        k = k%len; // 从头到此是处理k的大小，让它落在0-len

        if(k==0){return head;}
        ListNode fast = head;
        while(k>0){
            k--;
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        } // 到此处是快慢指针找到断开的地方，fast是最后一个非零node，slow.next是新头节点

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{1,2,3,4,5});
        System.out.println(rotateRight(head, 2).toString());
    }
}
