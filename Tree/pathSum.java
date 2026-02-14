package Tree;

//leetcode - 112. Path Sum

public class pathSum {
    public static boolean  pathSum(TreeNode root, int sum){
        if(root == null) return sum == 0;
        if(root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        sum -= root.val;
        return pathSum(root.left, sum) || pathSum(root.right, sum);
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        System.out.println(pathSum(root, 7));
    }
}
