package br.edu.ifsp.aula7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exemplos {

	public static void main(String[] args) {
		//exemplo forEachOrdered()
		Arrays.asList(1, 2, 3).parallelStream()
		.forEach(System.out::println); // Não garante a ordem
		
		System.out.println("--------");

		Arrays.asList(1, 2, 3).parallelStream()
		.forEachOrdered(System.out::println); // [1,2,3]
		
		System.out.println("--------");
		
		//exemplo findFirst()
		Pessoa pessoa2 = new Pessoa("Alanna", "12345678901");
		Pessoa pessoa3 = new Pessoa("Leticia", "12345678901");
		Pessoa pessoa1 = new Pessoa("Leonardo", "12345678901");
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa2);
		pessoas.add(pessoa1);
		pessoas.add(pessoa3);
		
		Pessoa primeiraPessoa = pessoas.stream().findFirst().get();
		System.out.println(primeiraPessoa);
	}
}
