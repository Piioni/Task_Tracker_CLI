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
                try{
                    if (args.length == 3) {
                        System.out.println("Add command");
                        taskManager.addTask(args[1], TaskStatus.valueOf(args[2].toUpperCase()));
                        return;
                    }else if (args.length == 2){
                        System.out.println("Add command");
                        taskManager.addTask(args[1]);
                        return;
                    }
                    if (args.length < 2) {
                        System.out.println("Description is required");
                        showUsage();
                        return;
                    }
                    StringBuilder db = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        db.append(args[i]);
                        db.append(" ");
                    }
                    String description = db.toString().trim();
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Description is required");
                    showUsage();
                } catch (Exception e){
                    System.out.println("An error occurred");
                    showUsage();
                }
                System.out.println("Task added successfully, description: " + args[1]);
                break;

            case "update":
                try {
                    if (args.length == 4) {
                        System.out.println("Update command");
                        if (TaskStatus.contains(args[3].toUpperCase())) {
                            taskManager.updateTask(Integer.parseInt(args[1]), args[2], TaskStatus.valueOf(args[3].toUpperCase()));
                            return;
                        }else {
                            System.out.println("Invalid status");
                            showUsage();
                            return;
                        }
                    } else if (args.length == 3) {
                        if (TaskStatus.contains(args[2].toUpperCase())) {
                            System.out.println("Update command");
                            taskManager.updateTask(Integer.parseInt(args[1]), TaskStatus.valueOf(args[2].toUpperCase()));
                            return;
                        }else {
                            System.out.println("Update command");
                            taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
                            return;
                        }
                    }
                    if (args.length < 3) {
                        System.out.println("ID and description or status are required");
                        showUsage();
                        return;
                    }
                    StringBuilder db = new StringBuilder();
                    for (int i = 2; i < args.length; i++) {
                        db.append(args[i]);
                        db.append(" ");
                    }
                    String description = db.toString().trim();
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("ID and description are required");
                    showUsage();
                } catch (Exception e){
                    System.out.println("An error occurred");
                    showUsage();
                }
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("ID is required");
                    showUsage();
                    return;
                } else {
                    System.out.println("Delete command");
                    taskManager.deleteTask(Integer.parseInt(args[1]));
                }
                break;
            case "list":
                System.out.println("List command");
                if (args.length == 1) {
                    taskManager.listTasks();
                } else if (args.length == 2) {
                    taskManager.listTasks(TaskStatus.valueOf(args[1].toUpperCase()));
                } else {
                    System.out.println("Invalid command");
                    showUsage();
                }

                break;
            case "help":
                showUsage();
                break;
            default:
                System.out.println("Invalid command");
                showUsage();
                break;
        }



    }

    public static void showUsage(){
        System.out.println("Usage: java task_cli <command> <options>");
        System.out.println("Commands:");
        System.out.println("add <description> - Add a new task");
        System.out.println("update <id> <description> - Update a task");
        System.out.println("delete <id> - Delete a task");
        System.out.println("list - List all tasks");
        System.out.println("list <status> - List all tasks with the given status");
        System.out.println("help - Show the usage");
    }
}