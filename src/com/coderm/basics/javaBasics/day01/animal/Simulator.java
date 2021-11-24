package com.coderm.basics.javaBasics.day01.animal;

public class Simulator {
	public void playSound(Animal animal){
		System.out.println("播放"+animal.getanimalsName());
		animal.cry();
	}

}
