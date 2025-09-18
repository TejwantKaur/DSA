public class buildTreePreorder {
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

        public static void main(String[] args) {
            int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

//            BinaryTree bt = new BinaryTree();
            Node root = buildTree(nodes);
            assert root != null;
            System.out.println(root.data);
        }
    }
}
