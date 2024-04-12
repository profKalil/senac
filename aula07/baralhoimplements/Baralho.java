package br.senac.baralhoimplements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class Baralho implements Carta {
	private final String PAUS="Paus", OURO="Ouro", COPAS="Copas", ESPADA="Espada";
	private String cartaEscolhida;
	
	public Baralho() {
		setCartaEscolhida(embaralhar());
		System.out.println("Carta escolhida: "+getCartaEscolhida());
		gravarCarta();
	}

	@Override
	public String embaralhar() {
		Random random = new Random();
		try {
			int numero = random.nextInt(52) + 1;
			if (numero <= 13) {
				return this.PAUS+" "+String.valueOf(numero);
			} else if (numero > 13 && numero <= 26) {
				return this.OURO+" "+String.valueOf(numero-13);
			} else if (numero > 26 && numero <= 39) {
				return this.COPAS+" "+String.valueOf(numero-26);
			} else if (numero > 39 && numero <= 52) {
				return this.ESPADA+" "+String.valueOf(numero-39);
			}
		} catch (Exception e) {
			return " "+e;
		}
		return "";
	}

	@Override
	public void gravarCarta() {
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("carta.txt", true));
            writer.append(getCartaEscolhida());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);;
        }
		
	}

	public String getCartaEscolhida() {
		return cartaEscolhida;
	}

	public void setCartaEscolhida(String cartaEscolhida) {
		this.cartaEscolhida = cartaEscolhida;
	}
	
	
}
