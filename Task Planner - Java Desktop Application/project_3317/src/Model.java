import TaskPackage.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Model {
    private final String DB_URL = "jdbc:mysql://localhost:3306/task_planner";
    private final String USER = "root";
    private final String PASSWORD = "12345678";

    public Model() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        String createDatabase = "CREATE DATABASE IF NOT EXISTS task_planner;";
        String useDatabase = "USE task_planner;";
        String createTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "description TEXT NOT NULL," +
                "category VARCHAR(100) NOT NULL," +
                "deadline DATE NOT NULL);";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDatabase);
            statement.executeUpdate(useDatabase);
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getDate("deadline").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void addTask(Task task) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO tasks (name, description, category, deadline) VALUES (?, ?, ?, ?)")
        ) {
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getCategory());
            ps.setDate(4, Date.valueOf(task.getDeadline()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int taskId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE id = ?")) {
            ps.setInt(1, taskId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(Task task) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE tasks SET name = ?, description = ?, category = ?, deadline = ? WHERE id = ?")) {
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getCategory());
            ps.setDate(4, Date.valueOf(task.getDeadline()));
            ps.setInt(5, task.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}