package TaskPackage;

import java.time.LocalDate;

public class Task extends componentTask{
    public Task(int id, String name, String description, String category, LocalDate deadline) {
        super(id, name, description, category, deadline);
    }
}