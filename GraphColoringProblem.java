import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

  
public class GraphColoringProblem {

	public static void main(String[] args) throws IOException {
	
	System.out.println("Please enter the input name: ( ex : sample1.txt )");
	Scanner scanner = new Scanner(System.in);
	Scanner input = new Scanner(new File(scanner.next()));
	
	input.next(); // skip p word. 
	int number_of_vertices = input.nextInt();
	int number_of_edges = input.nextInt();
	
	int[][] matrix = new int[number_of_vertices][number_of_vertices]; 			//diagonals will be 0
	int[] color_codes = new int[number_of_vertices]; 							// i'th vertex's color code will be put in color_codes[i-1].
	
	while(input.hasNext()) { 									// in this while loop, we fill the matrix with the content of the input file.
		input.next();											// when i'th & j'th vertex are adjacent, m[i-1][j-1] = 1, otherwise 0. 
		
		int firstIndex = input.nextInt() -1;					// In the input.txt, the edges given only 1 type as  e 1 2. But we need to  
		int secondIndex = input.nextInt() -1;					// place 1 when we have an edge between vertices , we need to write e 2 1 .
		matrix[firstIndex][secondIndex] = 1;
		matrix[secondIndex][firstIndex] = 1;
	}
	input.close();

	set_diagonal(matrix,color_codes); 			// we adjust the color codes of vertices and put them into the diagonal which is all zero at first.
	
	System.out.println("Please enter the output name: ( ex : output1.txt )");
    File output_file = new File(scanner.next());				//creating output.txt to store the #of total colors and vertex color codes.
    if (!output_file.exists()) {
        output_file.createNewFile();
    }

    FileWriter fileWriter = new FileWriter(output_file, false);
    BufferedWriter bWriter = new BufferedWriter(fileWriter);
    bWriter.write((find_max(color_codes)+1)+""+"\n");
    
    for(int i = 0;i<color_codes.length;i++) {
    	bWriter.write(color_codes[i]+" ");
    }
    bWriter.close();
    System.out.println("Operation is done");
	}
	
	
	static void set_diagonal(int[][] m,int[] arr) { 			// starting from the top left, we adjust the color codes. 
		for(int i = 0;i<m.length;i++) {							// color code is 0 at first.
			int color_code = 0;									// it is incremented when an adjacency occurs and the color codes are the same.
			for(int j = 0;j<i;j++) {							// we continue until diagonal because for large values of j, informations needed will be given in (j,i).
				if(m[i][j]==1 && color_code == m[j][j]) { 		// no need to check twice
					color_code++;
					j = 0;
				}			
			}
			m[i][i] = color_code; 							// we fill not just the diagonal, but also the color_codes array.
			arr[i] = color_code; 							// arr = diagonal of the matrix.
		}
	}
	
	static int find_max(int[] arr) { 				// it finds the maximum value in the array
		int max = 0;				 				// it is used for determining the number of color codes. total number of color codes = max+1
		int max_index = 0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				max_index = i;
			}
		}
		return max;
	}
	
	static void verify(int[][] m,int[] arr) { 				// this function verifies the adjustments.
		int count = 0;						 				// it controls the adjacency between vertices and if they are, checks if the color codes are the same or not.
		for(int i = 0;i<m.length;i++) {		  				// if an error occurs, it prints the indices of vertices so that you can check from the matrix.
											  				// Count is the number of errors.
			for(int j = 0;j<i;j++) {		  				// At first, our algorithm was giving some numbers even smaller than the optimal solution. 
											  				// We created this function and saw our mistakes, then updated the algorithm.
				if(m[i][j] == 1 && arr[i] == arr[j]) {
					System.out.println(i+" "+j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
