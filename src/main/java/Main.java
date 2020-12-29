public class Main {
    public static int checkHeight(MyBinaryTreeNode<Integer> root) {
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced(MyBinaryTreeNode<Integer> tree) {
        return checkHeight(tree) != Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        MyBinaryTreeNode<Integer> tree = MyBinaryTreeNode.generateBinarySearchTree();
        tree.PrintInOrder(tree);
        System.out.println(isBalanced(tree));
        MyBinaryTreeNode.insertBinarySearchTreeNode(tree, new MyBinaryTreeNode<>(30));
        tree.PrintInOrder(tree);
        System.out.println(isBalanced(tree));

    }
}
