package class4;

public class main {

	public static void main(String[] args) {
		int[] v = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(iteration(v));
		System.out.println(recursive(v));
		System.out.println(divisionAndConquest(v));
		System.out.println(sumarDivisionConquista(v, 0, v.length-1));
	}
	
	//Dado un array arr de enteros, realizar un algoritmo que por medio de
	//División y Conquista 	sume todos los elementos del mismo.
	//Recursividad 			sume todos los elementos del mismo.
	//Iteración 			sume todos los elementos del mismo.
	    
    public static int divisionAndConquest(int[] v) {
        if(v == null || v.length == 0) {
            return 0;
        }
        
        return childDC(v, 0, v.length-1);
    }
    
    public static int childDC(int[] v, int ini, int fin) {
        int mid = ((fin - ini)/2)+ini;
        
        if(fin == ini) {
            return v[mid];
        }
        else if(fin<ini) {
            return 0;
        }
        return v[mid] + childDC(v, ini, mid-1) + childDC(v, mid+1, fin);
    }
	
	public static int recursive(int[] v) {
		if(v == null || v.length == 0)
			return 0;
		
		return childR(v, 0);
	}
	
	public static int childR(int[] v, int index) {
		if(v.length <= index)
			return 0;
		return v[index] + childR(v, ++index);
	}

	public static int iteration(int[] v) {
		int sum = 0;
		for(int num : v)
			sum+=num;
		
		return sum;
	}
	
	public static int sumarDivisionConquista(int[] arr, int inicio, int fin) {
        // Condición Base: Si hay un elemento, devolver ese elemento
        if (inicio == fin) {
            return arr[inicio];
        }

        // Búsqueda del elemento que se encuentra en el medio del array
        int medio = (inicio + fin) / 2;

        // Retorno la suma de la parte izquierda y derecha del array de forma recursiva
        return sumarDivisionConquista(arr, inicio, medio) + sumarDivisionConquista(arr, medio + 1, fin);
    }
}
