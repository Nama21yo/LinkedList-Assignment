package Assignment2;

class SinglyLinkedList {

  private ListNode head;

  private static class ListNode {
    private int data; // Data of the node
    private ListNode next; // Pointer to the next node

    // Constructor to initialize the node with data
    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Method to insert a node at a specific position
  public void insertAtPos(int position, int value) {
    ListNode node = new ListNode(value);
    if (position == 1) {
      node.next = head;
      head = node;
    } else {
      ListNode previous = head;
      int count = 1;
      while (count < position - 1) {
        previous = previous.next;
        count++;
      }
      ListNode current = previous.next;
      previous.next = node;
      node.next = current;
    }
  }

  // Method to delete a node at a specific position
  public void deleteAtPosition(int position) {
    if (position == 1) {
      head = head.next;
    } else {
      ListNode previous = head;
      int count = 1;
      while (count < position - 1) {
        previous = previous.next;
        count++;
      }
      ListNode current = previous.next;
      previous.next = current.next;
    }
  }
  // Method to delete the node after a given node
  public void deleteAfterNode(ListNode node) {
    if (node == null || node.next == null) {
      return; // If the node is null or the next node is null, do nothing
    }
    ListNode temp = node.next; // Store the node to be deleted
    node.next = temp.next; // Link the current node to the node after the next
    temp.next = null; 
  }

  // Method to search for a value in the linked list
  public int searchNode(int value) {
    ListNode current = head;
    while (current != null) {
      if (current.data == value) {
        return value; // Alternatively, you could return a boolean (true) here.
      }
      current = current.next;
    }
    return -1; // Indicates that the value was not found.
  }

  // Method to display the linked list
  public void display() {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.print("null");
  }

  

  // Main method to test the linked list
  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();
    sll.head = new ListNode(10);
    ListNode second = new ListNode(1);
    ListNode third = new ListNode(8);
    ListNode fourth = new ListNode(11);

    // Connecting nodes to form a chain
    sll.head.next = second;
    second.next = third;
    third.next = fourth;

    // Displaying the list before insertion
    System.out.println("Single Linked List");
    sll.display();

    // Inserting nodes at various positions
    System.out.println("\nInsertion at any Position");
    sll.insertAtPos(1, 235);
    sll.insertAtPos(3, 455);
    sll.insertAtPos(2, 785);
    sll.insertAtPos(5, 536);
    sll.display();

    // Deleting nodes at various positions
    System.out.println("\nDelete at any Position");
    sll.deleteAtPosition(1);
    sll.deleteAtPosition(3);
    sll.display();

    // Deleting node after a specific node
    System.out.println("\nDelete after a given node");
    sll.deleteAfterNode(sll.head.next); // Deleting after the second node
    sll.display();

    // Searching for a value in the list
    System.out.println("\nThe Value Of the Element is: " + sll.searchNode(8));
  }
}
