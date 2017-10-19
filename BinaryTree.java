
public class BinaryTree {

    private TreeNode node;

    public BinaryTree() {
        node = null;
    }

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void add(int data){
        node = add(node, data);
    }

    private TreeNode add(TreeNode node, int data) {
        if(node == null){
            node = new TreeNode(data);
        } else {
            if(data < node.data){
                node.left = add(node.left, data);
            } else {
                node.right = add(node.right, data);
            }
        }

        return node;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(11);
        binaryTree.add(2);
        binaryTree.add(0);
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(20);
        binaryTree.add(12);
        System.out.print(binaryTree);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "node=" + node +
                '}';
    }

}
