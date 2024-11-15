package class8;

public class main {
	public static void main(String[] args) {
		
		String option = "recorrido";
		
		switch (option) {
			// ||---------||	COLOREO DE GRAFOS		||---------||
			case "coloreo": {
				int[] colores;
				ColoreoDeGrafo c = new ColoreoDeGrafo("coloreo.txt");
				colores = c.matula();
				
				for (int i = 0; i < colores.length; i++) 
					System.out.println("Nodo(" + c.grafo.get(i).nombre + ") = " + colores[i]);
				break;
			}
			
			// ||---------||	RECORRIDO DE GRAFOS		||---------||
			case "recorrido": {
				int[] distancias;
				RecorridoDeGrafo r = new RecorridoDeGrafo("recorrido.txt");
				distancias = r.bfs(r.grafo.get(0));
				
				for (int i = 0; i < distancias.length; i++) 
					System.out.println("Nodo(" + r.grafo.get(i).nombre + ") = " + (distancias[i] == Integer.MAX_VALUE ? "∞" : distancias[i]));
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
}
