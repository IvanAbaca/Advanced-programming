package class5;

public class Patient implements Comparable<Patient> {
    private String name;
    private int triage; // Minimun heap

    public Patient(String name, int priority) {
        this.name = name;
        this.triage = priority;
    }

    public int getPriority() {
        return triage;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.triage, other.getPriority());
    }

    @Override
    public String toString() {
        return name + " con prioridad " + triage;
    }
}
