package com.ysh.Element;

//연산 %*/
public class BioCalendar02 {
	// 상수(개발자 정의),상수값은 변결 불가
	public static final int PHYSICAL = 23;

	public static void main(String[] args) {
		int index = PHYSICAL; // 상수값을 변수에 대입.
		int days = 1200;
		// Math.PI3.14 에서 정의되어 있는 상수
		double vals = (days % index) * 2 * Math.PI / index;
		System.out.println(Math.toDegrees(vals) + "도");

	}

}
