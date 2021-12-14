package com.coderm.basics.javaBasics.day06.java3;
/*
 * ��ĳ�Ա֮�ģ�����飨���ʼ���飩
 * 
 * 1. ���������ã�������ʼ���ࡢ����
 * 2. �������������εĻ���ֻ��ʹ��static.
 * 3. ���ࣺ��̬�����  vs �Ǿ�̬�����
 * 
 * 4. ��̬�����
 * 	   >�ڲ�������������
 * 	   >������ļ��ض�ִ��,����ִֻ��һ��
 * 	   >���ã���ʼ�������Ϣ
 * 	   >���һ�����ж����˶����̬����飬�����������Ⱥ�˳��ִ��
 * 	   >��̬������ִ��Ҫ�����ڷǾ�̬������ִ��
 * 	   >��̬�������ֻ�ܵ��þ�̬�����ԡ���̬�ķ��������ܵ��÷Ǿ�̬�Ľṹ
 * 
 * 5. �Ǿ�̬�����
 * 		>�ڲ�������������
 * 		>���Ŷ���Ĵ�����ִ��
 * 		>ÿ����һ�����󣬾�ִ��һ�ηǾ�̬�����
 * 		>���ã������ڴ�������ʱ���Զ�������ԵȽ��г�ʼ��
 * 		>���һ�����ж����˶���Ǿ�̬����飬�����������Ⱥ�˳��ִ��
 * 		>�Ǿ�̬������ڿ��Ե��þ�̬�����ԡ���̬�ķ�������Ǿ�̬�����ԡ��Ǿ�̬�ķ���
 * 
 */
public class BlockTest {
	public static void main(String[] args) {
		
		String desc = Person.desc;
		System.out.println(desc);
		
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.age);
		
		Person.info();
	}
}


class Person{
	//����
	String name;
	
	int age;

	static String desc = "����һ����";
	
	//������
	public Person(){
		
	}
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//��static�Ĵ����
	{
		System.out.println("hello, block - 2");
	}
	{
		System.out.println("hello, block - 1");
		//���÷Ǿ�̬�ṹ
		age = 1;
		eat();
		//���þ�̬�ṹ
		desc = "����һ����ѧϰ����1";
		info();
	}
	//static�Ĵ����
	static{
		System.out.println("hello,static block-2");
	}
	static{
		System.out.println("hello,static block-1");
		//���þ�̬�ṹ
		desc = "����һ����ѧϰ����";
		info();
		//�����Ե��÷Ǿ�̬�ṹ
//		eat();
//		name = "Tom";
	}
	
	//����
	public void eat(){
		System.out.println("�Է�");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public static void info(){
		System.out.println("����һ�����ֵ��ˣ�");
	}
	
}