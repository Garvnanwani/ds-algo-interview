class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class LinkedList {
  Node head;

  LinkedList() {
    head = null;
  }

  void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert(10);
    list.insert(20);
    list.insert(30);
    list.insert(40);
    list.insert(50);
    list.printList();
  }

}
