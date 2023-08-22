package LinkedList.model;

import LinkedList.presenter.TaskManagementSystem;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jhonm
 */
public class Task {
    private String description;
    private Date dueDate;
    private String assignedUser;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void assignUser(String user) {
        assignedUser = user;
    }
}
