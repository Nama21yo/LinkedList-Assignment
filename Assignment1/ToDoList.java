package Assignment1;

public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title \"" + title + "\" not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task("Task 1", "Description of Task 1");
        Task task2 = new Task("Task 2", "Description of Task 2");
        Task task3 = new Task("Task 3", "Description of Task 3");

        ToDoList toDoList = new ToDoList();
        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Task 2");

        System.out.println("\nTo-Do List after marking Task 2 as completed:");
        toDoList.viewToDoList();
    }
}
