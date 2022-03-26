import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Testing {
	private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		CoderDecoder test = new CoderDecoder();
		try {
			test.decodify("in12.txt", "out1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void codify(String inFile, String outFile) throws FileNotFoundException, IOException{
		Scanner reader = new Scanner(new File(inFile));
		PrintWriter writer = new PrintWriter(outFile);
		
		String abcKey = reader.nextLine();
		String[] messages;
		int numKey = reader.nextInt();
		reader.nextLine();
		int numMSG = reader.nextInt();
		reader.nextLine();
		// TODO verificar as possiveis excessoes na leitura do ficheiro
		
		/*if(reader.hasNextLine()) {
			abcKey = reader.nextLine();
			numKey = reader.nextInt();
			// consume end separator
			reader.nextLine();
			numMSG = reader.nextInt();
			// consume end separator
			reader.nextLine();
		}*/
		
		writer.println(abcKey);
		writer.println(numKey);
		writer.println(numMSG);
		// read messages
		if(numMSG > 0 ) {
			while(reader.hasNextLine()) {
				//writer.println(EncodeMessage(reader.nextLine(), abcKey, numKey));
				//temp test
				System.out.println(Encode(reader.nextLine(), abcKey, numKey));
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
		
		String abcKey = reader.nextLine();
		String[] messages;
		int numKey = reader.nextInt();
		reader.nextLine();
		int numMSG = reader.nextInt();
		reader.nextLine();
		// TODO verificar as possiveis excessoes na leitura do ficheiro
		
		/*if(reader.hasNextLine()) {
			abcKey = reader.nextLine();
			numKey = reader.nextInt();
			// consume end separator
			reader.nextLine();
			numMSG = reader.nextInt();
			// consume end separator
			reader.nextLine();
		}*/
		writer.println(abcKey);
		writer.println(numKey);
		writer.println(numMSG);
		// read messages
		if(numMSG > 0 ) {
			while(reader.hasNextLine()) {
				//writer.println(DecodeMessage(reader.nextLine(), abcKey, numKey));
				//temp test
				System.out.println(Decode(reader.nextLine(), abcKey, numKey));
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
		String[] phrase;
		String[] keyLetters;
		int m = 1;
		
		boolean found = false;
		
		if(message != null) {
			// initialize parameters
			phrase = message.split(" ");
			keyLetters = abcKey.split("");
			// go through the words
			for (int word = 0; word< phrase.length; word++) {
				String[] letters = phrase[word].split("");
				// go through each letter
				for(int letter = 0; letter < letters.length; letter++) {
					for(int keyLetter = 0; keyLetter < abcKey.length(); keyLetter++) {
						// found a match in the alphabetic key
						//TODO abstrair
						if(letters[letter].equals(keyLetters[keyLetter])) {
							if(m == abcKey.length()-1) {
								finalMessage.append(abcKey.charAt(abcKey.length()-2));
								finalMessage.append(cod(letters[letter], numKey));
								finalMessage.append(abcKey.charAt(abcKey.length()-1));
								found = true;
								m = 0;
							}else if(m == 0){
								finalMessage.append(abcKey.charAt(abcKey.length()-1));
								finalMessage.append(cod(letters[letter], numKey));
								finalMessage.append(abcKey.charAt(0));
								found = true;
								m++;
							}else {
								finalMessage.append(abcKey.charAt(m-1));
								finalMessage.append(cod(letters[letter], numKey));
								finalMessage.append(abcKey.charAt(m));
								found = true;
								m++;
							}
						}
					}
					// has not found a match in the alphabetic key
					if(!found) {
						finalMessage.append(cod(letters[letter], numKey));
					}
					found = false;
				}
				// add space between words except last word
				if(word < phrase.length-1)
					finalMessage.append(" ");
			}
		}
		return finalMessage.toString();
	}
	
	private String Encode(String message, String abcKey, int numKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;
		String[] keyLetters = abcKey.split("");
		int m = 1;
		
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
	private String dec(String letter, int N) {
		String originalLetter;
		int i = ABC.indexOf(letter);
		return originalLetter = i >= N ? ABC.charAt(i - N) + "" : ABC.charAt(ABC.length()- (N - i)) + "";
	}
	
	private String decV2(String letter, int N) {
		String originalLetter;
		int i = ABC.indexOf(letter);
		return originalLetter = i >= N ? ABC.charAt(i - N) + "" : ABC.charAt(ABC.length()- (N - i)) + "";
	}
	/**
	 * Decodes a message according to a certain set of rules 
	 * @param message 	The message to decode
	 * @param abcKey  	The alphabetic key
	 * @param numKey	The numeric key
	 * @return the decoded message
	 */
	private String Decode(String message, String abcKey, int numKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;
		
		int firstLetter = 0;
		int secondLetter = 2;
		int m = 1;
		
		
		if(message != null) {
			letters = message.split("");
			for(int i = 0; i < letters.length; i++) {
				
				if(letters[i].equals(" ")) {
					finalMessage.append(" ");
				}
				// if the ABC key doesnt contain the letter
				else if(!abcKey.contains(dec(letters[i], numKey))) {
					finalMessage.append(dec(letters[i], numKey));
				}
				// ABC key contain first letter but not second
				else if(abcKey.contains(dec(letters[i], numKey)) && abcKey.indexOf(dec(letters[i], numKey)) == m-1 
						&& !abcKey.contains(dec(letters[i+2], numKey)) 
						&& !letters[i+2].equals(" ") && i< letters.length-2){
						return "Error in codification";
				// ABC key contains m-1 letter and m letter
				}else if(abcKey.contains(dec(letters[i], numKey)) && abcKey.indexOf(dec(letters[i], numKey)) == m-1
					  && abcKey.contains(dec(letters[i+2], numKey)) && abcKey.indexOf(dec(letters[i], numKey)) == m) {
					
					finalMessage.append(dec(letters[i+1], numKey));
				}
			}
			
		}
		return finalMessage.toString();
	}

	private String DecodeV3(String message, String abcKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;
		
		int m = 1;
		
		
		if(message != null) {
			letters = message.split("");
			for(int i = 0; i < letters.length; i++) {
				
				if(letters[i].equals(" ")) {
					finalMessage.append(" ");
				}
				// if the ABC key doesnt contain the letter
				else if(!abcKey.contains(letters[i])) {
					finalMessage.append(decod(letters[i]));
				}
				// ABC key contain first letter but not second
				else if(i < letters.length-2 && abcKey.contains(letters[i]) && abcKey.indexOf(letters[i]) == m-1 
						&& !abcKey.contains(letters[i+2]) 
						&& !letters[i+2].equals(" ")){
						return "Error in codification";
				// ABC key contains m-1 letter and m letter
				}else if(i < letters.length-2 && abcKey.contains(letters[i]) && abcKey.contains(letters[i+2])
						&& abcKey.indexOf(letters[i]) == m-1){
					finalMessage.append(decod(letters[i+1]));
					m = (m+1)%abcKey.length();
					i+=2;
				}else {					
					finalMessage.append(decod(letters[i]));
				}
			}
			
		}
		return finalMessage.toString();
	}
	
	private String DecodeV2(String message, String abcKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;
		
		int m = 0, firstLetter = 0, secondLetter = 2;
		
		
		if(message != null) {
			letters = message.split("");
			for(int i = 0; i < letters.length; i++) {
				firstLetter = i;
				secondLetter = i+2;
				
				if(letters[i].equals(" ")){
					finalMessage.append(" ");
					// contains m and m+1 letter
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && abcKey.contains(letters[secondLetter])
				&& abcKey.indexOf(letters[firstLetter]) == m && abcKey.indexOf(letters[secondLetter]) == m+1) {
					
					m = (m+1) % abcKey.length();
					i+=2;
					finalMessage.append(decod(letters[firstLetter+1]));
					// only contains m letter
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && !abcKey.contains(letters[secondLetter])
						&& abcKey.indexOf(letters[firstLetter]) == m) {
					return "Error in codification";
					// only contains m+1 letter
				}else if(!abcKey.contains(letters[firstLetter]) && i<letters.length-2 && abcKey.contains(letters[secondLetter])
				&& abcKey.indexOf(letters[secondLetter]) == m+1) {
					return "Error in codification";
					// contains letter but is not surrounded but correct letters
				}else if(i >= letters.length-2 && i<letters.length && abcKey.contains(decod(letters[i])) 
						&& (!abcKey.contains(decod(letters[i-1])) || !abcKey.contains(decod(letters[i+1])))
						&& (abcKey.indexOf(decod(letters[i-1])) == m || abcKey.indexOf(decod(letters[i+1])) == m+1)) {
					return "Error in codification";
					// does not contain letter
				}else if(!abcKey.contains(letters[i])) {
					finalMessage.append(decod(letters[i]));
					// contains m and m+1 letter but not at the correct time
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && !abcKey.contains(letters[secondLetter])
						&& abcKey.indexOf(letters[firstLetter]) != m) {
					finalMessage.append(decod(letters[i]));
				}
				
			}
		}
		return finalMessage.toString();
	}
		
	
	private String DecodeV4(String message, String abcKey) {
		StringBuilder finalMessage = new StringBuilder();
		String[] letters;
		
		int m = 0, firstLetter = 0, secondLetter = 2;
		
		
		if(message != null) {
			letters = message.split("");
			for(int i = 0; i < letters.length; i++) {
				firstLetter = i;
				secondLetter = i+2;
				
				if(letters[i].equals(" ")){
					finalMessage.append(" ");
					// contains m and m+1 letter
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && abcKey.contains(letters[secondLetter])
				&& abcKey.indexOf(letters[firstLetter]) == m && abcKey.indexOf(letters[secondLetter]) == m+1) {
					
					m = (m+1) % abcKey.length();
					i+=2;
					finalMessage.append(decod(letters[firstLetter+1]));
					// only contains m letter
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && !abcKey.contains(letters[secondLetter])
						&& abcKey.indexOf(letters[firstLetter]) == m) {
					return "Error in codification";
					// only contains m+1 letter
				}else if(!abcKey.contains(letters[firstLetter]) && i<letters.length-2 && abcKey.contains(letters[secondLetter])
				&& abcKey.indexOf(letters[secondLetter]) == m+1) {
					return "Error in codification";
					// contains letter but is not surrounded but correct letters
				}else if(i >= letters.length-2 && i<letters.length && abcKey.contains(decod(letters[i])) 
						&& (!abcKey.contains(decod(letters[i-1])) || !abcKey.contains(decod(letters[i+1])))
						&& (abcKey.indexOf(decod(letters[i-1])) == m || abcKey.indexOf(decod(letters[i+1])) == m+1)) {
					return "Error in codification";
					// does not contain letter
				}else if(!abcKey.contains(letters[i])) {
					finalMessage.append(decod(letters[i]));
					// contains m and m+1 letter but not at the correct time
				}else if(abcKey.contains(letters[firstLetter]) && i<letters.length-2 && !abcKey.contains(letters[secondLetter])
						&& abcKey.indexOf(letters[firstLetter]) != m) {
					finalMessage.append(decod(letters[i]));
				}
				
			}
		}
		return finalMessage.toString();
	}
}
