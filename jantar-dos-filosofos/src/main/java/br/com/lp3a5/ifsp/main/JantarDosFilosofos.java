package br.com.lp3a5.ifsp.main;

import br.com.lp3a5.ifsp.entity.Filosofo;

public class JantarDosFilosofos {

	public static void main(String[] args) throws Exception {

		final Filosofo[] filosofos = new Filosofo[5];
		Object[] garfos = new Object[filosofos.length];

		for (int i = 0; i < garfos.length; i++) {
			garfos[i] = new Object();
		}

		for (int i = 0; i < filosofos.length; i++) {
			Object garfoEsquerdo = garfos[i];
			Object garfoDireito = garfos[(i + 1) % garfos.length];

			if (i == filosofos.length - 1) {
				// O último filósofo pega o garfo da direita primeiro
				filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo);
			} else {
				// Todos os outros começam pelo garfo da esquerda
				filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);
			}

			Thread t
					= new Thread(filosofos[i], "Filósofo " + (i + 1));
			t.start();
		}
	}
}

