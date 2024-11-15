package class8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import UtilsGrafos.Nodo;
import utils.FileReaderOIA;
import utils.TextProcessor;

public class RecorridoDeGrafo extends TextProcessor<RecorridoDeGrafo> {

	public List<Nodo> grafo;
	public List<List<Integer>> ady;
	
	public RecorridoDeGrafo(String file) {
		FileReaderOIA<RecorridoDeGrafo> reader = new FileReaderOIA<RecorridoDeGrafo>();
		reader.fileReader(this, "src/class8/", file);
	}

	public void dfs(Nodo s) {
	    Stack<Nodo> pila = new Stack<>();
	    boolean[] visitados = new boolean[grafo.size()];

	    pila.push(s);
	    visitados[s.id] = true;
	    
	    while(!pila.isEmpty()) {
	    	
	    	Nodo nodo = pila.pop();
		    
		    ady.get(nodo.id).forEach(adyacente -> {
		        if (!visitados[adyacente]) {
		            pila.push(grafo.get(adyacente));
		            visitados[adyacente] = true;
		        }
		    });
		    
	    }
	}

	public int[] bfs(Nodo s) {
		Queue<Nodo> cola = new LinkedList<>();
	    int[] distancias = new int[grafo.size()];
	    
	    for (int i = 0; i < distancias.length; i++)
			distancias[i] = Integer.MAX_VALUE;

	    cola.add(s);
	    distancias[s.id] = 0;

	    while(!cola.isEmpty()) {
	    	
	    	Nodo nodo = cola.poll();
		    
		    ady.get(nodo.id).forEach(adyacente -> {
		    	
		        if (distancias[adyacente] == Integer.MAX_VALUE) {
		        	cola.add(grafo.get(adyacente));
		        	distancias[adyacente] = distancias[nodo.id] + 1;
		        }
		    });
	    	
	    }
	    
	    return distancias;
	}

	@Override
	public void textProcess(String[] line) {
		
		grafo = new ArrayList<Nodo>();
		for (int i = 0; i < line.length; i++)
			grafo.add(new Nodo());
		
		ady = new ArrayList<List<Integer>>();
		for (int i = 0; i < line.length; i++) {
			String[] vec = line[i].split(" ");
			ady.add(new ArrayList<Integer>());
			
			for (int j = 0; j < vec.length; j++)
				ady.get(i).add(Integer.parseInt(vec[j]));
		}
	}
}
