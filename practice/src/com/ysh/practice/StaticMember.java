package com.ysh.practice;

import java.util.*;

class CurrencyConverter {
	private static double rate;// 1달러에 대한 원화

	public static double toDollar(double won) {
		return won / rate;// 원화를 달러로 변환
	}

	public static double toKWR(double dollar) {
		return dollar * rate;// 달러를 원화로 변환
	}

	public static void setRate(double r) {
		rate = r;// 환율 설정. 원/1달러
	}
}

public class StaticMember {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("환율 (1달러)>>");
		double rate = sc.nextDouble();
		CurrencyConverter.setRate(rate);// 미국 달러 환율 설정
		System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다.");
		System.out.println("$100는" + CurrencyConverter.toKWR(100) + "원 입니다.");
		sc.close();
	}

}
