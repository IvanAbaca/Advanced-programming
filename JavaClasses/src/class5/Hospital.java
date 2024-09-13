package class5;

public class Hospital {

	public static void main(String[] args) {
		PriorityQueue<Patient> cola = new PriorityQueue<>();

        cola.add(new Patient("Paciente A", 2));
        cola.add(new Patient("Paciente B", 5));
        cola.add(new Patient("Paciente C", 1));

        System.out.println("El paciente con mayor prioridad es: " + cola.peek());

        while (!cola.isEmpty()) {
            System.out.println("Atendiendo a: " + cola.poll());
        }

	}

}
