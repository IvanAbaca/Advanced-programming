package class5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import UtilsGrafos.Nodo;
import utils.FileReaderOIA;
import utils.TextProcessor;

public class Dijkstra extends TextProcessor<Dijkstra> {

	// Input
	public List<Nodo> grafo = null;
	public int[][] adj = null;

	// Output
	Map<Nodo, Integer> distancia = new HashMap<Nodo, Integer>();
	Map<Nodo, Nodo> predecesor = new HashMap<Nodo, Nodo>();

	public Dijkstra() {
		FileReaderOIA<Dijkstra> reader = new FileReaderOIA<Dijkstra>();
		reader.fileReader(this, "src/class5/", "dijkstra.txt");
	}

	public void dijkstra(Nodo s, int[][] adyacencia, List<Nodo> grafo) {

		Map<Nodo, Boolean> visitado = new HashMap<Nodo, Boolean>();
		PriorityQueue<Nodo> cola = new PriorityQueue<>(new Comparator<Nodo>() {
			@Override
			public int compare(Nodo a, Nodo b) {
				return Integer.compare(distancia.get(a), distancia.get(b));
			}
		});

		for (Nodo u : grafo) {
			distancia.put(u, Integer.MAX_VALUE);
			predecesor.put(u, null);
			visitado.put(u, false);
		}

		distancia.put(s, 0);
		cola.add(s);

		while (!cola.isEmpty()) {

			Nodo u = cola.poll();
			visitado.put(u, true);

			for (int i = 0; i < adyacencia[u.id].length; i++) {
				if (adyacencia[u.id][i] == 0 || visitado.get(grafo.get(i)))
					continue;

				Nodo v = grafo.get(i);

				int distancia_directa = distancia.get(v);
				int distancia_acumulada = distancia.get(u) + adyacencia[u.id][v.id];

				if (!visitado.get(v) && distancia_directa > distancia_acumulada) {
					distancia.put(v, distancia_acumulada);
					predecesor.put(v, u);
					cola.add(v);
				}
			}
		}

		return; // vector de coste minimo, el vector de predecesores o ambos
	}

	@Override
	public void textProcess(String[] line) {

		grafo = new ArrayList<Nodo>();
		int cant_nodos = Integer.parseInt(line[0]);

		for (int i = 0; i < cant_nodos; i++)
			grafo.add(new Nodo());

		adj = new int[grafo.size()][grafo.size()];

		for (int i = 1; i < line.length; i++) {
			String[] v = line[i].split(" ");

			int origen = Integer.parseInt(v[0]);
			int destino = Integer.parseInt(v[1]);
			int distancia = Integer.parseInt(v[2]);

			adj[origen][destino] = distancia;
		}
	}
}
