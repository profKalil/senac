package controller;

import model.CadastroModel;

public class CadastroController {
	private CadastroModel model = new CadastroModel();
	
	public void setNomeController(String nome) {
		model.setNomeModel(nome);
	}
	public String getNomeController() {
		return model.getNomeModel();
	}
}
