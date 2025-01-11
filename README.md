# Task Tracker
This is a simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks directly from the terminal. All tasks are stored as JSON objects in a file for persistence.

It is inspired from the [Tasks Tracker](https://roadmap.sh/projects/task-tracker) project from [roadmap.sh](https://roadmap.sh/).

# Features
- Add tasks: Add a new task with a specified description.
- Update a task: Update the description of a task by a given id.
- Delete a task: Delete a task by a given id.
- Mark a task: Mark a task as "done" or "in progress" by a given id.
- List tasks: List all tasks or filter them by a given status.

# Installation
1. Clone the repository:
```bash
git clone https://github.com/Piioni/Task_Tracker_CLI.git
cd Task_Tracker_CLI/src
```
2. Compile the source code:
```bash
javac task_cli.java Task.java TaskStatus.java TaskManager.java
```
3. Run the application:
```bash
java task_cli <command> <arguments>
```

# Usage
The application supports the following commands:
- `add <description>`: Add a new task with the specified description.
- `update <id> <description>`: Update the description of a task by the given id.
- `delete <id>`: Delete a task by the given id.
- `mark-in-progress <id>`: Mark a task as "in progress" by the given id.
- `mark-done <id>`: Mark a task as "done" by the given id.
- `list`: List all tasks.
- `list <status>`: List all tasks with the specified status.
- `help`: Display the help message.
- `exit`: Exit the application.

# Examples
```bash
// Add a new task:
java task_cli add "Create a new project"

// Update a task:
java task_cli update 1 "Create a new project with Java"

// Delete a task:
java task_cli delete 1

// Mark a task as "in progress":
java task_cli mark-in-progress 1

// Mark a task as "done":
java task_cli mark-done 1

// List all tasks:
java task_cli list

// List tasks with a specific status:
java task_cli list "in progress"


```


# Notes 
- The program tasks are stored in tasks.json located in the project directory.
- If the JSON file is missing, the application creates one on startup.

# Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


