package mohamed.arfa.problemsolving.Datastructure.LinkedList;

import mohamed.arfa.problemsolving.Datastructure.LinkedList.SinglyLinkedList.SinglyLinkedList;

public class MainLinkedList {

    public void main() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>(4);

        singlyLinkedList.traverse();
        singlyLinkedList.append(5);
        singlyLinkedList.append(7);
        singlyLinkedList.traverse();
    }
}
