package LinkedList;
/*
找到两个链表的第一个公共节点，如果没有返回null
A 1-2-3-4-5-6
              \
               7-8-9
              /
B       4-5-6
返回node(7)
A的组成：X+K， B的组成：Y+K， X+K+Y = Y+K+X
 */
public class IntersectionTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a = headA, b = headB;
        while(a!=b){
            a = a==null?headB:a.next; // X+K 后面续上 Y
            b = b==null?headA:b.next; // Y+K 后面续上 X
        }
        return a;
    }
}
