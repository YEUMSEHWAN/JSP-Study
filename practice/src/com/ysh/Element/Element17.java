package com.ysh.Element;
//사용자 정의 클래스

//파일 이름과 클래스 이름이 다르기 때문에 public을 붙일수 없다.
class JLocation{
	//위도,경도 값을 double 타입으로 저장.(클래스 바로 아래 선언한 변수(멤버변수)는 자동으로 초기화한다.
	public double lat;
	public double lng;
}

public class Element17 {
	public static void main(String[] args) {
		
		//두 개의 기본 타입
		double latitude= 37.52127220511242;
		double longitude = 127.0074462890625;
		//사용자 정의 객체를 생성
		JLocation jloc = new JLocation();
		jloc.lat = latitude;//값을 대입
		jloc.lng = longitude; // 값을 대입
		
		JLocation newLoc= jloc; //객체를 대입
		System.out.println(newLoc.lat);//출력
		
	}

}
