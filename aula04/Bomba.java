package br.senac.aula04.bomba;

public class Bomba {
	  private double quantidade;	   // quantidade de combustível na bomba
	  private double preco;   		  // preço do combustível
	  private double litrosVendidos;  // quantidade de litros vendidos

	  public Bomba(){}
	  public Bomba(double quantidade, double preco, double litrosVendidos) {
	    this.quantidade = quantidade;
	    this.preco = preco;
	    this.litrosVendidos = litrosVendidos;
	  }

	  // get and set
	  public double getQuantidade() {
	    return quantidade;
	  }
	  public void setQuantidade(double quantidade) {
	    this.quantidade = quantidade;
	  }
	  public double getPreco() {
	    return preco;
	  }
	  public void setPreco(double preco) {
	    this.preco = preco;
	  }
	  public double getLitrosVendidos() {
	    return litrosVendidos;
	  }
	  public void setLitrosVendidos(double litrosVendidos) {
	    this.litrosVendidos = litrosVendidos;
	  }

	  // Outros métodos da clase
	  private double valorParaLitros(double valor) {
	    setPreco(valor);
	    return getPreco(); 
	  }
	  public boolean abastecerPorLitro(double litros){
	    boolean abastecer = (getQuantidade() >= litros);
	    setQuantidade(getQuantidade() - litros);
	      setLitrosVendidos(getLitrosVendidos() + litros);
	      return  abastecer;
	  }
	  public boolean abastecerPorValor(double valor) {
	    double litros = valorParaLitros(valor);
	    return abastecerPorLitro(litros);
	  }
	  
	}