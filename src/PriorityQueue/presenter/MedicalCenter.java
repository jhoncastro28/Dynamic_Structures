package PriorityQueue.presenter;

import PriorityQueue.model.Patient;
import PriorityQueue.view.View;
import java.util.PriorityQueue;

/**
 *
 * @author jhonm
 */
public class MedicalCenter {

    private PriorityQueue<Patient> patientQueue;
    private View view;

    public MedicalCenter() {
        patientQueue = new PriorityQueue<>();
        view = new View();
    }

    public static void main(String[] args) {
        new MedicalCenter().run();
    }

    public void logPatients() {
        while (true) {
            String input = view.readData("Ingrese el nombre del paciente (o 'exit' para volver al Menu Principal)");
            int severity = view.readInt("Ingrese el grado de gravedad del paciente (numero entero): ");
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Añadir pacientes a la Cola
            Patient patient = new Patient(input, severity);
            patientQueue.add(patient);
        }

    }

    public void treatPatients() {
        //Tratarlos en orden de Gravedad
        while (!patientQueue.isEmpty()) {
            Patient nextPatient = patientQueue.poll();
            view.showMessage("Tratando al paciente: " + nextPatient.getName() + " (Gravedad: " + nextPatient.getSeverity() + ")");
        }
    }

    public void run() {
        int option = 0;
        while (option != 2) {
            option = showMenu();
            switch (option) {
                case 1:
                    logPatients();
                    break;
                case 2:
                    treatPatients();
                    break;
                default:
                    view.showMessage("Parametro incorrecto");
                    break;
            }
        }
    }

    private int showMenu() {
        int option = 0;
        option = view.readInt("Bienvenido al Centro Medico! \n1)Registrar pacientes y su estado de Gravedad "
                + "\n2)Tratar a los pacientes teniendo en cuenta su estado\n3)Salir"
                + "\nDigite opcion");

        return option;
    }

}
