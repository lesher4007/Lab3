package exercise1;

public class CustomLinkedList implements CustomList{
    private Node head;
    private Node tail;

    @Override
    public void add(int data) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null){
            head = newNode;
        }else {
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            tail=newNode;
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        Node currentNode = head;
        StringBuilder sb = new StringBuilder("[");

        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(currentNode.next != null ? ", " : "");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public int getHead() {
        if (head==null) throw new IllegalArgumentException();;
        return head.data;
    }

    public int getTail() {
        if (head==null) throw new IllegalArgumentException();;
        return tail.data;
    }

    public int getHeadAndDelete() {
        if (head==null) throw new IllegalArgumentException();;
        int var = getHead();
        head = head.next;
        return var;
    }

    public int getTailAndDelete() {
        if (head==null) throw new IllegalArgumentException();;
        int var = getTail();
        Node currentNode = head;
        while (currentNode.next != tail){
            currentNode = currentNode.next;
        }
        tail = currentNode;
        currentNode.next = null;
        return var;
    }

    public void addHead(int data){
        Node newNode = new Node(data);
        newNode.next= head;
        head=newNode;
    }

    public void find(int data){
        if (head==null) return;
        Node currentNode = head;
        int count = 0;

        if (currentNode.data == data) count++;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            if(currentNode.data == data){
                count++;
            }
        }
        System.out.println("Совпадение присутствует " + count + " раз(а)");
    }
    public void replaceAll(int data){
        Node currentNode = head;
        head.data = data;

        while (currentNode.next != null){
            currentNode = currentNode.next;
            currentNode.data = data;
        }
    }
    public void remove(int data){
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode.next != null){

            if(currentNode.data ==data){
                if(currentNode == head){
                    head = currentNode.next;
                }else {
                    previousNode.next = currentNode.next;
                }
            }else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }
}
