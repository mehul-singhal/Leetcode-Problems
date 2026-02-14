package Tree;

public class pathSum {
    public static boolean  pathSum(BinaryTreeNode root, int sum){
        if(root == null) return sum == 0;
        if(root.left == null && root.right == null){
            return sum - root.data == 0;
        }
        sum -= root.data;
        return pathSum(root.left, sum) || pathSum(root.right, sum);
    }

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.left = new BinaryTreeNode(8);
        System.out.println(pathSum(root, 7));
    }
}
