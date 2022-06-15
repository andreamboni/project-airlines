package com.projectairlines.controller;

public class Funcionario implements FuncionarioInterface {

	private String nome;
	private String cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	public void funcionarioDemitido() {
		System.out.println("Funcionario demitido");
	}
	
	@Override
	public String toString() {
		return nome + ", " + cargo;
	}

	@Override
	public void printaSalario() {
		System.out.println("R$ 90.000,00");
	}
	
}
