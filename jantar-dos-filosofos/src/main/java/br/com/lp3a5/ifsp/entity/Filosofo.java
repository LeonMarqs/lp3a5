package br.com.lp3a5.ifsp.entity;

public class Filosofo implements Runnable {

	private final Object GarfoDaDireita;
	private final Object GarfoDaEsquerda;

	public Filosofo(Object GarfoDaEsquerda, Object GarfoDaDireita) {
		this.GarfoDaEsquerda = GarfoDaEsquerda;
		this.GarfoDaDireita = GarfoDaDireita;
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(((int) (Math.random() * 100)));
	}

	@Override
	public void run() {
		try {
			while (true) {

				// Pensando
				doAction(System.nanoTime() + ": Pensando");
				synchronized (GarfoDaEsquerda) {
					doAction(System.nanoTime() + ": Pegou garfo esquerdo");
					synchronized (GarfoDaDireita) {
						// Comendo
						doAction(System.nanoTime() + ": Pegou o garfo da direita - COMENDO");

						doAction(System.nanoTime() + ": Devolveu o garfo da direita");
					}

					// Voltar a pensar
					doAction(System.nanoTime() + ": Devolveu o garfo da esquerda. Voltou a pensar");
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

