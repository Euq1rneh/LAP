
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExercicioExcecoes {

	/**
	 * Ler vetor de inteiros e uma potencia e imprimir os valores das potencias dos
	 * inteiros
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(args[0]));
		int tamanho = lerTamanhoVetor(sc);
		int[] inteiros = lerInteirosVetor(sc, tamanho);
		double potencia = lerValorPotencia(sc);
		double[] calculados = calculaPotencias(inteiros, potencia);
		imprimirVetor(calculados);
	}

	/**
	 * Ler e devolver o tamanho do vetor original
	 * 
	 * @param sc - o scanner usado para a leitura
	 * @return o tamanho do vetor a ler
	 * @requires sc != null
	 */
	public static int lerTamanhoVetor(Scanner sc) {
		return Integer.parseInt(sc.nextLine());
	}

	/**
	 * Ler um dado numero de inteiros e guardar num vetor
	 * 
	 * @param sc      - o scanner usado para a leitura
	 * @param tamanho - o numero de valores a ler
	 * @return o vetor de inteiros obtidos da leitura
	 * @requires sc != null && tamanho > 0
	 */
	public static int[] lerInteirosVetor(Scanner sc, int tamanho) {

		return null;
	}

	/**
	 * Ler um valor que representa a potencia
	 * 
	 * @param sc - o scanner usado para a leitura
	 * @return o valor obtido da leitura
	 * @requires sc != null
	 */
	public static double lerValorPotencia(Scanner sc) {
		return Double.parseDouble(sc.nextLine());
	}

	/**
	 * Determina as potencias de um vector
	 * 
	 * @param inteiros - o vetor original
	 * @param potencia - a potencia que se pretende calcular do vetor de inteiros
	 * @return o vetor com as potencias de inteiros
	 * @requires inteiros != null && potencia >= 0
	 */
	private static double[] calculaPotencias(int[] inteiros, double potencia) {
		return null;
	}

	/**
	 * Imprime os valores de um vetor de doubles
	 * 
	 * @param v - o vetor do qual se quer imprimir os valores
	 */
	private static void imprimirVetor(double[] v) {
		for (double d : v) {
			System.out.println(d);
		}
	}

}
