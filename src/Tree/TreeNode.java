package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    static TreeNode Load3Level(int[] eles){
        TreeNode root = new TreeNode(eles[0]);
        root.left = packageNode(eles[1]);
        root.right = packageNode(eles[2]);
        if(root.left!=null){
            root.left.left = packageNode(eles[3]);
            root.left.right = packageNode(eles[4]);
        }

        if(root.right!=null){
            root.right.left = packageNode(eles[5]);
            root.right.right = packageNode(eles[6]);
        }
        return root;
    }

    static TreeNode packageNode(int num){
        if(num==Integer.MAX_VALUE){
            return null;
        }else {
            return new TreeNode(num);
        }
    }

    @Override
    public String toString() {
        if(this==null){ return ""; }
        TreeNode root = this;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuffer info = new StringBuffer();
        while (!q.isEmpty()){
            root = q.pop();
            if(root!=null){
                info.append(" "+root.val);
                q.add(root.left);
                q.add(root.right);
            }else {
                info.append(" N");
            }
        }
        return info.toString();
    }
}
