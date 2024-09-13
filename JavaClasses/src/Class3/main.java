package Class3;

public class main {

	public static void main(String[] args) {
		int min = 8;
		int max = 9;
		int[] list = {1,2,3,4,5,6,7,8,9,10};
		int cont = 0;
		int count2 = 0;

		cont = iterativo(list, min, max);
		count2 = envoltorio(list, min, max);
			
		System.out.println(cont);
		System.out.println(count2);
	}
	
	public static int iterativo(int[] list, int min, int max) {
		int cont = 0; // 1
		for(int i=0; i< list.length; i++) //n
			cont += list[i]>=min && list[i]<=max?1:0; //1
		return cont;//1
	} //Complejidad N
	
	public static int envoltorio(int[] list, int min, int max) {
		return recursivo(list, min, max, 0);
	}
	
	public static int recursivo(int[] list, int min, int max, int indice) {
		int count = list[indice]>=min && list[indice]<=max?1:0; //1

		if(list.length-1 == indice)
			return count; //1
		
		return count + recursivo(list, min, max, indice+1); //N
	} //Complejidad 1
	
	/*
	T(1) 	= 1 	para N = 1
	T(N) 	= TN-1 + k para N > 1
	 */

}
