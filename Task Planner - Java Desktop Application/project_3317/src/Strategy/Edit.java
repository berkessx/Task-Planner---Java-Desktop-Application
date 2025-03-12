package Strategy;

import TaskPackage.Task;

import javax.swing.*;
import java.time.LocalDate;

public class Edit implements Strategy {
    @Override
    public Task execute(Task selectedTask) {


        String name = JOptionPane.showInputDialog("Task Name:", selectedTask.getName());
        String description = JOptionPane.showInputDialog("Task Description:", selectedTask.getDescription());
        String category = JOptionPane.showInputDialog("Task Category:", selectedTask.getCategory());
        String deadline = JOptionPane.showInputDialog("Task Deadline (YYYY-MM-DD):", selectedTask.getDeadline());

        Task task = null;
        if (name != null && description != null && category != null && deadline != null) {
             task = new Task(selectedTask.getId(), name, description, category, LocalDate.parse(deadline));
        }

        return task;
    }
}
