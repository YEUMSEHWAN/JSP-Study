package com.ysh.practice;

public class Circle2 {
	int radius;
	String name;

	public Circle2() {// 매개변수가 없는 생성자
		// 필드 초기화
		radius = 1;
		name = "";
	}

	public Circle2(int r, String n) {// 매개변수를 가진 생성자
		radius = r;
		name = n;
	}

	public double getArea() {
		return 3.14 * radius * radius;

	}

	public static void main(String[] args) {
		Circle2 pizza = new Circle2(10, "자바피자");

		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);

		Circle2 donut = new Circle2();// 객체생성. 반지름을 1, 이름을""로 초기화
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);

	}

}
