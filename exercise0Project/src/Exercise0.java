import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise0 {

	public static void copyText(String fileIn, String fileOut)throws FileNotFoundException{
		String line;
		Scanner reader = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		
		while(reader.hasNextLine()){
			line = reader.nextLine();
			writer.println(line);
		}
		
		writer.close();
		reader.close();
	}
	
	public static void writeSquares(String fileIn, String fileOut) throws FileNotFoundException{
		Scanner reader = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		int i;
		
		while(reader.hasNextInt()) {
			i = reader.nextInt();
			writer.println(i*i);
		}
		writer.close();
		reader.close();
	}
	
	public static void writeMultiples(String fileIn, String fileOut, int n)throws FileNotFoundException{
		Scanner reader = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		int i;
		
		while(reader.hasNextInt()) {
			i = reader.nextInt();
			if(i%n == 0)
				writer.println(i);
		}
		writer.close();
		reader.close();
	}
	
	public static void lowerUpper(String fileIn, String fileOut)throws FileNotFoundException{
		Scanner reader = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		int counter = 1;
		String line;
		
		while(reader.hasNextLine()) {
			line = reader.nextLine();
			if(counter%2 != 0)
				writer.println(line.toLowerCase());
			else
				writer.println(line.toUpperCase());
			counter++;
		}
		writer.close();
		reader.close();
	}
	
	public static void commonElements(String fileIn, String fileOut, int[] values)throws FileNotFoundException{
		Scanner reader = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		int i;
		
		while(reader.hasNextInt()) {
			i = reader.nextInt();
			for(int j = 0; j<values.length; j++) {
				if(i == values[j])
					writer.println(i);
			}
		}
		writer.close();
		reader.close();
	}
}
