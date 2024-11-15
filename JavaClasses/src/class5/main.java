package class5;

public class main {
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.dijkstra(d.grafo.get(0), d.adj, d.grafo);
		
	    d.predecesor.forEach((nodo, predecesor) -> 
	    	System.out.println(	"[Nodo] : " + nodo.nombre + 
	    						" [Predecesor] : " + (predecesor==null?"None":predecesor.nombre)));
	    
	    System.out.println();
	    
	    d.distancia.forEach((nodo, distancia) -> 
	    	System.out.println(	"[Nodo] : " + nodo.nombre + 
	    						" [Distancia] : " + distancia));
	}
}
