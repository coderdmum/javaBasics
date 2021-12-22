package com.coderm.basics.javaBasics.day07.java2;
/*
 * ����ڲ���Ա֮�壺�ڲ���
 * 1. Java������һ����A��������һ����B�У�����A�����ڲ��࣬��B��Ϊ�ⲿ��
 * 
 * 2.�ڲ���ķ��ࣺ��Ա�ڲ��ࣨ��̬���Ǿ�̬��  vs �ֲ��ڲ���(�����ڡ�������ڡ���������)
 * 
 * 3.��Ա�ڲ��ࣺ
 * 		һ���棬��Ϊ�ⲿ��ĳ�Ա��
 * 			>�����ⲿ��Ľṹ
 * 			>���Ա�static����
 * 			>���Ա�4�ֲ�ͬ��Ȩ������
 * 
 * 		��һ���棬��Ϊһ���ࣺ
 * 			> ���ڿ��Զ������ԡ���������������
 * 			> ���Ա�final���Σ���ʾ���಻�ܱ��̳С�����֮�⣬��ʹ��final���Ϳ��Ա��̳�
 * 			> ���Ա�abstract����
 * 
 * 
 * 4.��ע���µ�3������
 *   4.1 ���ʵ������Ա�ڲ���Ķ���
 *   4.2 ����ڳ�Ա�ڲ��������ֵ����ⲿ��Ľṹ
 *   4.3 �����оֲ��ڲ����ʹ��  ����InnerClassTest1.java��
 * 
 */
public class InnerClassTest {
	public static void main(String[] args) {
		
		//����Dogʵ��(��̬�ĳ�Ա�ڲ���):
		Person.Dog dog = new Person.Dog();
		dog.show();
		//����Birdʵ��(�Ǿ�̬�ĳ�Ա�ڲ���):
//		Person.Bird bird = new Person.Bird();//�����
		Person p = new Person();
		Person.Bird bird = p.new Bird();
		bird.sing();
		
		System.out.println();
		
		bird.display("���");
		
	}
}


class Person{
	
	String name = "С��";
	int age;
	
	public void eat(){
		System.out.println("�ˣ��Է�");
	}
	
	
	//��̬��Ա�ڲ���
	static class Dog{
		String name;
		int age;
		
		public void show(){
			System.out.println("����������");
//			eat();
		}
		
	}
	//�Ǿ�̬��Ա�ڲ���
	class Bird{
		String name = "�ž�";
		
		public Bird(){
			
		}
		
		public void sing(){
			System.out.println("����һֻСС��");
			Person.this.eat();//�����ⲿ��ķǾ�̬����
			eat();
			System.out.println(age);
		}
		
		public void display(String name){
			System.out.println(name);//�������β�
			System.out.println(this.name);//�ڲ��������
			System.out.println(Person.this.name);//�ⲿ�������
		}
	}
	
	
	public void method(){
		//�ֲ��ڲ���
		class AA{
			
		}
	}
	
	{
		//�ֲ��ڲ���
		class BB{
			
		}
	}
	public Person(){
		//�ֲ��ڲ���
		class CC{
			
		}
	}
	
	
	
}