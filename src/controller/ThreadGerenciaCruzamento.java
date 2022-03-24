package controller;

import java.util.concurrent.Semaphore;

public class ThreadGerenciaCruzamento extends Thread {
	private int id = 1;
	private Semaphore semaforo;

	public ThreadGerenciaCruzamento(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			carros();
			sleep(4000);
			System.out.println("Carro #" + id + " passou o cruzamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carros() {
		if (id % 4 == 1) {
			System.out.println("Carro #" + id + " está indo para o Norte");
		} else if (id % 4 == 1) {
			System.out.println("Carro #" + id + " está indo para o Sul");
		} else if (id % 4 == 2) {
			System.out.println("Carro #" + id + " está indo para o Leste");
		} else {
			System.out.println("Carro #" + id + " está indo para o Oeste");
		}
	}
}
