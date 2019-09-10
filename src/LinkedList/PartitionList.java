package LinkedList;

public class PartitionList {
    public static ListNode Solution(ListNode head, int x){
        if(head==null||head.next==null){return head;}
        ListNode after = new ListNode(-1);
        ListNode after_head = after;
        ListNode before = new ListNode(-1);
        ListNode before_head = before;
        while(head!=null){
            if(head.val<x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        before.next = after_head.next;
        after.next = null;
        return before_head.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        ListNode head = ListNode.Load(nums);
        System.out.println(Solution(head, 2).toString());
    }
}
