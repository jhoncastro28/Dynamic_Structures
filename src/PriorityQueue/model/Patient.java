package PriorityQueue.model;

/**
 *
 * @author jhonm
 */
public class Patient implements Comparable<Patient>{
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient patient) {
        // Los pacientes de mayor gravedad deberían ir primero en la cola
        return Integer.compare(patient.severity, this.severity);
    }
}

