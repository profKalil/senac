package escolha.model;

public class AlunoModel {
	private String nome;
	private int matricula;
	private String destinoEscolhido;
	
	public AlunoModel() {
		
	}
	
	public AlunoModel(int matricula) {
        this.matricula = matricula;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getDestinoEscolhido() {
        return destinoEscolhido;
    }

    public void setDestinoEscolhido(String destinoEscolhido) {
        this.destinoEscolhido = destinoEscolhido;
    }

}
