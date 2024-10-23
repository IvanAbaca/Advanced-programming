package class8;

public class ProgramacionDinamica {
	public static void main(String[] args) {
		ProgramacionDinamica pd = new ProgramacionDinamica();
		int n = pd.fibo(15);
		System.out.println(n);
	}
	
	public int fibo(int n) {
		int[] memoria = new int[n+1];
		return fibo(n, memoria);
	}
	
	public int fibo(int n, int[] memoria) {
		if(n<2)
			return n;
		
		if(memoria[n] != 0)
			return n;
		
		if(memoria[n-1] == 0)
			memoria[n-1] = fibo(n-1, memoria);			
		
		if(memoria[n-2] == 0)
			memoria[n-2] = fibo(n-2, memoria);			
		
		return memoria[n-1] + memoria[n-2];
	}
}
