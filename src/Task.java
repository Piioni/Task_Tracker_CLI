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


    public int getID() {
        return ID;
    }
}
