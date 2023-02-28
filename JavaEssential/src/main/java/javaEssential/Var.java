package javaEssential;

public class Var {

	public static void main(String[] args) {//java10 부터 var 적용 가능.
		int price = 200; // price는 int 타입으로 결정
		String name = "kate"; // name은 String 타입으로 결정
		double pi = 3.14; // pi는 double 타입으로 결정

		System.out.println("price = " + (price + 1000));
		System.out.println("name = " + name);
		System.out.println("pi =  " + pi * 10);
	}
}
