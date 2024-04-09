package br.senac.baralho;

import java.util.Random;

public class Carta {
	private int numero;

	public int embaralhar() {
		Random r = new Random();
		setNumero(r.nextInt(13) + 1);
		return getNumero();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
