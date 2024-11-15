package class8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import UtilsGrafos.Nodo;
import utils.FileReaderOIA;
import utils.TextProcessor;

public class ColoreoDeGrafo extends TextProcessor<ColoreoDeGrafo> {

	public List<Nodo> grafo;
	public List<List<Integer>> ady;

	public ColoreoDeGrafo(String file) {
		FileReaderOIA<ColoreoDeGrafo> reader = new FileReaderOIA<ColoreoDeGrafo>();
		reader.fileReader(this, "src/class8/", file);
	}
	
	public int[] secuencial() {
	    int[] colores = new int[grafo.size()];
	    Set<Integer> coloresAdyacentes = new HashSet<Integer>();

	    // Revisar que colores tienen los nodos adyacentes al nodo que estoy revisando
	    for (Nodo nodo : grafo) {
	    	
	        for (int adyacente : ady.get(nodo.id)) 
	            if (colores[adyacente] != 0) 
	                coloresAdyacentes.add(colores[adyacente]);
	   
	        int i = 1; // Primer color
	        while (coloresAdyacentes.contains(i)) // Ya existe este color en los adyacentes?
	            i++; // Paso al siguiente color
	        
	        colores[nodo.id] = i; 		// Asigna el color
	        coloresAdyacentes.clear(); 	// Limpias el vector
	    }

	    return colores;
	}

	public int[] welshPowell() {
	    
	    grafo.sort((n1, n2) -> Integer.compare(ady.get(n2.id).size(), ady.get(n1.id).size()));

	    int[] colores = secuencial();
	    
	    grafo.sort((n1, n2) -> Integer.compare(n1.id, n2.id)); //
	    
	    return colores;
	}

	public int[] matula() {
	    
		Collections.shuffle(grafo); // Reordena el grafo para analizar mejores posibilidades
		
	    grafo.sort((n1, n2) -> Integer.compare(ady.get(n1.id).size(), ady.get(n2.id).size()));

	    int[] colores = secuencial();
	    
	    grafo.sort((n1, n2) -> Integer.compare(n1.id, n2.id));
	    
	    return colores;

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
