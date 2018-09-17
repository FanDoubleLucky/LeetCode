package BinarySearch;

class count_tree_node {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(root == null){
            return 0;
        }
        int res = 0;
        while(h>=0){
            if(height(root.right)==h-1){
                res+=1<<h;
                root = root.right;
            }
            else{
                res+=1<<h-1;
                root = root.left;
            }
            h--;
        }
        return res;
    }

    private int height(TreeNode x){
        if(x==null){
            return -1;
        }
        else{
            int h = 0;
            x = x.left;
            while(x!=null){
                x= x.left;
                h++;
            }
            return h;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}