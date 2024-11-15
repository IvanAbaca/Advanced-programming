package UtilsGrafos;

public class Arista implements Comparable<Arista>{
	public Vertice src;
	public Vertice dst;
	public int w;
	
	public Arista(Vertice src, Vertice dst, int w) {
		super();
		this.src = src;
		this.dst = dst;
		this.w = w;
	}

	@Override
	public int compareTo(Arista o) {
		return this.w - o.w;
	}

}
