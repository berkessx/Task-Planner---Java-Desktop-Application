import TaskPackage.Task;
import Strategy.*;

import javax.swing.*;


class Controller {
    private final Model model;
    private final View view;

    Strategy strategy;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void setStrategy(Strategy strat) {
        strategy = strat;
    }

    public void initialize() {
        refreshTaskList();

        view.getAddButton().addActionListener(e -> addTask());
        view.getDeleteButton().addActionListener(e -> deleteTask());
        view.getEditButton().addActionListener(e -> editTask());
    }

    private void refreshTaskList() {
        view.getTaskListModel().clear();
        for (Task task : model.getTasks()) {
            view.getTaskListModel().addElement(task);
        }
    }

    private void addTask() {
        setStrategy(new Add());
        Task task = strategy.execute(null);

        model.addTask(task);
        refreshTaskList();
    }


    private void editTask() {
        Task selectedTask = view.getTaskList().getSelectedValue();

        if (selectedTask != null) {

            setStrategy(new Edit());
            Task t = strategy.execute(selectedTask);

            model.updateTask(t);
            refreshTaskList();
        } else {
            JOptionPane.showMessageDialog(view, "No task selected.");
        }
    }

    private void deleteTask() {
        Task selectedTask = view.getTaskList().getSelectedValue();
        if (selectedTask != null) {
            model.deleteTask(selectedTask.getId());
            refreshTaskList();
        } else {
            JOptionPane.showMessageDialog(view, "No task selected.");
        }
    }
}