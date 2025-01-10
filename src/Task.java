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

    public Task(String description, TaskStatus status) {
        this.ID = IDCounter++;
        this.description = description;
        this.status = status    ;
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
