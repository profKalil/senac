package metas.jpa;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario", schema = "dbmetas", catalog = "dbmetas")

public class Usuario {
	@Id
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String email;

    // Getters and setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
    	return  "Cpf " + cpf + "\n" +
    		    "Nome " + nome + "\n" + 
    			"Email " + email + "\n\n";
    }
    
}
