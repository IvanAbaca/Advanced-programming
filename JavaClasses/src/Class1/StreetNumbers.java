package Class1;

public class StreetNumbers {
	
	public static void main(String[] args) {
		
		StreetNumbers sn = new StreetNumbers();
		int test = 49;
		
		System.out.println(sn.cuadratica(test));
		System.out.println(sn.lineal(test));
		System.out.println(sn.constante(test));
		
		
	}
	
	int cuadratica(int n) {
		int izq;
		int der;
		
		for(int i=1; i<n; i++) {
			izq = 0;
			der = 0;
			
			for(int j=0;j<i;j++)
				izq+=j;
			for(int k=i+1;k<=n;k++)
				der+=k;

			if(izq==der)
				return i;
			if(izq>der)
				return -1;
		}
		return -1;
	}
	
	int lineal(int n) {
		int izq;
		int der;
		
		for(int i=1; i<n; i++) {
			der = 0;
			izq = (i*i-i)/2;
			
			for(int k=i+1;k<=n;k++)
				der+=k;

			if(izq==der)
				return i;
			if(izq>der)
				return -1;
		}
		return -1;
	}
	
	int constante(int n) {
		if(n<2)
			return -1;
		
		double r = Math.sqrt((n*n+n)/2);
		return r!=(int)r?-1:(int)r;
	}
}