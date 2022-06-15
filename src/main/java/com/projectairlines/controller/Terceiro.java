package com.projectairlines.controller;

public class Terceiro extends Funcionario implements FuncionarioInterface {

	private String empresa;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	} 
	
	public void printaEmpresa() {
		System.out.println(empresa);
	}

	@Override
	public void printaSalario() {
		System.out.println("R$ 50.000,00");
	}
	
}
