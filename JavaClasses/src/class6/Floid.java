package class6;

import java.util.ArrayList;
import java.util.List;

import UtilsGrafos.Nodo;
import utils.FileReaderOIA;
import utils.TextProcessor;

public class Floid extends TextProcessor<Floid> {
	
	// Input
	public List<Nodo> grafo;
	public int[][] ady;
	
	// Output
	public int[][] z;

	public Floid() {
		FileReaderOIA<Floid> reader = new FileReaderOIA<Floid>();
		reader.fileReader(this, "src/class6/", "floid.txt");
	}
	
	public void get_new_graph() {
		for (int k = 0; k < ady.length; k++)
			for (int i = 0; i < ady.length; i++)
				for (int j = 0; j < ady.length; j++)
					if( (i != k && j != k) && (i != j) && (ady[i][k] != Integer.MAX_VALUE && ady[k][j] != Integer.MAX_VALUE) ) {
						ady[i][j] = Math.min(ady[i][j], ady[i][k] + ady[k][j]);
						z[i][j] = k;
					}
	}
	
		@Override
	public void textProcess(String[] line) {
		grafo = new ArrayList<Nodo>();
		int cant_nodos = Integer.parseInt(line[0]);

		for (int i = 0; i < cant_nodos; i++)
			grafo.add(new Nodo());

		ady = new int[grafo.size()][grafo.size()];
		z = new int[grafo.size()][grafo.size()];
		
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z.length; j++) {
				z[i][j] = i;
			}
		}
		
		for (int i = 0; i < ady.length; i++) {
			for (int j = 0; j < ady.length; j++) {
				ady[i][j] = i==j?0:Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i < line.length; i++) {
			String[] v = line[i].split(" ");

			int origen = Integer.parseInt(v[0]);
			int destino = Integer.parseInt(v[1]);
			int distancia = Integer.parseInt(v[2]);

			ady[origen][destino] = distancia;
		}
	}
}
