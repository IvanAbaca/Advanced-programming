package class5;

public class Patient implements Comparable<Patient> {
    private String name;
    private int priority; // Minimun heap

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority, other.getPriority());
    }

    @Override
    public String toString() {
        return name + " con prioridad " + priority;
    }
}
