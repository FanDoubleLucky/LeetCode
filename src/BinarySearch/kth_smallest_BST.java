package BinarySearch;

/**
 * Kth Smallest Element in a BST
 */



class kth_smallest_BST {
    public int kthSmallest(TreeNode root, int k) {
        k = k - 1;
        while(root!=null){
            TreeNode left = root.left;
            if(k<size(left)){
                root = root.left;
            }
            else if(k>size(left)){
                k = k - size(left)-1;
                root = root.right;
            }
            else{
                return root.val;
            }
        }
        return -1;

    }

    public int size(TreeNode x){
        if(x==null){
            return 0;
        }
        else{
            return size(x.left)+size(x.right)+1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}