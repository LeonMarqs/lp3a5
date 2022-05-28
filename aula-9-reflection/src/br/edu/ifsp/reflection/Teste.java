package br.edu.ifsp.reflection;

public class Teste {
	
	private String nome;
	
	public Teste() {
		
	}
	
	private void printUm() {
		System.out.println("Método privado: 1");
	}
	
	public Teste(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
