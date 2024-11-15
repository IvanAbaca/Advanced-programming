package UtilsGrafos;

public class Grafo {
	public Arista[] aristas;
	public Vertice[] vertices;
	
	public Grafo(Vertice[] vertices, Arista[] aristas) {
		super();
		this.aristas = aristas;
		this.vertices = vertices;
	}
	
	public int c(Vertice src, Vertice dst) {
		for(Arista a : aristas)
			if(a.src.id == src.id && a.dst.id == dst.id)
				return a.w;
		return Integer.MAX_VALUE;
	}

	@Override
	public String toString() {
		
		int length = aristas.length;
		int[][] ma = new int[length][length];
		String cadena = null;
		
		for(Arista a : aristas) {
			ma[a.src.id][a.dst.id] = a.w;
			ma[a.dst.id][a.src.id] = a.w;
		}
		
		for(int i=0; i<length; i++) {			
			for(int j=0; j<length; j++)
				cadena += ma[i][j] + " ";
		cadena += "\n";
		}
		
		return cadena;
	}
	
}
