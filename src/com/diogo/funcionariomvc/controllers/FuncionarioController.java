package com.diogo.funcionariomvc.controllers;

import com.diogo.funcionariomvc.models.FuncionarioModel;
import com.diogo.funcionariomvc.vos.Funcionario;

public class FuncionarioController {
	private FuncionarioModel funcionarioModel;
	
	public FuncionarioController() {
		funcionarioModel = new FuncionarioModel();
	}
	
	public boolean incluir(Funcionario funcionario) {
		return funcionarioModel.incluir(funcionario);
	}
}
