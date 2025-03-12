import TaskPackage.*;

import javax.swing.*;
import java.awt.*;


class View extends JFrame {
    private final DefaultListModel<Task> taskListModel = new DefaultListModel<>();
    private final JList<Task> taskList = new JList<>(taskListModel);
    private final JButton addButton = new JButton("Add Task");
    private final JButton deleteButton = new JButton("Delete Task");
    private final JButton editButton = new JButton("Edit Task");

    public View() {
        setTitle("Project3317");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public DefaultListModel<Task> getTaskListModel() {
        return taskListModel;
    }

    public JList<Task> getTaskList() {
        return taskList;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
}