package class9;

import java.util.HashMap;
import java.util.Map;

//Top-Down
//1. Agregar un parámetro, variable o atributo con la memoria, que se utilizará a lo largo de las invocaciones
//2. Determinar la key para cada subproblema
//3. Agregar un caso base donde chequeamos si la solución actual no fue anteriormente calculada
//4. Para cada caso recursivo, antes de devolverlo, debemos guardarlo en la memoria

public class LadronDeCasas {
	// Dado un array de enteros casas donde cada posición representa la cantidad de dinero que hay en la casa casasi 
	// Encontrar la máxima cantidad de dinero que un ladrón puede robar, 
	// sabiendo que no puede robar dos casas adyacentes dado que los sistemas de seguridad llamarían inmediatamente a la policía.
	
	
	// Memoria: Map
	// Clave - Valor: Casa - Cantidad Robada
	// Caso base: No haya mas casas por robar

	
	public int top_down(int[] casas) {
		Map<Integer, Integer> mem = new HashMap<Integer, Integer>();

		return Math.max(top_down(0, casas, mem), top_down(1, casas, mem));
	}
	
	public int top_down(int key, int[] casas, Map<Integer, Integer> mem) {
		
		int izq = 0;
		int der = 0;
		
		if (mem.containsKey(key))
			return mem.get(key);
		
		if(key > casas.length-1)
			return 0;
		
		if(key == casas.length-1) {
			mem.put(key, casas[key]);
			return mem.get(key);
		}
		
		if(key+2 == casas.length-1) 
			mem.put(key+2, casas[key+2]);
		
		if(key+3 == casas.length-1) {
			mem.put(key+2, casas[key+2]);
			mem.put(key+3, casas[key+3]);
		}
		
		if (mem.containsKey(key+2))
			izq = mem.get(key+2);
		else
			izq = top_down(key+2,casas, mem);
		
		if (mem.containsKey(key+3))
			der = mem.get(key+3);
		else
			der = top_down(key+3,casas, mem);
		
		mem.put(key, casas[key] + Math.max(izq, der));
		
		return mem.get(key);
	}
}
