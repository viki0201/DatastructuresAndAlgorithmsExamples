import java.util.Stack;

public class DepthFirstSearch {

    public static class BinaryTree {

        private TreeNode node;

        public BinaryTree() {
            node = null;
        }

        private static class TreeNode{
            int data;
            TreeNode left;
            TreeNode right;
            Boolean visited = false;

            public TreeNode(int data) {
                this.data = data;
                this.left=null;
                this.right=null;
            }

            public Boolean isVisited(){
                return visited;
            }

            public void setVisited(Boolean visited) {
                this.visited = visited;
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



        @Override
        public String toString() {
            return "BinaryTree{" +
                    "node=" + node +
                    '}';
        }

    }

    public static void depthFirstSearch(BinaryTree binaryTree){
        Stack stack = new Stack();
        stack.push(binaryTree.node);
        binaryTree.node.setVisited(true);
        System.out.println(binaryTree.node.data);
        while(!stack.isEmpty()){
            BinaryTree.TreeNode node = (BinaryTree.TreeNode) stack.peek();
            BinaryTree.TreeNode childNode = getUnvisitedNodes(node);
            if(childNode != null){
                childNode.setVisited(true);
                System.out.println(childNode.data);
                stack.push(childNode);

            } else {
                stack.pop();
            }
        }
    }

    private static BinaryTree.TreeNode getUnvisitedNodes(BinaryTree.TreeNode node) {
        BinaryTree.TreeNode left = node.left;
        BinaryTree.TreeNode right = node.right;
        if(left != null && !left.isVisited()){
            return left;
        } else if (right != null && !right.isVisited()){
            return right;
        } else {
            return null;
        }

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
        System.out.println(binaryTree);
        depthFirstSearch(binaryTree);
    }

}
