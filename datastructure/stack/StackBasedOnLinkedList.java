public class StackBasedOnLinkedList {

    private Node top= null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode; 
        }
    }

    public int pop() {
        if(top == null) return -1;
        int ret = top.value;
        top = top.next;
        return ret;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}