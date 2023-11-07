package exercise2;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList list2 =new DoublyLinkedList();

        list.add(11);
        list.add(12);
        list.add(13);
        list2.add(21);
        list2.add(22);
        list2.add(23);
        list2.add(24);
        list2.add(25);

        int[] array = new int[]{1,2,3};

        list.print();
        list.addLinkedList(list2);
        list.print();
        list.reversPrint();
        System.out.println();
        list2.print();
        list2.reversPrint();






    }
}
