package exercise3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ExpandedLinkedList list = new ExpandedLinkedList();
        ExpandedLinkedList list2 = new ExpandedLinkedList();

        list.add(20);
        list.add(21);
        list.add(22);
        list.add(23);
        list.add(24);
        list.add(25);
        list.add(26);
        list.add(27);
        list.add(28);
        list.add(29);
        list.add(30);
        list.add(31);
        list.add(32);
        list.add(33);
        list.add(34);
        list.add(35);
        list.add(36);
        list.add(37);
        list.add(38);
        list.add(39);
        list.add(40);

        list2.add(120);
        list2.add(121);
        list2.add(122);
        list2.add(123);
        list2.add(124);
        list2.add(125);
        list2.add(126);
        list2.add(127);
        list2.add(128);
        list2.add(129);
        list2.add(130);
        list2.add(131);
        list2.add(132);
        list2.add(133);
        list2.add(134);
        list2.add(135);
        list2.add(136);
        list2.add(137);
        list2.add(138);
        list2.add(139);
        list2.add(140);

        Integer[] array = new Integer[]{0,1,2,3,4};

        list.print();
        list.replaceAll(10);
        list.absorptionLinkedListTail(list2);
        System.out.println();
        list.print();
        list2.print();






    }
}
