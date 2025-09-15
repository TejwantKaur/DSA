public class mergeSort {
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
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node mergeSortAlgo(Node head){
        if (head == null || head.next == null){
            return head;
        }
//        find mid
        Node mid = getMid(head);

        Node rHead = mid.next;
        mid.next=null;
        Node newLeft = mergeSortAlgo(head);
        Node newRight = mergeSortAlgo(rHead);
//
        return merge(newLeft,newRight);
    }
    private Node merge(Node h1, Node h2){
        Node mergedLL = new Node (-1);
        Node temp = mergedLL;

        while(h1 !=null && h2 !=null){
            if (h1.data<=h2.data){
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;

        }
        if (h1!=null)
//            temp will start pointing to the remaining elems in ths list
            temp.next = h1;
        else
            temp.next = h2;

        return mergedLL.next;
    }
    public static void main(String[] args) {
        mergeSort ll = new mergeSort();
        ll.addFirst(6);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(7);
        ll.addFirst(16);
        ll.print();
        head = ll.mergeSortAlgo(head);
        ll.print();
    }

}
