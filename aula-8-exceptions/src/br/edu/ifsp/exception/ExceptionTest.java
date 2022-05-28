package br.edu.ifsp.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ExceptionTest {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> lugares = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		int numero = 0;
		while (true) {

			try {
				System.out.println("Escolha o indice que voce quer o lugar:");
				numero = Integer.parseInt(br.readLine());
				System.out.println(lugares.get(numero));
			} catch (IOException ioe) {
				System.out.println("Ocorreu um erro ao ler o input");
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("Indice fora do limite de: " + (lugares.size() - 1));
			}catch (NumberFormatException nex) {
				System.out.println("Isso nao e um numero inteiro: ");
			}
		}
	}
}
