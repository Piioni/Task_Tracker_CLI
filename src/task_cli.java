public class task_cli {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        System.out.println("Hello, World!");

        if (args.length == 0) {
            showUsage();
            return;
        }

        String command = args[0].toLowerCase();
        switch (command) {
            case "add":
                try {
                    // Comprobar si se ha pasado una descripción
                    if (notEnoughArguments(args)) {
                        return;
                    }
                    // Obtener la descripción de los argumentos
                    StringBuilder db = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        db.append(args[i]);
                        db.append(" ");
                    }
                    String description = db.toString().trim();
                    taskManager.addTask(description);
                    taskManager.saveTasks();

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Description is required");
                    showUsage();
                } catch (Exception e) {
                    System.out.println("An error occurred");
                    showUsage();
                }
                break;

            // Caso para actualizar una tarea
            case "update":
                try {
                    if (notEnoughArguments(args)) {
                        return;
                    }
                    // Obtener el ID de la task
                    int id = Integer.parseInt(args[1]);

                    // Obtener la descripción de los argumentos
                    StringBuilder db = new StringBuilder();
                    for (int i = 2; i < args.length; i++) {
                        db.append(args[i]);
                        db.append(" ");
                    }
                    String description = db.toString().trim();
                    taskManager.updateTask(id, description);
                    taskManager.saveTasks();

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ID and description are required");
                    showUsage();
                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number");
                } catch (Exception e) {
                    System.out.println("An error occurred");
                    showUsage();
                }
                break;

            // Caso para marcar una tarea como en progreso
            case "mark-in-progress":
                if (notEnoughArguments(args)) {
                    return;
                }

                // Obtener el ID de la tarea y marcarla como en progreso
                try {
                    int id = Integer.parseInt(args[1]);
                    taskManager.markTaskAsProgress(id);
                    taskManager.saveTasks();

                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number");
                }
                break;

            // Caso para marcar una tarea como hecha
            case "mark-done":
                if (notEnoughArguments(args)) {
                    return;
                }

                // Obtener el ID de la tarea y marcarla como hecha
                try {
                    int id = Integer.parseInt(args[1]);
                    taskManager.markTaskAsDone(id);
                    taskManager.saveTasks();

                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number");
                }
                break;

            // Caso para eliminar una tarea
            case "delete":
                if (notEnoughArguments(args)) {
                    return;
                }

                // Obtener el ID de la tarea y eliminarla
                try {
                    int id = Integer.parseInt(args[1]);
                    taskManager.deleteTask(id);
                    taskManager.saveTasks();

                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number");
                }
                break;

            // Caso para listar todas las tareas
            case "list":
                // Caso para listar todas las tareas
                if (args.length == 1) {
                    taskManager.listTasks();
                }
                // Caso para listar todas las tareas con un estado específico
                else if (args.length == 2) {
                    taskManager.listTasks(TaskStatus.valueOf(args[1].toUpperCase()));
                } else {
                    System.out.println("Invalid command");
                    showUsage();
                }
                break;

            // Comando help
            case "help":
                showUsage();
                break;

            // Comando no válido
            default:
                System.out.println("Invalid command");
                showUsage();
                break;
        }
    }

    // Comprueba si se han pasado suficientes argumentos
    public static boolean notEnoughArguments(String[] args) {
        if (args.length < 2) {
            System.out.println("Description is required");
            showUsage();
            return true;
        }
        return false;
    }

    public static void showUsage() {
        System.out.println("Usage: java task_cli <command> <options>");
        System.out.println("Commands:");
        System.out.println("add <description> - Add a new task");
        System.out.println("update <id> <description> - Update a task");
        System.out.println("delete <id> - Delete a task");
        System.out.println("mark-in-progress <id> - Mark a task as in progress");
        System.out.println("mark-done <id> - Mark a task as done");
        System.out.println("list - List all tasks");
        System.out.println("list <status> - List all tasks with the given status");
        System.out.println("help - Show the usage");
    }
}