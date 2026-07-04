public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Adding Tasks
        manager.addTask(new Task("T101", "Database Migration", "Pending"));
        manager.addTask(new Task("T102", "Code Review", "In Progress"));
        manager.addTask(new Task("T103", "UI bug fixes", "Completed"));

        System.out.println("=== Initial Task List ===");
        manager.traverseTasks();

        // Searching for a Task
        System.out.println("\n=== Searching for Task T102 ===");
        Task found = manager.searchTask("T102");
        System.out.println(found != null ? found : "Task not found.");

        // Deleting a Task
        System.out.println("\n=== Deleting Task T102 ===");
        manager.deleteTask("T102");

        System.out.println("\n=== Updated Task List ===");
        manager.traverseTasks();
    }
}