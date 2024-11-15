package class9;

public class main {

	public static void main(String[] args) {
		
		
		
		int[][] m = 
			{
				{3, 2, 10, 15, 10},
				{6, 19, 7, 11, 17},
				{8, 5, 10, 32, 21},
				{3, 20, 2, 9, 7}
			};
		MinaDeOro l = new MinaDeOro();

		System.out.println(l.bottom_up(m));
		
		//System.out.println(l.bottom_up(13));
	}

}
