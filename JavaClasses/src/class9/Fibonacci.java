package class9;

import java.util.HashMap;
import java.util.Map;

//Top-Down
// 1. Agregar un parámetro, variable o atributo con la memoria, que se utilizará a lo largo de las invocaciones
// 2. Determinar la key para cada subproblema
// 3. Agregar un caso base donde chequeamos si la solución actual no fue anteriormente calculada
// 4. Para cada caso recursivo, antes de devolverlo, debemos guardarlo en la memoria

//Bottom-up
// 1. Utilizar el grafo para armar la tabla
// 2. Entender qué significa cada elemento de la misma
// 3. Comenzar a llenar la tabla con la estrategia de resolución, en forma incremental
// 4. Ver cuál de los valores de la tabla debe devolverse como solución del problema general

public class Fibonacci {

	// Memoria: Map
	// Clave - Valor: Numero de Fibonacci - Resultado
	// Caso base: Llegué al minimo Fibonacci

	public int top_down(int n) {
		return top_down(n, new HashMap<Integer, Integer>());
	}

	private int top_down(int n, Map<Integer, Integer> mem) {
		int key = n;
		
		// Buscas en el map
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		
		// Si es uno de tus casos base
		if (n < 2) {
			mem.put(key, n);
			
		// Seguir la recursividad con el siguiente
		} else {
			mem.put(key, top_down(n - 1, mem) + top_down(n - 2, mem));
		}
		
		return mem.get(key);
	}

	
	// Grafo: Matriz 1 x N
	// Elemento: Resultado del Fibonacci de esa posicion
	// Casos base: fibo[0]=1 y fibo[1]=1
	
	public int bottom_up(int n) {
		int[] fibo = new int[n + 1];

		fibo[0] = 1;
		fibo[1] = 1;
		
		// Lleno la tabla de forma incremental
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		// Retorno la solución
		return fibo[n];
	}

}
