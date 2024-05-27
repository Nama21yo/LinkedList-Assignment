package Assignment2;

// Create Stack Using Linked list
public class StackUsingLinkedlist {
 
    // A linked list node
    private static class Node {
        int data; // Integer data
        Node link; // Reference to the next node
    }

    // Top reference variable for the stack
    private Node top;

    // Constructor
    public StackUsingLinkedlist() { 
        this.top = null; 
    }
 
    // Utility function to add an element x in the stack
    public void push(int x) {
        // Create new node temp and allocate memory
        Node temp = new Node();
        
        // Initialize data into temp data field
        temp.data = x;

        // Put top reference into temp link
        temp.link = top;

        // Update top reference
        top = temp;
    }
 
    // Utility function to check if the stack is empty or not
    public boolean isEmpty() { 
        return top == null; 
    }
 
    // Utility function to return top element in the stack
    public int peek() {
        // Check for empty stack
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
 
    // Utility function to pop top element from the stack
    public void pop() {
        // Check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }

        // Update the top pointer to point to the next node
        top = top.link;
    }
 
    // Utility function to display the stack
    public void display() {
        // Check for stack underflow
        if (top == null) {
            System.out.println("\nStack Underflow");
            return;
        } else {
            Node temp = top;
            while (temp != null) {
                // Print node data
                System.out.print(temp.data);

                // Move to the next node
                temp = temp.link;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
        }
    }
}

class StackList {
    public static void main(String[] args) {
        StackUsingLinkedlist obj = new StackUsingLinkedlist();

        // Insert stack values
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
 
        // Print stack elements
        obj.display();
 
        // Print top element of stack
        System.out.printf("\nTop element is %d\n", obj.peek());
 
        // Delete top elements of stack
        obj.pop();
        obj.pop();
 
        // Print stack elements after popping
        obj.display();
 
        // Print top element of stack
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}
