package Tree;

class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);

        return sum;
    }

    public void helper(TreeNode root, int L, int R){
        if(root==null){
            return;
        }
        if(root.val>=L&&root.val<=R){
            sum += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        }else if(root.val<=L){
            helper(root.right, L, R);
            return;
        }else if(root.val>=R){
            helper(root.left, L, R);
            return;
        }else{
            return;
        }
    }
}
