package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        String info = new String("");
        ListNode travel = this;
        while(travel!=null){
            info += travel.val;
            travel = travel.next;
        }
        return info;
    }

    public static ListNode Load(int[] nums){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        head.next = null;
        for (int ele :
                nums) {
            head.next = new ListNode(ele);
            head = head.next;
        }
        return dummy.next;
    }
}
