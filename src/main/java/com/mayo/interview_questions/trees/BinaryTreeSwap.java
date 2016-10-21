package com.mayo.interview_questions.trees;

/**
 * @author yoav @since 10/14/16.
 *         Implement a binary tree node swap recursive function
 */
public class BinaryTreeSwap {
    public static void main(String[] args) {
        try {
            System.out.println("Please enter depth:");
            int depth = Integer.parseInt(args[0]);
            TreeNode tree = buildTree(depth);
            swapTreenodes(tree);
            String strRep = tree.toString();
            System.out.println(tree);
        } catch (Exception e) {
            System.out.println("you dushi");
            e.printStackTrace();
        }
    }

    private static TreeNode buildTree(int depth) {
        if (depth == 0) {
            return new TreeNode();
        } else {
            TreeNode left = buildTree(depth - 1);
            TreeNode right = buildTree(depth - 1);

            return new TreeNode(left, right);
        }
    }

    static void swapTreenodes(TreeNode tree) {
        TreeNode left = tree.getLeft();
        tree.setLeft(tree.getRight());
        tree.setRight(left);
        if (tree.hasLeft()) swapTreenodes(tree.getLeft());
        if (tree.hasRight()) swapTreenodes(tree.getRight());
    }


}

enum NodePosition {
    LEFT, RIGHT, ROOT
}

class TreeNode {

    //region members
    private TreeNode left;
    private TreeNode right;
    private NodePosition position = NodePosition.ROOT;
    //endregion

    //region Ctors
    public TreeNode(TreeNode left, TreeNode right) {
        left.setPosition(NodePosition.LEFT);
        right.setPosition(NodePosition.RIGHT);
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
    //endregion

    //region Getters
    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
    //endregion

    //region Setters
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setPosition(NodePosition position) {
        this.position = position;
    }

    //endregion

    //region methods
    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public String getStringRep(boolean root, boolean last) {
        String separator = last && !root ? "" : ",";
        String leftNullish = "\"LEFT\":null,";
        String rightNullish = "\"RIGHT\":null";
        String leftStr = hasLeft() ? getLeft().getStringRep(false, !hasRight()) : leftNullish;
        String rightStr = hasRight() ? getRight().getStringRep(false, true) : rightNullish;
        String self = String.format("\"%s\":{\n%s\n%s\n}%s", position.toString(), leftStr, rightStr, separator);
        if (root) {
            self = "{" + self.substring(0, self.length() - 1) + "}";
        }

        return self;
    }

    @Override
    public String toString() {
        return getStringRep(true, true);
    }

    //endregion

}
