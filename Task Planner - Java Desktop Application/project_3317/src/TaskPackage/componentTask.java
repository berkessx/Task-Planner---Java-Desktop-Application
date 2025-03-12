package TaskPackage;

import java.time.LocalDate;

public abstract class componentTask {
    private int id;
    private String name;
    private String description;
    private String category;
    private LocalDate deadline;


    public componentTask(int id, String name, String description, String category, LocalDate deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Due: " + deadline;
    }
}
