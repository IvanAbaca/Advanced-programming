package class9;

//Bottom-up
//1. Utilizar el grafo para armar la tabla
//2. Entender qué significa cada elemento de la misma
//3. Comenzar a llenar la tabla con la estrategia de resolución, en forma incremental
//4. Ver cuál de los valores de la tabla debe devolverse como solución del problema general

public class MinaDeOro {

	// Grafo: Matriz 5 x 4
	// Elemento: El maximo de mis 3 elementos superiores mas mi posicion
	// Casos base: La primera fila
	
	public int bottom_up(int[][] mina) {
		
		int nivel_profundidad = mina.length-1;
		int cantidad_minas = mina[0].length-1;
		int izq;
		int der;
		int maxOro;
		int[][] oroAcum = new int[nivel_profundidad+1][cantidad_minas+1];
		
		// Lleno la tabla de forma incremental
		for (int i=0; i < nivel_profundidad+1; i++) {
			for(int j=0; j< cantidad_minas+1; j++) {
				
			izq = j==0 ? 0 : j-1;
			der = j+3 >= cantidad_minas+1 ? cantidad_minas+1 : j+3;
			
			maxOro = 0;
			if(i!=0)
				for (int k = izq; k < der; k++)
					maxOro = Math.max(maxOro, mina[i-1][k]);
			
			oroAcum[i][j] = maxOro + mina [i][j];
			}
		}
		
		maxOro = 0;
		
		// Retorno la solucion
		for(int acum : oroAcum[nivel_profundidad])
			maxOro = Math.max(maxOro, acum);
		
		return maxOro;
	}
}
