import java.time.LocalDate;

public class Task {
    private int ID;
    private String description;
    private TaskStatus status;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private static int IDCounter = 1;

    public Task(String description) {
        this.ID = IDCounter++;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public Task(int ID, String description, TaskStatus status, LocalDate creationDate, LocalDate updateDate) {
        this.ID = ID;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public String toJson() {
        return "{" +
                "\"ID\":" + ID +
                ", \"description\":\"" + description + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"creationDate\":\"" + creationDate + '\"' +
                ", \"updateDate\":\"" + updateDate + '\"' +
                '}';
    }

    public static Task fromJson(String json) {
        String[] parts = json.split(",");
        int ID = Integer.parseInt(parts[0].split(":")[1]);
        String description = parts[1].split(":")[1];
        TaskStatus status = TaskStatus.valueOf(parts[2].split(":")[1]);
        LocalDate creationDate = LocalDate.parse(parts[3].split(":")[1]);
        LocalDate updateDate = LocalDate.parse(parts[4].split(":")[1]);
        return new Task(ID, description, status, creationDate, updateDate);
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = LocalDate.now();
    }

    public static int getIDCounter() {
        return IDCounter;
    }

    public static void setIDCounter(int IDCounter) {
        Task.IDCounter = IDCounter;
    }

    @Override
    public String toString() {
        return ID +
                " description='" + description + '\'' +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate;
    }
}
