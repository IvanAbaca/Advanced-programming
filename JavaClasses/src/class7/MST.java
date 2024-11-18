package class7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import UtilsGrafos.Arista;
import UtilsGrafos.Nodo;
import utils.FileReaderOIA;
import utils.TextProcessor;

public class MST extends TextProcessor<MST>{
	
	List<Nodo> grafo;
	List<Arista> mst;
	public int[][] ady = null;
	
	// Prim
	PriorityQueue<Nodo> cola;
	Map<Nodo, Nodo> predecesor;
	Map<Nodo, Boolean> visitado;
	Map<Nodo, Integer> distancia;
	
	// Kruskal
	List<Arista> edges;
	
	public MST(String option, String file) {
		
		mst = new ArrayList<Arista>();
		grafo = new ArrayList<Nodo>();
		FileReaderOIA<MST> reader = new FileReaderOIA<MST>();
		reader.fileReader(this, "src/class7/", file);
		
		switch(option) {
			// ||---------||		Prim		||---------||
			case("prim"): 
			{
				visitado = new HashMap<Nodo, Boolean>();
				distancia = new HashMap<Nodo, Integer>();
				predecesor = new HashMap<Nodo, Nodo>();
				
				cola = new PriorityQueue<>(new Comparator<Nodo>() {
			        @Override
			        public int compare(Nodo a, Nodo b) {
			            return Integer.compare(distancia.get(a), distancia.get(b));
			        }
			    });
				
				for (Nodo nodo : grafo) {
					visitado.put(nodo, false);
					distancia.put(nodo, Integer.MAX_VALUE);
					predecesor.put(nodo, null);
					
					cola.add(nodo);
					
				}
				break;
			}
			
			// ||---------||		Kruskal		||---------||
			case("kruskal"): 
			{	
				int dist;
				edges = new ArrayList<Arista>();
								
				for (int i = 0; i < ady.length; i++)
					for (int j = i+1; j < ady.length; j++)
						if((dist = ady[i][j]) != 0)
							edges.add(new Arista(grafo.get(i), grafo.get(j), dist));
				
				edges.sort(new Comparator<Arista>() {
			        @Override
			        public int compare(Arista a1, Arista a2) {
			            return Integer.compare(a1.distancia, a2.distancia);
			        }
			    });
				break;
			}
			default: throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	
	public List<Arista> prim(Nodo s) {
		
		distancia.replace(s, 0);
		
		while(!cola.isEmpty()) {
			Nodo v = cola.poll();
			visitado.replace(v, true);
			
			for (Nodo w : grafo) {
				int peso = ady[v.id][w.id];
				if(!visitado.get(w) && distancia.get(w) > peso && peso!=0) {
					distancia.replace(w, peso);
					predecesor.replace(w, v);
					cola.add(cola.poll()); // Reordeno la cola
				}
			}
		}
		
		for (Map.Entry<Nodo, Nodo> arista : predecesor.entrySet()) {
			Nodo nodo = arista.getKey();
			Nodo predecesor = arista.getValue();
			
			mst.add(new Arista(nodo, predecesor, distancia.get(nodo)));
		}
		
		return mst;
	}
	
	public List<Arista> kruskal() {
		
		Nodo v, w;
	    UF uf = new UF();
	    int E = edges.size();

	    uf.init(grafo);
	    
	    for(int i=0, k=0; i<E && k < grafo.size()-1; i++) {
	        v = edges.get(i).v;
	        w = edges.get(i).w;
	        
	        if(uf.find(v, w)) {
	            uf.union(v, w);
	            mst.add(edges.get(i));
	        }
	    }
	    
	    return mst;
	}
	
	@Override
	public void textProcess(String[] line) {
			
		for(int i=0; i<line.length; i++)
			grafo.add(new Nodo());
		
		ady = new int[line.length][line.length];
		
		for(int i=0; i<line.length; i++) {
			String[] row = line[i].split(" ");
			for(int j=0; j<row.length; j++)
				ady[i][j] = Integer.parseInt(row[j]);
		}
	}
}

