package com.coderm.basics.javaBasics.day04.Polymorphism;

public class Woman extends Person{
	
	boolean isBeauty;
	
	public void goShopping(){
		System.out.println("女人喜欢购物");
	}
	
	public void eat(){
		System.out.println("女人少吃，为了减肥");
	}
	
	public void walk(){
		System.out.println("女人窈窕的走路");
	}
}
