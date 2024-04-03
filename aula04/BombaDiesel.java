package br.senac.aula04.bomba;

public class BombaDiesel extends Bomba {
	private String tipo;
	
	public BombaDiesel() {}
	/*public BombaDiesel(double quantidade, double preco, double litrosVendidos, String tipo) {
		super(quantidade, preco, litrosVendidos);
		this.tipo = tipo;
	}*/
	public BombaDiesel(double quantidade, double preco, double litrosVendidos, String tipo) {
		super(quantidade, preco, litrosVendidos);
		this.tipo = tipo;
	}
}
