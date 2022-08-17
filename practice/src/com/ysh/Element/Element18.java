package com.ysh.Element;
//타입 변환의 필요성
public class Element18 {

	public static void main(String[] args) {
		String slat = "37.52127220511242";
		//String slat = "hello"
		//공백 제거 후 double 타입으로 변환
		double laitiude = Double.parseDouble(slat.trim());
		System.out.println(laitiude);
		
		
	}

}
