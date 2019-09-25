package Tree;

class UnivalueBT {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){return true;}
        int val = root.val;
        if(root.left!=null&&root.left.val!=val){return false;}
        if(root.right!=null&&root.right.val!=val){return false;}
        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }

}
