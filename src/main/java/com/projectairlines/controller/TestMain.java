package com.projectairlines.controller;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		Funcionario f = new Funcionario();
		f.setNome("Marilinda");
		f.setCargo("Linda");
		
		System.out.println(f);
		
		Funcionario fu = new Funcionario() {
			
			public void funcionarioDemitido() {
				System.out.println("Esse funcionario foi demitido"); 
			}
			
			@Override
			public void printaSalario() {
				System.out.println("R$ 150.000,00");
			}
			
		};
		
		fu.funcionarioDemitido();
		
		List<String> eldenRingPersonagens = new ArrayList<String>();
		eldenRingPersonagens.add("Marika");
		eldenRingPersonagens.add("Radagon");
		eldenRingPersonagens.add("Melina");
		
		
		System.out.println(eldenRingPersonagens);
		
		Terceiro t = new Terceiro();
		t.setNome("Alipio");
		t.setCargo("Tech lead");
		t.setEmpresa("Kyndryl");
		
		System.out.println(t);
		t.printaEmpresa();
		t.funcionarioDemitido();
		
		Terceiro t2 = new Terceiro() {

			@Override
			public void funcionarioDemitido() {
				System.out.println("t2 demitido");
			}
			
			@Override
			public void printaEmpresa() {
				System.out.println("IBM");
			}
			
		};
		
		t2.funcionarioDemitido();
		t2.printaEmpresa();
		
		t.printaSalario();
		
		fu.printaSalario();
		
	}
	
}
