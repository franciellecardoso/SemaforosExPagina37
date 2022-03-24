package view;

import java.util.concurrent.Semaphore;

import controller.ThreadGerenciaCruzamento;

public class Principal {

	public static void main(String[] args) {
		final int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int id = 1; id <= 4; id++) {
			Thread t = new ThreadGerenciaCruzamento(id, semaforo);
			t.start();
		}
	}
}
