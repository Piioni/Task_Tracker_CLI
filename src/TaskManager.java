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
        System.out.println("Task added successfully");
    }

    public void updateTask(int id, String description) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(description);
            task.setUpdateDate();
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    public void markTaskAsDone(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(TaskStatus.DONE);
            task.setUpdateDate();
            System.out.println("Task marked as done successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    public void markTaskAsProgress(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(TaskStatus.IN_PROGRESS);
            task.setUpdateDate();
            System.out.println("Task marked as IN_Progress successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            // para eliminar una tarea del ArrayList
            tasks.remove(task);
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    public void listTasks() {
        // Imprimir el encabezado de la tabla
        System.out.println("All tasks");
        System.out.printf("%-8s | %-40s | %-15s | %-15s | %-15s\n", "ID", "Description", "Status", "Creation Date", "Update Date");
        for (Task task : tasks) {
            System.out.printf("%-8d | %-40s | %-15s | %-15s | %-15s\n",
                    task.getID(),
                    task.getDescription(),
                    task.getStatus(),
                    task.getCreationDate(),
                    task.getUpdateDate());
        }
    }

    public void listTasks(TaskStatus status) {
        System.out.println("Tasks with status " + status.getStatus());
        // Imprimir el encabezado de la tabla
        System.out.printf("%-8s | %-40s | %-15s | %-15s\n", "ID", "Description",  "Creation Date", "Update Date");
        // Recorrer la lista de tareas y mostrar solo las tareas con el estado proporcionado
        for (Task task : tasks) {
            if (task.getStatus().equals(status.getStatus())) {
                System.out.printf("%-8d | %-40s | %-15s | %-15s\n",
                        task.getID(),
                        task.getDescription(),
                        task.getCreationDate(),
                        task.getUpdateDate());

            }
        }
    }

    // para buscar una tarea por su id
    public Task findTaskById(int id) {
        // Recorrer la lista de tareas y devolver la tarea con el id proporcionado
        for (Task task : tasks) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

}
