package exercise2;

import exercise1.CustomList;

public class DoublyLinkedList implements CustomList {
    private Node head;
    private Node tail;

    @Override
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void reversPrint() {
        System.out.println(this.reverstoString());
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
    public String reverstoString() {
        Node currentNode = tail;
        StringBuilder sb = new StringBuilder("[");
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(currentNode.prev != null ? ", " : "");
            currentNode = currentNode.prev;
        }
        sb.append("]");
        return sb.toString();
    }

    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;

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
        if(head.next== null){
            head = tail =null;
        }else {
            head = head.next;
            head.prev = null;
        }
        return var;
    }

    public int getTailAndDelete() {
        if (head==null) throw new IllegalArgumentException();;
        int var = getTail();
        if(tail.prev == null){
            head = tail =null;
        }else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        return var;
    }

    public void addByIndex(int data, int index){
        Node currentNode = head;
        int c = 0;
        Node newNode = new Node(data);

        if (index==0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            while (currentNode.next != null && c != index) {
                currentNode = currentNode.next;
                c++;
            }
            if (index>c){
                throw  new IllegalArgumentException();
            }
            currentNode.prev.next = newNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
            newNode.next = currentNode;
        }
   }

    public void addHead(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
        }else {
            head.prev = newNode;
        }
        newNode.next= head;
        head=newNode;
    }

    public void find(int data){
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

    public void remove(int data){
        if(head!=null) {
            Node currentNode = head;
            while (currentNode != null) {

                if (currentNode.data == data) {
                    if (currentNode == head) {
                        if(currentNode.next==null){
                            head = null;
                            tail = null;
                        }else {
                            currentNode.next.prev = null;
                            head = currentNode.next;
                        }
                    } else if (currentNode == tail) {
                        currentNode.prev.next = null;
                        tail = currentNode.prev;

                    } else {
                        currentNode.next.prev = currentNode.prev;
                        currentNode.prev.next = currentNode.next;
                    }
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void replaceAll(int data){
        if(head == null){return;}
        Node currentNode = head;
        head.data = data;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            currentNode.data = data;
        }
    }

    public void addArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    public void addTailLinkedList(DoublyLinkedList list){
        if(head == null){return;}
        Node currentNode = list.head;
        while (currentNode != null) {
            add(list.getHeadAndDelete());
            currentNode = currentNode.next;
        }
    }
    public void addLinkedList(DoublyLinkedList list){
        if(head == null){return;}
        Node currentNode = list.tail;
        while (currentNode != null) {
            addHead(currentNode.data);
            currentNode = currentNode.prev;
        }
        list.tail = list.head = null;
    }
}

















//    public void addArray(int[] array){
//
//        for (int i = 0, y =array.length-1; i < array.length; i++, y--) {
//            addHead(array[y]);
//        }
//    }


