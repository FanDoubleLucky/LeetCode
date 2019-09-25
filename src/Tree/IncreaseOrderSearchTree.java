package Tree;


import java.util.Stack;

class IncreaseOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){return null;}
        TreeNode increase = new TreeNode(0);
        TreeNode head = increase;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                increase.right = new TreeNode(root.val);
                increase = increase.right;
                root = root.right;
            }
        }
        return head.right;
    }
}

