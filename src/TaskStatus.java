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

    public static boolean contains(String status) {
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.name().equals(status)) {
                return true;
            }
        }
        return false;
    }

}

