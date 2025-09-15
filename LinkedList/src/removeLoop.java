public class removeLoop {
    public static class Node{
        int data;
        Node next;
        public Node (int data){
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

    private Node meetingPt(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                return slow;
            }
        }
        return null;
    }

    public void removeCycle(){
        Node meetingPoint = meetingPt();
        if (meetingPoint == null) return; // no cycle

//        cycle node
        Node slow = head;
        Node fast = meetingPoint;
        Node prev = null;

        while(slow!=fast){
            prev=fast;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev==null){
            while (fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
        } else {
            prev.next = null;
        }

        prev.next = null;
    }
    public boolean isCycle(){
        return meetingPt()!=null;
    }
    public static void main(String[] args) {
        removeLoop ll = new removeLoop();
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next= temp;
        System.out.println(ll.isCycle());
        ll.removeCycle();
        System.out.println(ll.isCycle());
    }
}


