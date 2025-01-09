import java.util.ArrayList;

public class TaskManager {
    private final String PATH = "tasks.json";
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = loadTasks();
    }

    private ArrayList<Task> loadTasks() {
        return new ArrayList<>();
    }

}
