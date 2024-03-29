package br.senac.aula03;

public class Tarefa {
	private String cod="";
	private String descr="";
	private int inicio=0;
	private int fim=0;
	
	//Método construtor
	public Tarefa() {}
	public Tarefa(String cod, String descr, int inicio, int fim) {
		setCod(cod);
		setDescr(descr);
		setInicio(inicio);
		setFim(fim);
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		if (cod.equals("")) {		
			this.cod = "Erro";
		} else {
			this.cod = cod;
		}
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFim() {
		return fim;
	}
	public void setFim(int fim) {
		this.fim = fim;
	}
	
	
}
