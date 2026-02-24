class POTD {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int dfsTraversal(TreeNode root, int currSum) {
        if (root == null)
            return 0;

        currSum = (currSum * 2) + root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }

        return dfsTraversal(root.left, currSum) + dfsTraversal(root.right, currSum);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfsTraversal(root, 0);
    }
}