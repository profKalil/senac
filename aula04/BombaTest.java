package br.senac.aula04.bomba;

public class BombaTest {
	public static void main(String[] args) {
		//Bomba bomba = new Bomba(100, 1, 5);
		//System.out.println("Abasteceu? Resposta: " + bomba.abastecerPorLitro(10));
		//System.out.println("Combustivel restante na bomba : " + bomba.getQuantidade());
		
		BombaDiesel bd = new BombaDiesel ();
		bd.setQuantidade(50);
		System.out.println ("Abasteceu? Resposta : " + bd.abastecerPorLitro(60));
		System.out.println("Combustivel restante na bomba : " + bd.getQuantidade());
		//BombaDiesel bd2 = new BombaDiesel (200, 1.0, 5, "S10");
		
	}
}
