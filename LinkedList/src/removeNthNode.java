public class removeNthNode {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void del(int n){
        // calc size of ll
        int size=0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next;
            return;
        }

        int fromBeg = size-n;
        Node prev = head;
        int i=1;

        while(i<fromBeg){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;

        if (prev.next == null) {
            tail = prev;
        }
        return;
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        removeNthNode ll = new removeNthNode();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(9);
        ll.print();

        // System.out.println(ll.del(3));
        ll.del(2);
        ll.print();

    }
}
