/*
RESUMO      : Classe do avião, onde ele vai para a pista sorteada e decola. (Pensei em avião pois seriam 12 threads independentes)
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */


package controller;

import java.util.concurrent.Semaphore;

public class Aviao extends Thread {
	
	private static Semaphore norte = new Semaphore(1);
	private static Semaphore sul = new Semaphore(1);
	private int id, pista;
	
	public Aviao(int pista, int ID) {
//		tudo o que eu configurar aqui vai acontecer assim que eu inicializo a thread, se eu colocar uma serie de comandos aqui posso acabar matando o paralelismo do meu código
		this.id = ID;
		this.pista = pista;
	}

@Override
public void run() {
	if (pista == 1) {
		
		try {
			sul.acquire();
			System.out.println("O Aviao #ID" + id + " entrou na pista sul");
			decolagem();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sul.release();
		}
		
	} else {
		try {
			norte.acquire();
			System.out.println("O Aviao #ID" + id + " entrou na pista norte");
			decolagem();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			norte.release();
		}
	}
}
	
	public void decolagem() {
		manobrar();
		taxiar();
		decolar();
		afastamento();
	}

	private void manobrar() {
		int tempo = (int) ((Math.random()*5+3));
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O Aviao #ID" + id + " manobrou");
	}

	private void taxiar() {
		int tempo = (int) ((Math.random()*6+5));
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O Aviao #ID" + id + " taxiou.");
	}

	private void decolar() {
		int tempo = (int) ((Math.random()*4+1));
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O Aviao #ID" + id + " decolou");
	}

	private void afastamento() {
		int tempo = (int) ((Math.random()*6+3));
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("O Aviao #ID" + id + " ja se afastou da pista o suficiente para a próxima decolagem.");
	}

}
