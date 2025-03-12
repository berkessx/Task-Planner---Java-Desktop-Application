package Strategy;

import TaskPackage.Task;

import javax.swing.*;
import java.time.LocalDate;


public class Add implements Strategy {
    @Override
    public Task execute(Task t) {
        String name = JOptionPane.showInputDialog("Task Name:");
        String description = JOptionPane.showInputDialog("Task Description:");
        String category = JOptionPane.showInputDialog("Task Category:");
        String deadline = JOptionPane.showInputDialog("Task Deadline (YYYY-MM-DD):");

        if (name != null && description != null && category != null && deadline != null) {
            Task task = new Task(0, name, description, category, LocalDate.parse(deadline));
            return task;
        }
        return null;
    }
}
