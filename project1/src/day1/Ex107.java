package day1;
public class Ex107 {
	public static void main(String[] args) {
		// 1. int 변수에 byte 값을 담기
		byte b = 10;
		int num = b; // 가능
		System.out.println(num); // 10
		// 이해 : 1바이트 공간에 있는 정보를 4바이트 공간으로 가져다 놓을 수 있음
		//		(정보의 손실 우려가 없음 ---> 가능)
		
		// 2. byte 변수에 int 값을 담기
		int num2 = 10;
		//byte b2 = num2; //ERR
		// 이해 : 4바이트 공간에 있는 정보를 1바이트 공간으로 가져다 놓을 수 없음
		//		(정보의 손실 우려가 있음 ---> 불가능)
	}
}
