class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

public class InvertTree {

    public static TreeNode invert(TreeNode root) {
        if(root==null) {
            return root;
        }
        TreeNode temp=new TreeNode();
        temp=root.left;
        root.left=root.right;
        root.right=temp;

        invert(root.left);
        invert(root.right);
        return root;
    }
    public static void printTree(TreeNode root) {

        if(root == null) {
            return;
        }
    
        System.out.print(root.val + " ");
    
        printTree(root.left);
    
        printTree(root.right);
    }

    public static void main(String args[]) {
        TreeNode tree= new TreeNode(4);
        tree.left=new TreeNode(2);
        tree.right=new TreeNode(7);
        tree.left.left=new TreeNode(1);
        tree.left.right=new TreeNode(3);
        tree.right.left=new TreeNode(6);
        tree.right.right=new TreeNode(9);
        

        System.out.println("Tree before invertion: ");
        printTree(tree);
        invert(tree);
        System.out.println("\nTree after invertion: ");
        printTree(tree);
    }
}