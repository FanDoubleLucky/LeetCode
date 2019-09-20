package LinkedList;
/*
双向（next,pre）而且带child指针的链表，如下图，将其铺平，注意铺平后也是双向带child的链表
Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL

思路
当遇到有child的node，先将整个child合并进来但是node指针不要跳，要一个个挨着往下走，这样就会逐层的把child合并进来
1.
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
2.

 1---2---3---7---8---9---10---4---5---6--NULL
                 |
                 11--12--NULL
3.
 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattingMutiLevelLL {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if(head==null){return null;}
        Node p = head;
        while(p!=null){
            if(p.child==null){ // 没有child直接next
                p = p.next;
                continue;
            }

            // 有child，把这条child合并进来
            Node child = p.child;
            Node next = p.next;
            Node temp =p.child;
            while(child.next!=null){ // 找到child的tail
                child = child.next;
            }
            // p node和child链的头连起来
            p.child = null;
            p.next = temp;
            temp.prev = p;

            // child链尾和p next连起来
            child.next = next;
            if(next!=null){
                next.prev = child;
            }
        }

        return head;
    }
}