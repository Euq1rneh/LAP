import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
/**
 * This class implements a coding and decoding system for Strings
 * @author Henrique Marques fc57153
 *
 */
public class CoderDecoder {
	
	private final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String abcKey;
	private int numKey;
	private int numMSG;
	private int m;
		
	/**
	 * Reads a file containing: a alphabetic key, a numeric key, the number of messages to encode
	 * and the messages themselves and writes the encoded result as well as the arguments necessary for
	 * the decoding of set messages
	 * @param inFile					The input file
	 * @param outFile					The output file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void codify(String inFile, String outFile) throws FileNotFoundException, IOException{
		Scanner reader = new Scanner(new File(inFile));
		PrintWriter writer = new PrintWriter(outFile);
		
		abcKey = reader.nextLine();
		numKey = reader.nextInt();
		reader.nextLine();
		numMSG = reader.nextInt();
		reader.nextLine();

		
		writer.println(abcKey);
		writer.println(numKey);
		writer.println(numMSG);
		// read messages
		if(numMSG > 0 ) {
			for(int i = 0; i< numMSG; i++) {
				writer.println(EncodeMessage(reader.nextLine(), abcKey, numKey));
			}
		}
		writer.close();
		reader.close();
	}
	/**
	 * Reads a file containing: a alphabetic key, a numeric key, the number of messages to decode
	 * and the messages themselves and writes the decoded result as well as the arguments necessary for
	 * the encoding of set messages
	 * @param inFile					The input file
	 * @param outFile					The output file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void decodify(String inFile, String outFile) throws FileNotFoundException, IOException{
		Scanner reader = new Scanner(new File(inFile));
		PrintWriter writer = new PrintWriter(outFile);
		
		// read the alphabetic key
		abcKey = reader.nextLine();
		// read the numeric key
		numKey = reader.nextInt();
		// consume end of line
		reader.nextLine();
		// read number of messages
		numMSG = reader.nextInt();
		// consume end of line
		reader.nextLine();
		
		// write the alphabetic and numeric keys and the number of messages in the correct file
		writer.println(abcKey);
		writer.println(numKey);
		writer.println(numMSG);
		// read messages
		if(numMSG > 0 ) {
			for(int i = 0; i < numMSG; i++) {
				writer.println(DecodeMessage(reader.nextLine()));				
			}
			
		}
		writer.close();
		reader.close();
	}
	/**
	 * Encodes a message according to a set of rules
	 * @param message	The message to encode
	 * @param abcKey	The alphabetic key
	 * @param numKey	The numeric key
	 * @return the encoded message
	 */
	private String EncodeMessage(String message, String abcKey, int numKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;

		m = 1;
		
		if(message != null) {
			letters = message.split("");
			
			for(int letter = 0; letter < letters.length; letter++) {
				if(letters[letter].equals(" ")) {
					finalMessage.append(" ");
				}else if(abcKey.contains(letters[letter])) {
					if(m == abcKey.length()-1) {
						finalMessage.append(abcKey.charAt(abcKey.length()-2));
						finalMessage.append(cod(letters[letter], numKey));
						finalMessage.append(abcKey.charAt(abcKey.length()-1));
						m = 0;
					}else if(m == 0){
						finalMessage.append(abcKey.charAt(abcKey.length()-1));
						finalMessage.append(cod(letters[letter], numKey));
						finalMessage.append(abcKey.charAt(0));
						m++;
					}else {
						finalMessage.append(abcKey.charAt(m-1));
						finalMessage.append(cod(letters[letter], numKey));
						finalMessage.append(abcKey.charAt(m));
						m++;
					}
				}else {
					finalMessage.append(cod(letters[letter], numKey));
				}
			}
		}
		return finalMessage.toString();
	}
	/**
	 * Transforms a letter to a letter N positions further in the alphabet
	 * @param letter	The letter to transform
	 * @param N			The number of positions
	 * @return the transformed letter
	 */
	private String cod(String letter, int N) {
		int i = ABC.indexOf(letter);
		return ABC.charAt((i+N)%26) + "";
	}
	/**
	 * Transforms a letter to a letter N positions further back in the alphabet
	 * @param letter	The letter to transform
	 * @param N			The number of positions
	 * @return the transformed letter
	 */
	private String decod(String letter) {
		String originalLetter;
		int i = ABC.indexOf(letter);
		return originalLetter = i >= numKey ? ABC.charAt(i - numKey) + "" : ABC.charAt(ABC.length()- (numKey - i)) + "";
	}
	/**
	 * Decodes a message according to a certain set of rules 
	 * @param message 	The message to decode
	 * @param abcKey  	The alphabetic key
	 * @param numKey	The numeric key
	 * @return the decoded message
	 */
	private String DecodeMessage(String message) {
		StringBuilder finalMessage = new StringBuilder();
		String[] phrase, letters;
		
		int firstLetter = 0, secondLetter = 2;
		m = 0;
		
		if(message != null) {
			phrase = message.split(" ");
			
			for(int word = 0; word< phrase.length; word++) {
				letters = phrase[word].split("");
				// while it hasnt completed decoding a word
				while(firstLetter < letters.length) {
					// if the first or last letters are in the key > ERROR
					if(abcKey.contains(decod(letters[0])) || abcKey.contains(decod(letters[letters.length-1])))
						return "Error in codification";
						// if there is one last letter (alone)
						if(firstLetter <= letters.length-1 && secondLetter >= letters.length) {
							// if one of the last 2 letters is in the key > ERROR
							if(abcKey.contains(decod(letters[firstLetter])))
								return "ErroR in codification";
							finalMessage.append(decod(letters[firstLetter]));
							firstLetter++;
							secondLetter++;
						}
						// if it is a group of 3 letters
						// also takes m into consideration 
						// so as to not add to many or to few letters
						else if(abcKey.contains(letters[firstLetter])  && abcKey.contains(letters[secondLetter]) 
								&& abcKey.indexOf(letters[firstLetter]) == m && abcKey.indexOf(letters[secondLetter]) == (m+1)%abcKey.length()) {
							
							finalMessage.append(decod(letters[firstLetter+1]));
							firstLetter = secondLetter+1;
							secondLetter = firstLetter + 2;
							m = (m+1)% abcKey.length();
							 
						}
						// is a "lonely" letter in the middle of the word
						else if(!abcKey.contains(decod(letters[firstLetter]))){
							finalMessage.append(decod(letters[firstLetter]));
							firstLetter++;
							secondLetter++;
						}else {
							return "Error in codification";
						}
					
				}
				// add spaces between words and skip the last one
				if(word < phrase.length-1)
					finalMessage.append(" ");
				// reset variables for each word
				firstLetter = 0;
				secondLetter = 2;
			}
			
		}
		return finalMessage.toString();
	}
}
