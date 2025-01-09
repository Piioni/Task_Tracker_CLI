import java.time.LocalDate;

public class Task {
    private int ID;
    private String description;
    private TaskStatus status;
    private LocalDate creationDate;
    private LocalDate updateDate;

    public Task(int ID, String description, TaskStatus status) {
        this.ID = ID;
        this.description = description;
        this.status = status;
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }


}
