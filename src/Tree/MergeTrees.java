package Tree;

class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode(0);
        if(t1==null||t2==null){
            root = t1!=null?t1:t2;
        }
        root = merge(t1, t2, root);
        return root;
    }

    TreeNode merge(TreeNode t1, TreeNode t2, TreeNode root){
        if(t1==null&&t2==null){
            return null;
        }
        if(t1!=null&&t2!=null){
            root = new TreeNode(t1.val+t2.val);
            root.left = merge(t1.left, t2.left, root.left);
            root.right = merge(t1.right, t2.right, root.right);
        }else{
            root = t1!=null?new TreeNode(t1.val):new TreeNode(t2.val);

            if(t1==null){
                root.left = merge(null, t2.left, root.left);
                root.right = merge(null, t2.right, root.right);
            }else{
                root.left = merge(t1.left, null, root.left);
                root.right = merge(t1.right, null, root.right);
            }
        }
        return root;

    }
}
