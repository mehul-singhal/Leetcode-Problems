package Tree;

//LeetCode - 129. Sum Root To Leaf Number

public class sumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        util(root, 0);
        return sum;
    }

    void util(TreeNode root, int path){
        if(root == null) return;
        path = path*10 + root.val;
        if(root.left == null && root.right == null){
            sum += path;
        }
        util(root.left, path);
        util(root.right, path);
    }
}
