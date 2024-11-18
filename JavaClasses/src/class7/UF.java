package class7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import UtilsGrafos.Nodo;

public class UF {
	Map<Nodo, Nodo> nodos;
	
	public void init(List<Nodo> grafo) {
		nodos = new HashMap<Nodo, Nodo>();
		
		for (Nodo nodo : grafo)
			nodos.put(nodo, nodo);
	}
	
	public boolean find(Nodo a, Nodo b) {
		return get_representante(a) != get_representante(b);
	}
	
	public void union(Nodo a, Nodo b) {
		Nodo ra = get_representante(a);
		Nodo rb = get_representante(b);
		
		if(ra.id > rb.id) 
			nodos.replace(ra, rb);
		else
			nodos.replace(rb,  ra);
	}
	
	private Nodo get_representante(Nodo nodo) {
		Nodo representante = nodos.get(nodo);
		
		if(nodo == representante)
			return representante;
		
		return get_representante(representante);
	}
}
