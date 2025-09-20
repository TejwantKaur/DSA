import java.util.*;
public class levelOrder {
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
    public static void lev(Node root){
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);

            } else{
                System.out.print(curr.data+" ");
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        lev(root);
    }
}
