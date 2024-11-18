package UtilsGrafos;

public class Arista {
	public Nodo v;
	public Nodo w;
	public int distancia;
	
	public Arista(Nodo v, Nodo w, int distancia) {
		this.v = v;
		this.w = w;
		this.distancia = distancia;
	}
}
