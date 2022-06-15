package com.projectairlines.controller;

public class ReturnString {

	public Runnable r = new Runnable() {
		public void run() {
			System.out.println(this);
			System.out.println(this.toString());
		}
	};

	public String toString() {
		return "ReturnString's custom toString()";
	}
	
}
