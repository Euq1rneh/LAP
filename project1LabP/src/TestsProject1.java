import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TestsProject1 {

	public static final String eol = System.getProperty("line.separator");

    @Test
    public void testCodify () throws IOException {

        String esperado = "AINSY" + eol + "4" + eol + "4" + eol +
        		              "JSVIZIV JPACIIMNNRSK SEYFSZI XLI GYMAXACI" + eol +
        		              "OARISAPIHKI IMNNWS TSAIV" + eol +
        		              "JVSQ KVIAEIX TSAIV GSQIIWN KVINESX VISWYTSYRAAWIIMNFNMSPSMYXYCA" + eol +
        		              "FVSXLIVAWI IMNNRS SEYVQYWA AEIVI OIRNSANRS XS SEYPP GSYYRAXVAMIIIWN" + eol;

        String texto = "AINSY" + eol + "4" + eol + "4" + eol + 
        		"FOREVER FLYING ABOVE THE CITY" + eol +
        		"KNOWLEDGE IS POWER" + eol +
        		"FROM GREAT POWER COMES GREAT RESPONSIBILITY" + eol +
        		"BROTHERS IN ARMS ARE KNOWN TO ALL COUNTRIES" + eol;

        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();

     	CoderDecoder agent = new CoderDecoder();
    	
    	agent.codify("input.txt", "output.txt");
    	
        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), 
                StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);

    }
    
    @Test
    public void testDecodify () throws IOException {

        String esperado = "AINSY" + eol + "4" + eol + "4" + eol + 
        		"FOREVER FLYING ABOVE THE CITY" + eol +
        		"KNOWLEDGE IS POWER" + eol +
        		"FROM GREAT POWER COMES GREAT RESPONSIBILITY" + eol +
        		"BROTHERS IN ARMS ARE KNOWN TO ALL COUNTRIES" + eol;

        String texto = "AINSY" + eol + "4" + eol + "4" + eol +
	              "JSVIZIV JPACIIMNNRSK SEYFSZI XLI GYMAXACI" + eol +
	              "OARISAPIHKI IMNNWS TSAIV" + eol +
	              "JVSQ KVIAEIX TSAIV GSQIIWN KVINESX VISWYTSYRAAWIIMNFNMSPSMYXYCA" + eol +
	              "FVSXLIVAWI IMNNRS SEYVQYWA AEIVI OIRNSANRS XS SEYPP GSYYRAXVAMIIIWN" + eol;

        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();

     	CoderDecoder agent = new CoderDecoder();
    	
    	agent.decodify("input.txt", "output.txt");
    	
        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), 
                StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);

    }
}
