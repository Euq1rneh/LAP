import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class allows to test the class CoderDecoder
 * @author LabP
 * February 28th 2022
 */
public class RunProject1 {
	public static final int N_FILES = 4;
	
	/**
	 * An instance of the CoderDecoder class is created and used to codify
	 * and decodify messages written in text files
	 * @param args Not used
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
    public static void main(String [] args) throws FileNotFoundException, IOException {
    	
    	CoderDecoder agent = new CoderDecoder();
    	
    	agent.codify("in1.txt", "out1.txt");
    	agent.codify("in2.txt", "out2.txt");
    	agent.codify("in3.txt", "out3.txt");
    	agent.codify("in4.txt", "out4.txt");
    	
    	agent.decodify("out1.txt", "decoded1.txt");
    	agent.decodify("out2.txt", "decoded2.txt");
    	agent.decodify("out3.txt", "decoded3.txt");
    	agent.decodify("out4.txt", "decoded4.txt");
    	
    	for(int i = 1 ; i <= N_FILES ; i++) {
    		System.out.println("decoded" + i + ".txt equals in" + i + ".txt?");
    		System.out.println(resultAsExpected("decoded" + i + ".txt", "in" + i + ".txt"));
    	}
    	
    	// Casos em que algumas das mensagens a descodificar nao correspondem a
    	// codificação correta de nenhuma mensagem original. 
    	// Nestes casos a frase “Error in codification” deve ser escrita na 
    	// linha correspondente
    	agent.decodify("someBad11.txt", "decoded11.txt");
    	agent.decodify("someBad12.txt", "decoded12.txt");
    	agent.decodify("someBad13.txt", "decoded13.txt");

    }

    /**
     * Compares the contents of two text files, ignoring leading and trailing spaces 
     * @param obtained The first file
     * @param expected The second file
     * @return true if the contents of obtained and expected are the same, ignoring 
     *         leading and trailing spaces
     * @throws FileNotFoundException
     */
	private static boolean resultAsExpected(String obtained, String expected) 
			                                      throws FileNotFoundException {
        Scanner reader1 = new Scanner(new File(obtained));
        Scanner reader2 = new Scanner(new File(expected));
        boolean theSame = true;

        while(reader1.hasNextLine() && reader2.hasNextLine() && theSame) {
        	String line1 = reader1.nextLine().trim();
        	String line2 = reader2.nextLine().trim();
        	if(!line1.equals(line2)) {
        		theSame = false;
        	}
        }
		
		return theSame && reader1.hasNextLine() == reader2.hasNextLine();
	}

}
