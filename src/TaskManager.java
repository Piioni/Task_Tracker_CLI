import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TaskManager {
    private final Path PATH_FILE = Path.of("tasks.json");
    private final ArrayList<Task> tasks;

    public TaskManager() {
        tasks = loadTasks();
    }

    private ArrayList<Task> loadTasks() {
        // Verificar si el archivo existe
        if (!Files.exists(PATH_FILE)){
            return new ArrayList<>();
        }
        // Leer el archivo y convertir el contenido a una lista de tareas utilizando el metodo fromJson
        try {
            String json = Files.readString(PATH_FILE);
            // Dividir el contenido del archivo obviando los corchetes iniciales y finales y separando cada tarea por },
            String[] parts = json.substring(1, json.length() - 1).split("},");
            ArrayList<Task> tasks = new ArrayList<>();
            for (String part : parts) {
                tasks.add(Task.fromJson(part + "}"));
            }
            return tasks;
        } catch (Exception e) {
            System.out.println("An error occurred while loading the tasks");
            return new ArrayList<>();
        }
    }

    public void saveTasks() {
        // Convertir la lista de tareas a un formato JSON
        StringBuilder json = new StringBuilder("[");
        for (Task task : tasks) {
            json.append(task.toJson());
            json.append(",");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]");
        // Guardar el contenido en el archivo
        try {
            Files.writeString(PATH_FILE, json);
        } catch (Exception e) {
            System.out.println("An error occurred while saving the tasks");
        }
    }

    // crea una tarea y la agrega a la lista de tareas
    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully");
    }

    public void updateTask(int id, String description) {
        Task task = findTaskById(id);
        if (task != null) {
            // Actualizar la descripción de la tarea
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
            // Actualizar el estado de la tarea a DONE
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
            // Actualizar el estado de la tarea a IN_PROGRESS
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
        // Verificar si el estado proporcionado es válido
        if (!TaskStatus.contains(status.getStatus())) {
            System.out.println("Invalid status");
            return;
        }

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
    private Task findTaskById(int id) {
        // Recorrer la lista de tareas y devolver la tarea con el id proporcionando
        for (Task task : tasks) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

}
