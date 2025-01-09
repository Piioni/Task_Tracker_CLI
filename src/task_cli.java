public class task_cli {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        if (args.length == 0) {
            showUsage();
            return;
        }

        String command = args[0].toLowerCase();
        switch (command) {
            case "add":
                try{
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
                Task task = new Task("description");
                System.out.println("Task added successfully, ID: " + task.getID());
                break;

            case "update":
                System.out.println("Update command");
                break;
            case "delete":
                System.out.println("Delete command");
                break;
            case "list":
                System.out.println("List command");
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