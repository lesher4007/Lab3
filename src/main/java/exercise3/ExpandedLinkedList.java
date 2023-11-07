package exercise3;

import java.util.Arrays;
import java.util.Objects;

public class ExpandedLinkedList{
    private Node head;
    private Node tail;

    public void add(Integer data) {
        Node currentNode = head;
        Integer[] array = new Integer[10];
        int count = 0;
        boolean var = false;

        if (head == null){
            array[0] = data;
            head = tail = new Node(array);
        }else {
            while (currentNode != null){
                for (int i = 0; i < array.length; i++) {
                    count++;
                    if (currentNode.data[i]==null) {
                        currentNode.data[i]=data;
                        var = true;
                        break;
                    }
                }
                    if (currentNode.next == null && count == array.length){
                    if (var){
                        break;
                    }else {
                        currentNode.next = new Node(array);
                        tail = currentNode.next;
                    }
                }
                currentNode = currentNode.next;
                count=0;
            }
        }
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        Node currentNode = head;
        StringBuilder sb = new StringBuilder("[");

        while (currentNode != null) {
            sb.append(Arrays.toString(currentNode.data));
            sb.append(currentNode.next != null ? ", " : "");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node{
        private Integer[] data;
        private Node next;

        public Node(Integer[] data) {
            this.data = data;
            next = null;
        }
        public Node() {
            data = null;
            next = null;
        }
    }

    public Integer[] getHead() {
        if (head==null) throw new IllegalArgumentException();;
        return head.data;
    }

    public Integer[] getTail() {
        if (head==null) throw new IllegalArgumentException();;
        return tail.data;
    }

    public Integer[] getHeadAndDelete() {
        if (head==null) throw new IllegalArgumentException();;
        Integer[] var = getHead();
        head = head.next;
        return var;
    }

    public Integer[] getTailAndDelete() {
        if (head==null) throw new IllegalArgumentException();;
        Integer[] var = getTail();
        Node currentNode = head;
        while (currentNode.next != tail){
            currentNode = currentNode.next;
        }
        tail = currentNode;
        currentNode.next = null;
        return var;
    }

    public void addHead(Integer[] data){
        Node currentNode = head;
        Node newNode = new Node(data);
        ExpandedLinkedList newList = new ExpandedLinkedList();
        if(head!=null) {
            if(data.length == 10) {
                newNode.next = head;
                head = tail = newNode;
            }else {
                for (Integer datum : data) {
                    newList.add(datum);
                }
                while (currentNode != null){
                    for (int i = 0; i < currentNode.data.length; i++) {
                        newList.add(currentNode.data[i]);
                    }
                    currentNode = currentNode.next;
                    tail = currentNode;
                }
            }
            head = newList.head;
        }else {
            if (data.length <= 10) {
                head = tail = newNode;
            } else {
                for (Integer datum : data) {
                    add(datum);
                }
            }
        }
    }

    public void addTail(Integer[] data){
        if (head!=null){
            for (Integer datum : data) {
                add(datum);
            }
        }else {
            head = tail = new Node(data);
        }
    }

    public void find(Integer data){
        if (head==null) return;
        Node currentNode = head;
        int count = 0;
        while (currentNode != null){
            for (int i = 0; i < currentNode.data.length; i++) {
                if(Objects.equals(currentNode.data[i], data)){
                    count++;
                }
            }
            currentNode = currentNode.next;
        }
        System.out.println("Совпадение присутствует " + count + " раз(а)");
    }

    public void remove(int data){
        if (head==null) return;
        Node currentNode = head;
        ExpandedLinkedList newList = new ExpandedLinkedList();
        while (currentNode != null){
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i]==null)break;
                if (currentNode.data[i] == data) {
                    currentNode.data[i] = null;
                }
                if (currentNode.data[i]!= null) newList.add(currentNode.data[i]);
            }
            currentNode = currentNode.next;
        }
        head = newList.head;
    }

    public void absorptionLinkedListHead(ExpandedLinkedList linkedList){
        Node currentNode = head;
        ExpandedLinkedList newList = new ExpandedLinkedList();

        if(head==null) {
            tail = linkedList.tail;
            head = linkedList.head;
        }else {
            while (currentNode != null) {
                for (int i = 0; i < currentNode.data.length; i++) {
                    linkedList.add(currentNode.data[i]);
                }
                currentNode = currentNode.next;
                tail = currentNode;
            }
            tail = linkedList.tail;
            head = linkedList.head;

            linkedList.head =null;
        }
    }

    public void absorptionLinkedListTail(ExpandedLinkedList linkedList){
        Node currentNode = linkedList.head;


        if(head==null) {
            head = linkedList.head;
        }else {
            while (currentNode != null) {
                for (int i = 0; i < currentNode.data.length; i++) {
                    add(currentNode.data[i]);
                }
                currentNode = currentNode.next;
            }
            linkedList.head =null;
        }
    }

    public void replaceAll(int data){
        Node currentNode = head;

        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                currentNode.data[i]= data;
            }
            currentNode = currentNode.next;
            tail = currentNode;
        }
    }
}
