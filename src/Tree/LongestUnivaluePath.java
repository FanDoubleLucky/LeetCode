package Tree;

public class LongestUnivaluePath {

    static int len = 0;
    public static int longestUnivaluePath(TreeNode root) {
        if(root==null){return 0;}

        int count = dfs(root.val, root.left)+dfs(root.val, root.right)+1;
        len = Math.max(len, count);
        return len-1;
    }

    static int dfs(int val, TreeNode node){
        if (node==null){return 0;}
        int left = dfs(node.val, node.left);
        int right = dfs(node.val, node.right);
        len = Math.max(len, left+1+right);
        if(node.val!=val){return 0;}
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.Load3Level(new int[]{5,4,5,1,1,Integer.MAX_VALUE,5});
        System.out.println(longestUnivaluePath(root));
    }

}
