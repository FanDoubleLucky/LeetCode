package LinkedList;

/**
 * 给一个链表，分成k份，保证所有份之间长度差不超过1
 */
public class SplitLinkedList {

    public ListNode[] Solution(ListNode root, int k){
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode travel = root, pre = root;
        while (root!=null){
            len++;
        }
        int avg = len/k, remainder = len%k;

        for(int i = 0;i<k;i++,remainder--){
            res[i] = root;
            for(int j = 0;j<avg+(remainder>0?1:0);j++){
                pre = root;
                root = root.next;
            }
            pre.next = null; //断开链
        }
        return res;
    }
}
