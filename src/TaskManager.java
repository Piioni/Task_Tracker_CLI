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

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void addTask(String description, TaskStatus status) {
        Task task = new Task(description, status);
        tasks.add(task);
    }

    public void updateTask(int id, String description) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(description);
            task.setUpdateDate();
            tasks.set(tasks.indexOf(task), task);

        }else{
            System.out.println("Task not found");
        }
    }

    public void updateTask(int id, TaskStatus status) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(status);
            task.setUpdateDate();
            tasks.set(tasks.indexOf(task), task);
        }else{
            System.out.println("Task not found");
        }
    }

    public void updateTask(int id, String description, TaskStatus status) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(description);
            task.setStatus(status);
            task.setUpdateDate();
            tasks.set(tasks.indexOf(task), task);
        }else{
            System.out.println("Task not found");
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
        }else{
            System.out.println("Task not found");
        }
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

}
