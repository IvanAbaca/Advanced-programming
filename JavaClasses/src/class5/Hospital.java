package class5;

public class Hospital {

	public static void main(String[] args) {
		PriorityQueue<Patient> cola = new PriorityQueue<>();

        cola.add(new Patient("Paciente A", Triage.EMERGENCY.getPriority()));
        cola.add(new Patient("Paciente B", Triage.NONURGENT.getPriority()));
        cola.add(new Patient("Paciente C", Triage.RESUSCITATION.getPriority()));

        System.out.println("El paciente con mayor prioridad es: " + cola.peek());

        while (!cola.isEmpty()) {
            System.out.println("Atendiendo a: " + cola.poll());
        }

	}

}
