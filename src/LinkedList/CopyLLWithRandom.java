package LinkedList;

/*
leetcode 138
 */
public class CopyLLWithRandom {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int val){
            this.val = val;
        }
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    // 整个过程分为三部分，原链元素复制，给新random赋值，拆链
    public static Node copyRandomList(Node head) {
        if(head==null){return head;}

        Node travel = head;
        while(travel!=null){
            Node next = travel.next;
            travel.next = new Node(travel.val);
            travel.next.next = next;
            travel = next;
        } // 原链复制
        travel = head;

        while(travel!=null&&travel.next!=null){
            Node temp = travel.random;
            if(temp!=null){
                temp = temp.next;
                travel.next.random = temp;
            }else{
                travel.next.random = null;
            }
            travel = travel.next.next;
        } // 新复制出的元素的random赋值
        travel = head;

        Node copy = head.next;
        Node copyhead = copy;
        while(copy!=null&&copy.next!=null){
            travel.next = travel.next.next;
            travel = travel.next;
            copy.next = copy.next.next;
            copy = copy.next;
        } // 分离两个链
        travel.next = travel.next.next; // 此时原链最后一个元素没和新链断开，此步为断开

        return copyhead;
    }
}
