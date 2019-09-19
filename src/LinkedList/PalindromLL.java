package LinkedList;

/*
判断链表是否为回文链表，1，2，2，1这种，1，2，3，1，2就不是，思路先用快慢指针找到中点节点，然后将后半段反转，如果是回文链表，反转后得到的链表应该和前半段一样
 */
public class PalindromLL {
    public static boolean isPalindrome(ListNode head) {
        if(head==null){return true;}
        ListNode tail = new ListNode(-1);
        tail.next = head;
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null){
            tail = tail.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        tail.next = null;
        ListNode travel = head;

        while(travel!=null){
            if(travel.val!=pre.val){
                return false;
            }
            travel = travel.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1};
        ListNode head = ListNode.Load(nums);
        System.out.println(isPalindrome(head));
    }
}
