public enum TaskStatus {
    DONE("Done"),
    IN_PROGRESS("In progress"),
    TODO("To-do");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

