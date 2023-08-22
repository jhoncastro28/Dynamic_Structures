package LinkedList.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jhonm
 */
public class Model {
    
    private HashMap<String, User> users;
    private LinkedList<Task> tasks;

    public Model() {
        tasks = new LinkedList<>();
        users = new HashMap<>();
    }
    
    public void addUser(String username) {
        User user = new User(username);
        users.put(username, user);
    }
    
    public void addTask(String description, Date dueDate) {
        Task task = new Task(description, dueDate);
        tasks.add(task);
    }
    
    public List<Task> getTasksForUser(String username) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignedUser() != null && task.getAssignedUser().equals(username)) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }
    
    private Task findTaskByDescription(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return task;
            }
        }
        return null;
    }
    
    public void assignTaskToUser(String taskDescription, String username) {
        Task taskToAssign = findTaskByDescription(taskDescription);
        if (taskToAssign != null) {
            taskToAssign.assignUser(username);
        }
    }
    
    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

}
