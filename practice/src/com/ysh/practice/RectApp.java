package com.ysh.practice;
import java.util.*;
	class Rectangle {
	
		int width;
		int height;
		
		public int getArea() {
			return width*height;
		}
	
	
	}
	
	public class RectApp {		
		
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();//��ü ����
		Scanner sc = new Scanner(System.in);
		System.out.print(">> ");
		rect.width = sc.nextInt();
		rect.height = sc.nextInt();
		System.out.println("�簢���� ������ : " + rect.getArea());
		sc.close();
		
		
		
		
		
	}

}