public class search {
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

    public int itrSearch(Node head, int key){
        Node temp = head;
        int i=0;
        while (temp!=null){
            if(temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        search ll = new search();
        ll.addFirst(6);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(9);
        ll.addFirst(6);
        ll.print();

        int key = 0;
        int idx = ll.itrSearch(head, key);

        if (idx == -1)
        {
            System.out.println("item not found");
        }else {
            System.out.println("idx of item" + key + "=" + idx);
        }
    }
}

