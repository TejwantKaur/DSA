public class palindrome {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        public static Node head;
        public static Node tail;

        public void addFirst ( int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
        public void print () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public boolean isPal(){
//            find mid node
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow;

//        reverse 2nd half
        Node prev = null;
        Node next = null;
        Node curr = mid;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

//        compare
        Node left = head;
        Node right = prev;
        while(right!=null){
            if (right.data !=left.data)
                return false;
            right = right.next;
            left = left.next ;
        }
        return true;
    }

        public static void main (String[]args){
        palindrome ll = new palindrome();
        ll.addFirst(6);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(5);
        ll.addFirst(8);
        ll.addFirst(9);
        ll.addFirst(6);
        ll.print();

        System.out.println(ll.isPal());

    }
}