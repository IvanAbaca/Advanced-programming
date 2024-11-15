package utils;

import java.util.Arrays;

public class ReaderImplementationExample extends TextProcessor<ReaderImplementationExample>{

	private String 	word;
	private int 	number;
	private int[] 	vector;
	private int[][] matrix;
	
	public static void main(String[] args) {
		FileReaderOIA<ReaderImplementationExample> reader = new FileReaderOIA<ReaderImplementationExample>();
		ReaderImplementationExample example = new ReaderImplementationExample();
		
		reader.fileReader(example, "src/utils/", "example.txt");
		
		System.out.println(example.toString());
	}
	
	@Override
	public void textProcess(String[] line) {
		// TEXTO: Lees de una
		word = line[0];
		
		// NUMERO: Tenes que parsearlo primero
		number = Integer.parseInt(line[1]);
		
		// VECTOR: Tenes que inicializarlo con la cant de elem
		String[] v = line[2].split(" ");
		vector = new int[v.length];
		
		for(int i=0; i<vector.length; i++)
			vector[i] = Integer.parseInt(v[i]);
		
		// MATRIX: Tenes que inicializarla con la cant de filas
		matrix = new int[line.length-3][];
		
		for(int i=3; i<line.length; i++) {
			String[] row = line[i].split(" ");
			matrix[i-3] = new int[row.length];
			
			for(int j=0; j<row.length; j++)
				matrix[i-3][j] = Integer.parseInt(row[j]);
		}
	}

	@Override
	public String toString() {
		String output = "----------------------------------------------"
				+ "\nword = " + word + "\nnumber = " + number + "\nvector = "
				+ Arrays.toString(vector) + "\nmatrix =";
		
		for(int[] v : matrix)
			output += "\n" + Arrays.toString(v);
		output += "\n----------------------------------------------";
		
		
		return output;
	}
	


}
