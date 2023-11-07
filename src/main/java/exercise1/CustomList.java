package exercise1;

public interface List {
    void add(int data){
        LinkedList.Node newNode = new LinkedList.Node(data);
        LinkedList.Node currentNode = head;

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
    public void print(){
        LinkedList.Node currentNode = head;
        if(head != null){
            System.out.println(head.data);
        }
        while (currentNode.next!=null){
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}
