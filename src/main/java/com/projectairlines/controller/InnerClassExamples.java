package com.projectairlines.controller;

class Hello {

	public Runnable r = new Runnable() {
		public void run() {
			System.out.println(Hello.this);
			System.out.println(Hello.this.toString());
		}
	};

//	public String toString() {
//		return "Hello's custom toString()";
//	}

}

class Bye {
	public Runnable rr = new Runnable() {
		public void run() {
			System.out.println(this);
			System.out.println(toString());
		}
	};

	public String toString() {
		return "Bye's custom toString()";
	}
}

public class InnerClassExamples {
	public static void main(String... args) {
		Hello h = new Hello();
		h.r.run();
		
		Bye b = new Bye();
		b.rr.run();
		
		ReturnString rs = new ReturnString();
		rs.r.run();
	}
}
