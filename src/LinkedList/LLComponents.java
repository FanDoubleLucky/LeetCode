package LinkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LLComponents {

//    public static ListNode removeZeroSumSublists(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        HashMap<Integer, ListNode> map = new HashMap<>();
//        ListNode travel = head;
//        while (travel!=null){
//            if(map.containsKey(-1*travel.val)){
//                continue;
//            }else {
//                map.put(-1*travel.val,travel);
//            }
//            travel = travel.next;
//        }
//
//
//        return null;
//    }


    public static ListNode removeZeroSumSublists(ListNode head) {
        if(head==null){return head;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode travel = dummy;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int sum = 0;
        while(travel!=null){
            sum+= travel.val;
            if(map.containsKey(sum)){ // 和变成了之前出现过的，说明最近这一段白加了，这段子链和为0
                ListNode temp = map.get(sum).next; // 回溯到和为0的子链的head
                int removeSum = sum+temp.val;
                while(temp!=travel){ // 将这段子链加出来的和全部remove掉
                    map.remove(removeSum);
                    temp = temp.next;
                    removeSum+=temp.val;
                }
                map.get(sum).next = travel.next; // 直接跳过这段子链
                travel = travel.next;
            }else{
                map.put(sum,travel);
                travel = travel.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.Load(new int[]{1,3,2,-3,-2,5,5,-5,1});
        head = removeZeroSumSublists(head);
        System.out.println(head.toString());
    }
}
