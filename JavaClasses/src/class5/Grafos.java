package class5;

public class Grafos {
	public static void main(String[] args) {
		
		
		//Input
		int[][] matriz_de_adyacencias = { //Relaciones
				{0,7,3,0},
				{0,0,0,2},
				{0,2,0,8},
				{0,0,0,0}};
		int[] lista_de_nodos = {0,1,2,3,4}; //Valores de los nodos
		int nodo_inicial = 0; //Posición
		
		//Output
		int[] vector_de_costos_minimos;
		int[] vector_de_predecesores;
		
		
		//Main
		
		mostrar(matriz_de_adyacencias);
				
				
	
	}
	
	
	
	public static void dijkstra() {
		
	}
	
	public static void mostrar(int[][] m) {
		for(int[]v : m)
			for(int i = 0; i<v.length; i++) {
				System.out.print(v[i] + "\t");
				if(i == v.length-1)
					System.out.println("\n");
			}
	}

	
}
