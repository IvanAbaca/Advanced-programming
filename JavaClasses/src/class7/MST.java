package class7;

import java.util.Comparator;
import java.util.PriorityQueue;
import UtilsGrafos.Nodo;

public class MST {
	
	PriorityQueue<Nodo> cola;
	boolean[] visitados = new boolean[1];
	
	
	public MST() {
		cola = new PriorityQueue<>(new Comparator<Nodo>() {
	        @Override
	        public int compare(Nodo n1, Nodo n2) {
	            return Integer.compare(n1.id, n2.id);
	        }
	    });
		visitados = new boolean[cola.size()];
	}
	
	public void prim(Nodo s) {
		
	}
	
	public void kruskal() {	

	}
	
}

