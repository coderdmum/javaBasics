package com.coderm.basics.javaBasics.day08.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * try-catch-finally��finally��ʹ�ã�
 * 
 * 
 * 1.finally�ǿ�ѡ��
 * 
 * 2.finally����������һ���ᱻִ�еĴ��롣��ʹcatch���ֳ����쳣�ˣ�try����return��䣬catch����
 * return���������
 * 
 * 3.�����ݿ����ӡ������������������Socket����Դ��JVM�ǲ����Զ��Ļ��յģ�������Ҫ�Լ��ֶ��Ľ�����Դ��
 *   �ͷš���ʱ����Դ�ͷţ�����Ҫ������finally�С�
 * 
 * 
 * 
 */
public class FinallyTest {
	

	@Test
	public void test2(){
		FileInputStream fis = null;
		try {
			File file = new File("hello1.txt");
			fis = new FileInputStream(file);
			
			int data = fis.read();
			while(data != -1){
				System.out.print((char)data);
				data = fis.read();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void testMethod(){
		int num = method();
		System.out.println(num);
	}
	
	public int method(){
		
		try{
			int[] arr = new int[10];
			System.out.println(arr[10]);
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			return 2;
		}finally{
			System.out.println("��һ���ᱻִ��");
			return 3;
		}
		
		
	}
	
	@Test
	public void test1(){
		try{
			int a = 10;
			int b = 0;
			System.out.println(a / b);
			
		}catch(ArithmeticException e){
			e.printStackTrace();
			
//			int[] arr = new int[10];
//			System.out.println(arr[10]);
			
		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("�Һ�˧��������~~");
		
		finally{
			System.out.println("�Һ�˧��~~");
		}
		
	}
	
}
