package UtilsGrafos;

public class Vertice implements Comparable<Vertice> {
	public int id;
	public String nombre;
	public int key;
	public Vertice pred;
	public int order;
	
	public Vertice(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Vertice(int id, String nombre, int key, Vertice pred) {
		this.id = id;
		this.nombre = nombre;
		this.key = key;
		this.pred = pred;
	}

	@Override
	public int compareTo(Vertice o) {
		if(this.key - o.key != 0)
			return this.key - o.key;
		return this.order - this.order;
	}
}
