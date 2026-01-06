package Datastructure.LinkedList.SinglyLinkedList;


public class SinglyLinkedList<T> {
    private Node head;
    private Node tail;
    private int length;


    class Node{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }
    }

    public SinglyLinkedList(T value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void append(T value){
        Node newNode = new Node(value);
        if (length == 0){
            tail = newNode;
            head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void traverse(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
