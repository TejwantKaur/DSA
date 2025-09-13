public class boilerplate{
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
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        boilerplate ll = new boilerplate();
        ll.addFirst(6);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(9);
        ll.addFirst(6);
        ll.print();
    }

}
