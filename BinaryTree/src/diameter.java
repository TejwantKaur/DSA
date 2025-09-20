public class diameter {
    static class Node{
        int data;
        Node left; Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int ht(Node root){
        if(root == null){
            return 0;
        }
        int lh = ht(root.left);
        int rh = ht(root.right);

        return Math.max(lh,rh)+1;
    }

    public static int diam(Node root){
        if (root == null) return 0;

        int lh=ht(root.left);
        int rh=ht(root.right);

        int ld = diam(root.left);
        int rd = diam(root.right);

        int self = lh+rh+1;
        return Math.max(self,(Math.max(ld,rd)));

    }

    static class Info{
        int diam, ht;
        public Info(int h,int d){
            this.diam = d;
            this.ht = h;
        }
    }

    public static Info diam2(Node root){
        if(root==null) return new Info(0,0);

        Info l = diam2(root.left);
        Info r = diam2(root.right);

        int ht = Math.max(l.ht,r.ht)+1;

        int self = l.ht+r.ht+1;
        int diam = Math.max(self,Math.max(l.diam,r.diam));

        return new Info(ht,diam);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diam2(root).diam);
        System.out.println(diam2(root).ht);
    }
}

