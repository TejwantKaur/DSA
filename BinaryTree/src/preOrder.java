public class preOrder {
    static class Node{
        int data;
        Node left; Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int i=-1;
        public static Node buildTree(int[] nodes){
            i++;
            if(nodes[i]==-1) return null; //null node(-1)
//                make new node
            Node newNode = new Node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void pre(Node root){
        if (root==null) return;

        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }
    public static void in(Node root){
        if (root==null) return;

        in(root.left);
        System.out.print(root.data+" ");
        in(root.right);
    }
    public static void post(Node root){
        if (root==null) return;

        post(root.left);
        post(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        pre(root);
        System.out.println();
        in(root);
        System.out.println();
        post(root);
        System.out.println();
    }
}
