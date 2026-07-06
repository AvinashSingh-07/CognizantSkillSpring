public class TaskManager {
    
    // Internal Node structure representing each link in the list
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head = null;

    // --- ADD TASK (Appends to the end of the list) ---
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // --- TRAVERSE TASKS (Prints the entire list) ---
    public void traverseTasks() {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // --- SEARCH TASK (Finds a task by its ID) ---
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // --- DELETE TASK (Removes a task by its ID) ---
    public boolean deleteTask(String taskId) {
        if (head == null) return false;

        // Case 1: The task to remove is at the head node
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }

        // Case 2: The task is deeper in the list
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next; // Bypass the deleted node
                return true;
            }
            current = current.next;
        }
        return false; // Task to delete was not found
    }
}