package br.edu.ifsp.prodconsum;

import java.util.LinkedList;

public class ProdutorConsumidorExemplo {
	public static void main(String[] args) throws InterruptedException {

		final ProdutorConsumidor prodConsum = new ProdutorConsumidor();

		// Cria thread do produtor
		Thread threadProd = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					prodConsum.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Cria thread do consumidor
		Thread threadConsum = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					prodConsum.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadProd.start();
		threadConsum.start();

		// threadProd termina antes da threadConsum
		threadProd.join();
		threadConsum.join();
	}

	public static class ProdutorConsumidor {

		// Cria uma lista compartilhada entre o produtor e consumidor
		LinkedList<Integer> listaCompartilhada = new LinkedList<>();
		int capacidade = 2;

		// Função chamada pela thread do produtor
		public void produce() throws InterruptedException {
			int valor = 0;
			while (true) {
				synchronized (this) {
					// Thread do produtor espera enquanto a lista está cheia
					while (listaCompartilhada.size() == capacidade)
						wait();

					System.out.println("PRODUTOR produziu -" + valor);

					// insere o trabalho na lista
					listaCompartilhada.add(valor++);

					// Notifica a thread do consumidor
					// que ele pode começar a consumir
					notify();

					// faz o programa ser mais fácil de entender
					Thread.sleep(1000);
				}
			}
		}

		// Função chamada pela thread do consumidor
		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					// thread do consumidor espera enquanto a lista está vazia
					while (listaCompartilhada.size() == 0)
						wait();

					// Retornar o primeiro trabalho da lista
					int primeiroTrabalho = listaCompartilhada.removeFirst();

					System.out.println("CONSUMIDOR consumiu-" + primeiroTrabalho);

					// Acorda a thread do produtor
					notify();

					// e dorme
					Thread.sleep(1000);
				}
			}
		}
	}
}