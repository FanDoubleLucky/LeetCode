package Tree;

/*
root = [10,5,15,3,7,null,18], L = 7, R = 15, 计算root中所有在[L, R]这个闭区间的和， sum = 32(7+10+15)
              10
             /  \
            5   15
           / \  / \
          3   7 N 18
递归思路，如果当前元素node大于R，递归node.left，小于L的话，递归node.right，介于L R之间的话，就左右节点都需要递归
 */
public class RangeSumBST {

    static int sum = 0;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);

        return sum;
    }

    public static void helper(TreeNode root, int L, int R){
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


    public static void main(String[] args) {
        TreeNode root = TreeNode.Load3Level(new int[]{10,5,15,3,7,Integer.MAX_VALUE,18});
        System.out.println(rangeSumBST(root, 7, 15));
    }
}
