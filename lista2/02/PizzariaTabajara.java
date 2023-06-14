package br.sc.senac.exercicios.lista1;

import java.util.*;

/*
Algoritmo -> Sistema de divisão de fatias de uma Pizzaria em até 12 fatias;
		  -> Broto(2 sabores e ate 4 fatias), Media(3 sabores e ate 6 fatias)
		  -> Grande(4 sabores e ate 9 fatias) e Gigante(4 sabores ate 12 fatias)
	  -> O cliente escolhe o tamanho da pizza, a quantidade de sabores e quantidade 
	     de fatias conforme as regras acima!
		  
Por Kalil de Oliveira, 21 de maio de 2023
https://github.com/profkalil
*/

public class PizzariaTabajara {
	static Scanner sc = new Scanner(System.in);
	
public static void main (String[] args) {
	escolhePizza();
}
public static void escolhePizza() {
	System.out.println ("\nBem-vindo à pizzaria TABAJARA!");
	System.out.println ("Escolha um tipo de pizza->");
	System.out.println ("1 - Broto");
	System.out.println ("2 - Media");
	System.out.println ("3 - Grande");
	System.out.println ("4 - Gigante");
	System.out.print("Opcao nro -> ");
	
	int opcao = sc.nextInt();
	if (opcao ==1) {
		broto();
	}
	else if (opcao ==2) {
		media();
	}
	else if (opcao ==3) {
		grande();
	}
	else if (opcao ==4) {
		gigante();
	}
	else {
		System.out.println("Opcao invalida!");
	}

}
public static void broto() {
	
	String tipo="Broto";
	System.out.println("\nVocê pode escolher até dois sabores");
	System.out.print ("Quantidade Sabores -> ");
	int qtdadeSabores = sc.nextInt();
		if (qtdadeSabores>0 && qtdadeSabores<=2) {
			System.out.println("\nVocê pode escolher até quatro fatias");
			System.out.print ("Quantidade fatias -> ");
			int qtdadeFatias = sc.nextInt();
				if (qtdadeFatias>0 && qtdadeFatias<4) {
					imprimePedido(tipo, qtdadeSabores, qtdadeFatias);
				} else {
					System.out.println("Erro");
				}
	} else {
		System.out.println("Erro");
	}
}

public static void media() {
	
	String tipo="Media";
	System.out.println("\nVocê pode escolher até tres sabores");
	System.out.print ("Quantidade Sabores -> ");
	int qtdadeSabores = sc.nextInt();
		if (qtdadeSabores>0 && qtdadeSabores<=3) {
			System.out.println("\nVocê pode escolher até seis fatias");
			System.out.print ("Quantidade fatias -> ");
			int qtdadeFatias = sc.nextInt();
				if (qtdadeFatias>0 && qtdadeFatias<=6) {
					imprimePedido(tipo, qtdadeSabores, qtdadeFatias);
				} else {
					System.out.println("Erro");
				}
	} else {
		System.out.println("Erro");
	}
}

public static void grande() {
	
	String tipo="Grande";
	System.out.println("\nVocê pode escolher até quatro sabores");
	System.out.print ("Quantidade Sabores -> ");
	int qtdadeSabores = sc.nextInt();
		if (qtdadeSabores>0 && qtdadeSabores<=4) {
			System.out.println("\nVocê pode escolher até nove fatias");
			System.out.print ("Quantidade fatias -> ");
			int qtdadeFatias = sc.nextInt();
				if (qtdadeFatias>0 && qtdadeFatias<=9) {
					imprimePedido(tipo, qtdadeSabores, qtdadeFatias);
				} else {
					System.out.println("Erro");
				}
		} else {
			System.out.println("Erro");
		}
}

public static void gigante() {
	
	String tipo="Gigante";
	System.out.println("\nVocê pode escolher até quatro sabores");
	System.out.print ("Quantidade Sabores -> ");
	int qtdadeSabores = sc.nextInt();
		if (qtdadeSabores>0 && qtdadeSabores<=4) {
			System.out.println("\nVocê pode escolher até doze fatias");
			System.out.print ("Quantidade fatias -> ");			
			int qtdadeFatias = sc.nextInt();
				if (qtdadeFatias>0 && qtdadeFatias<=12) {
					imprimePedido(tipo, qtdadeSabores, qtdadeFatias);
				}else {
					System.out.println("Erro");
				}		
		} else {
			System.out.println("Erro");
		}
	
}

public static void imprimePedido(String tipo, int qtdadeSabores, int qtdadeFatias) {
	System.out.println("\n\nObrigado por escolher a pizzaria TABAJARA!");
	System.out.println("Pizza escolhida -> "+tipo);
	System.out.println("Quantidade de sabores -> "+qtdadeSabores);
	System.out.println("Quantidade de fatias -> "+qtdadeFatias);
}	
}
