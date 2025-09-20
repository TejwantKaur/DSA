public class subtree {

    static class Node{
        int data;
        Node left; Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean identical(Node root, Node sub){
//        prove non identical
        if(root == null && sub == null)
            return true;
        else if (root==null || sub==null || root.data!= sub.data )
            return false;

        if(!identical(root.left,sub.left))
            return false;
        if(!identical(root.right,sub.right))
            return false;

        return true;
    }
    public static boolean isSubtree(Node root, Node sub){
        if (root==null) return false;
        if(root.data == sub.data)
//            check identical
            if(identical(root, sub)) return true;

        return isSubtree(root.left, sub) || isSubtree(root.right,sub);
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root,subRoot));
    }
}


