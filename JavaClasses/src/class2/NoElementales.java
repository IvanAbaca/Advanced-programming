package class2;

import java.util.Arrays;

public class NoElementales {
	
	public static void main(String[] args) {
		int[] v = {8,2,6,4,1,3,7,9};
		
		v = mergesort(v);
		
		for(int e : v)
			System.out.print(e + " ");
	}
	
	public static int[] mergesort(int[] v) {
	    
	    if(v.length < 2)
	        return v;
	        
	    int mitad = v.length/2;
	    
	    int[] izq = Arrays.copyOfRange(v, 0, mitad);
	    int[] der = Arrays.copyOfRange(v, mitad, v.length);
	    
	    izq = mergesort(izq);
	    der = mergesort(der);
	    
	    return mezcla(izq, der);
	}
	
	public static int[] mezcla(int[] izq, int[] der){
	    
	    int[] mezclado = new int[izq.length + der.length];
	    int[] ordenado = new int[izq.length + der.length];

	    // Invertir
	    int i = 0;
	    for(int x : izq)
	        mezclado[i++] = x;
	    
	    int d = mezclado.length-1;
	    for(int x : der)
	        mezclado[d--] = x;
	    
	    i = 0;
	    d = mezclado.length-1;
	    
	    // Ordenar
	    for(int j=0; j<ordenado.length; j++) {
	        int min = mezclado[i] < mezclado[d] ? mezclado[i++] : mezclado[d--];
	        ordenado[j] = min;
	    }
	    
	    return ordenado;
	}
}
