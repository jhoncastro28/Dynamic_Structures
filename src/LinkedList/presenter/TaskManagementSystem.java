package LinkedList.presenter;

import LinkedList.view.View;
import LinkedList.model.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jhonm
 */
public class TaskManagementSystem {
    private View view;
    private Model model;

    public TaskManagementSystem() {
        model = new Model();
        view = new View();
    }
    
    public static void main(String[] args) {
        new TaskManagementSystem().run();
    }
    
    public void run(){
        int option = 0;
        while(option != 2){
            option = showMenu();
            switch(option){
                case 1:
                    usersTasks();
                    break;
                case 2:
                    showUsersTasks();
                    break;
                default:
                    view.showMessage("Parametro incorrecto");
                    break;
            }
        }
    }

    private int showMenu() {
        int option = view.readInt("-- MENU PRINCIPAL -- \n1)Asignar tareas a los usuarios "
                                  + "\n2)Ver las tareas que tienen asignadas "
                                  + "\n3)Salir \nDigite opcion: ");
        return option;
    }

    private void usersTasks() {
        int users = view.readInt("¿Cuantos usuarios hay?");
        for (int i = 1; i <= users; i++) {
            model.addUser("usuario" + i);
            String task = view.readData("¿Que tarea quiere asignar al usuario" + i + "?");
            model.addTask(task, new Date());
            model.assignTaskToUser(task, "usuario" + i);
        }
    }

    private void showUsersTasks() {
        for (String username : model.getUsers().keySet()) {
            List<Task> userTasks = model.getTasksForUser(username);
            view.showMessage("Tareas asignadas a " + username + ":");
            for (Task task : userTasks) {
                view.showMessage(task.getDescription() + " - Fecha: " + task.getDueDate());
            }
        }
    }
}
